package com.checklist.flows;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import oracle.adf.core.ADFBrowser;
import oracle.adf.core.ADFManager;
import oracle.adf.scripts.ADFBaseScript;
import oracle.adf.widgets.WidgetInfo;

import org.reflections.Reflections;

import com.checklist.screens.BaseScreen;

public class BaseFlow {
	
	Map<String, BaseScreen> screenMap = new HashMap<String, BaseScreen>();
	
	public BaseFlow()
	{
		Reflections ref = new Reflections("com.checklist.screens");
		Set<Class<? extends BaseScreen>> screens = ref.getSubTypesOf(BaseScreen.class);
		for(Class<?> screen : screens)
		{
			BaseScreen obj;
			try {
				obj = (BaseScreen) screen.newInstance();
				screenMap.put(obj.getExpectedScreenID(), obj );
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void launchApp()
	{
		ADFBrowser browser = new ADFBrowser();
		browser.startBrowser(ADFBaseScript.globalConfig.get("appUrl"));
	}
	
	public void waitForScreenToReady(WidgetInfo expectedWidget)
	{
		if(null != expectedWidget)
		ADFManager.getInstance().waitForWidget(expectedWidget, 60, 2);
	}
}
