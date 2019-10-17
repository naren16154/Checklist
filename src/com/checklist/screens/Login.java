package com.checklist.screens;

import oracle.adf.core.AutoPopulator;
import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.TextField;
import oracle.adf.widgets.WidgetInfo;

public class Login extends BaseScreen{

	public static final String EXPECTED_SCREEN_ID = "signIn";
	public static final String EXPECTED_SCREEN_TITLE = "";
	
	public static class Widgets
	{
		public static final WidgetInfo userID = new WidgetInfo("id=userid", TextField.class);
		public static final WidgetInfo password = new WidgetInfo("name=password", TextField.class);
		public static final WidgetInfo signIN_Button = new WidgetInfo("id=btnActive", Button.class);
	}
	
	public void login(String value)
	{
		if(!"Sign In".equals(adfManager.getCurrentWebDriver().getTitle()))
		{
			logout("Yes");
		}
		String[] values = value.split("/");
		adfManager.waitForWidget(Widgets.userID, 120, 2);
		AutoPopulator.populateWidget(Widgets.userID, "userID", values[0]);
		AutoPopulator.populateWidget(Widgets.password, "password", values[1]);
		sc.takeScreenshot();
		adfManager.button(Widgets.signIN_Button).click();
		adfManager.waitForPageToLoad();
	}
	
	@Override
	public String getExpectedScreenID() {
		return EXPECTED_SCREEN_ID;
	}

	@Override
	public String getExpectedScreenTitle() {
		return EXPECTED_SCREEN_TITLE;
	}

	@Override
	public WidgetInfo getExpectedWidget() {
		return Widgets.userID;
	}

	@Override
	public void next() {
		
	}

}
