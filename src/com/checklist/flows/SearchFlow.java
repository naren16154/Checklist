package com.checklist.flows;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import oracle.adf.core.AutoPopulator;
import oracle.adf.utilities.ADFLogger;
import oracle.adf.utilities.ScreenShotUtility;

import com.checklist.screens.BaseScreen;
import com.checklist.screens.Login;

public class SearchFlow extends BaseFlow{
	
	ScreenShotUtility sc= ScreenShotUtility.getInstance();
	
	public void run(Map<String, List<Map<String, String>>> dataMap) throws Exception {
		launchApp();
		BaseScreen screenObject = null;
		Method method = null;
		for(Map<String, String> rowData : dataMap.get("TestCase"))
		{
			for(String field : rowData.keySet())
			{
				if(null != (method=AutoPopulator.methodFound(new Login(), field))){
					ADFLogger.getInstance().method(field+" -- invoked in screen : BaseScreen");
						method.invoke(new Login(), rowData.get(field));
				}
				else
				{
					String fieldName = rowData.get(field); 
					if(fieldName.contains("("))
						fieldName = fieldName.substring(0, fieldName.lastIndexOf("("));
					screenObject=screenMap.get(fieldName);
					if(null != screenObject)
					{
						waitForScreenToReady(screenObject.getExpectedWidget());
						screenObject.populateAndContinue(screenObject.getDataMap(rowData.get(field)));
					}
				else
					throw new Exception("Unable to find screen object");
				}
			}
		}
		
		/*for(String sheetName : dataMap.keySet())
		{
			if(sheetName.contains("Verification"))
				continue;
			screenObject = screenMap.get(sheetName);
			if(null != screenObject)
				screenObject.populateAndContinue(dataMap.get(sheetName));
			else
				throw new Exception("Unable to find screen object");
		}*/
	}
	
}
