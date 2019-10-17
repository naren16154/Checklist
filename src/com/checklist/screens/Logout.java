package com.checklist.screens;

import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.Link;
import oracle.adf.widgets.WidgetInfo;

public class Logout extends BaseScreen{

	public static final String EXPECTED_SCREEN_ID = "logOut";
	public static final String EXPECTED_SCREEN_TITLE = "";
	
	public static class Widgets
	{
		public static final WidgetInfo userLink = new WidgetInfo("xpath=//a[@id='pt1:_UIScmil1u' or @id='_FOpt1:_UIScmil1u']", Link.class);
		public static final WidgetInfo signOutLink = new WidgetInfo("xpath=//a[@id='pt1:_UISlg1' or @id='_FOpt1:_UISlg1']", Link.class);
		public static final WidgetInfo confirm_Button = new WidgetInfo("id=Confirm", Button.class);
	}
	
	public void logout(String value)
	{
		if(value.equalsIgnoreCase("yes"))
		{
			adfManager.waitForWidget(Widgets.userLink, 60, 5);
			adfManager.link(Widgets.userLink).click();
			adfManager.waitForWidget(Widgets.signOutLink, 10, 2);
			adfManager.link(Widgets.signOutLink).click();
			WidgetInfo pageLeaveYes = new WidgetInfo("id=_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:0:MAyes", Button.class);
			if(adfManager.widgetExists(Widgets.confirm_Button, 30, 2))
				adfManager.button(Widgets.confirm_Button).click();
			else
			{
				adfManager.button(pageLeaveYes).click();
				adfManager.waitForWidget(Widgets.confirm_Button, 30, 1);
				adfManager.button(Widgets.confirm_Button).click();
			}
		}
			
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
		return Widgets.userLink;
	}

	@Override
	public void next() {
		
	}

}
