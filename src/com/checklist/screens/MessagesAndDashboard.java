package com.checklist.screens;

import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.DropDown;
import oracle.adf.widgetactions.GUIWidget;
import oracle.adf.widgetactions.Link;
import oracle.adf.widgetactions.ListBox;
import oracle.adf.widgetactions.TextArea;
import oracle.adf.widgetactions.TextField;
import oracle.adf.widgets.WidgetInfo;

public class MessagesAndDashboard extends BaseScreen{
	
	public static final String EXPECTED_SCREEN_ID = "messagesAndDashboard";
	public static final String EXPECTED_SCREEN_TITLE = "";
	
	public static class Widgets
	{
		public static final WidgetInfo message_Tab = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:sdi3::disAcr", Link.class);
		public static final WidgetInfo message_Title = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it1::content", TextArea.class);
		public static final WidgetInfo message_Text = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it6::content", TextArea.class);
		public static final WidgetInfo create_Contact = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call4:ctb4", Link.class);
		public static final WidgetInfo contact_Title = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc7::content", ListBox.class);
		public static final WidgetInfo contact_Type = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc6::content", ListBox.class);
		public static final WidgetInfo contact_FreeText = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it15::content", TextField.class);
		public static final WidgetInfo contact_Responsibility = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc8::content", ListBox.class);
		public static final WidgetInfo contact_User = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:contactUsernameId::content", DropDown.class);
		public static final WidgetInfo contact_Ok = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:cb10", Button.class);
		public static final WidgetInfo contact_Cancel = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:cb11", Button.class);
		
		public static final WidgetInfo dashboard_Tab = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:sdi4::disAcr", Link.class);
		public static final WidgetInfo dashboard_Notes = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:ph2", GUIWidget.class);
		
		public static final WidgetInfo create_Note = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call1:ctb8", Link.class);
		public static final WidgetInfo note_Title = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it4::content", TextField.class);
		public static final WidgetInfo note_Description = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it12::content", TextField.class);
		public static final WidgetInfo note_Status= new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc9::content", ListBox.class);
		public static final WidgetInfo note_Type = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc5::content", ListBox.class);
		public static final WidgetInfo event_Location = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it10::content", TextField.class);
		public static final WidgetInfo Note_Event_Date = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:id3::content", TextField.class);
		public static final WidgetInfo Note_Event_Offset = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it9::content", TextField.class);
		public static final WidgetInfo event_Time = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it16::content", TextField.class);
		public static final WidgetInfo note_Ok = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:addOk", Button.class);
		public static final WidgetInfo note_Cancel = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:addCancel", Button.class);
		public static final WidgetInfo note_SelectAdd = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call1:ctb9", Link.class);
		
		public static final WidgetInfo create_News = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call3:ctb3", Link.class);
		public static final WidgetInfo news_Category = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc4::content", ListBox.class);
		public static final WidgetInfo news_Title = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it4::content", TextField.class);
		public static final WidgetInfo news_Status = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc9::content", ListBox.class);
		public static final WidgetInfo news_Url = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it13::content", TextField.class);
		public static final WidgetInfo News_Event_Date = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:id3::content", TextField.class);
		public static final WidgetInfo news_Event_Offset = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it9::content", TextField.class);
		public static final WidgetInfo news_ImageUrl = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:id3::content", TextField.class);
		public static final WidgetInfo news_Ok = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:addOk", Button.class);
		public static final WidgetInfo news_Cancel = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:addCancel", Button.class);
		public static final WidgetInfo news_SelectAdd = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call3:ctb6", Link.class);
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
		return Widgets.message_Tab;
	}

	@Override
	public void next() {
	}
	
}
