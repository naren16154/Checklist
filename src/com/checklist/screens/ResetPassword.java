package com.checklist.screens;

import java.util.LinkedHashMap;
import java.util.Map;

import oracle.adf.core.AutoPopulator;
import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.Link;
import oracle.adf.widgetactions.RadioButton;
import oracle.adf.widgetactions.Table;
import oracle.adf.widgetactions.TextField;
import oracle.adf.widgets.WidgetInfo;

public class ResetPassword extends BaseScreen{

	public static final String EXPECTED_SCREEN_ID = "securityConsole";
	public static final String EXPECTED_SCREEN_TITLE = "";
	
	public static class Widgets
	{
		public static final WidgetInfo usersTab = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTsdiASE_FUSE_UM_WORKAREA::disAcr", Link.class);
		public static final WidgetInfo search = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTr1:1:pt1:smc1::content", TextField.class);
		public static final WidgetInfo searchText = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTr1:1:pt1:f1:it1::content", TextField.class);
		public static final WidgetInfo searchIcon = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTr1:1:pt1:f1:cil1", Link.class);
		public static final WidgetInfo resultsTable = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTr1:1:pt1:usrList", Table.class);
		public static final WidgetInfo actionButton = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTr1:1:pt1:usrList:0:cb1", Button.class);
		public static final WidgetInfo manual_Radio = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTr1:1:pt1:rReset:0:pt1:sor1:_1", RadioButton.class);
		public static final WidgetInfo newPassword = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTr1:1:pt1:rReset:0:pt1:nPwIp::content", TextField.class);
		public static final WidgetInfo confirmPassword = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTr1:1:pt1:rReset:0:pt1:nPwIpC::content", TextField.class);
		public static final WidgetInfo resetButton = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTr1:1:pt1:rReset:0:pt1:rpSub", Button.class);
	}
	
	public void resetPassword(String userId)
	{
		navigator_Link("Security Console");
//		AutoPopulator.populateWidget(Widgets.usersTab, "usersTab", "click");
		adfManager.waitForWidget(Widgets.usersTab, 30, 2);
		adfManager.getJSExecutor().executeScript("arguments[0].click();", adfManagerHelper.getWebElement(Widgets.usersTab));
		adfManager.waitForWidget(Widgets.searchText, 30, 2);
		AutoPopulator.populateWidget(Widgets.searchText, "searchText", userId);
		AutoPopulator.populateWidget(Widgets.searchIcon, "searchIcon", "click");
		adfManager.waitForWidget(Widgets.resultsTable, 30, 2);
		AutoPopulator.populateWidget(Widgets.actionButton, "Action", "click");
		AutoPopulator.populateWidget(new WidgetInfo("xpath=//td[text()='Reset Password']", Link.class), "ResetPassword", "click");
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("manual_Radio", "Y");
		map.put("newPassword", "Welcome1");
		map.put("confirmPassword", "Welcome1");
		map.put("resetButton", "click");
		populate(map);
		adfManager.waitForAjaxToLoad();
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
		return null;
	}

	@Override
	public void next() {
		
	}

}
