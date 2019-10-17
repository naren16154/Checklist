package com.checklist.screens;

import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.DropDown;
import oracle.adf.widgetactions.GUIWidget;
import oracle.adf.widgetactions.Link;
import oracle.adf.widgetactions.ListBox;
import oracle.adf.widgetactions.TextArea;
import oracle.adf.widgetactions.TextField;
import oracle.adf.widgets.WidgetInfo;

import org.openqa.selenium.By;

public class Checklist extends BaseScreen{
	
	public static final String EXPECTED_SCREEN_ID = "Checklist";
	public static final String EXPECTED_SCREEN_TITLE = "";
	
	public static class Widgets
	{
		public static final WidgetInfo create_Checklist = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:0:AP1:ffs1:fs_subview_results:call1:createChkTemp", Link.class);
		public static final WidgetInfo checklist_Name = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it5::content", TextField.class);
		public static final WidgetInfo checklist_Description = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it3::content", TextArea.class);
		public static final WidgetInfo checklist_Status = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc3::content", ListBox.class);
		public static final WidgetInfo dateFrom = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:id1::content", TextField.class);
		public static final WidgetInfo dateTo = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:id2::content", TextField.class);
		public static final WidgetInfo country = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:countryNameId::content", DropDown.class);
		public static final WidgetInfo category = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc2::content", ListBox.class);
		public static final WidgetInfo actionName = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:checklistActionNameId::content", DropDown.class);
		public static final WidgetInfo eligibility_Profile = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:eligibilityProfileNameId::content", DropDown.class);
		public static final WidgetInfo assignmentDate = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc1::content", ListBox.class);
		public static final WidgetInfo completionDate = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:soc10::content", ListBox.class);
		public static final WidgetInfo assignment_Offset = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it2::content", TextField.class);
		public static final WidgetInfo completion_Offset = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it17::content", TextField.class);
		public static final WidgetInfo checklist_Save = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:APsv2", Link.class);
		public static final WidgetInfo checklist_SaveClose = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:APscl2", Link.class);
		public static final WidgetInfo checklist_Cancel = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:SPc", Link.class);
		public static final WidgetInfo tasks_Tab = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:sdi2::disAcr", Link.class);
		public static final WidgetInfo task_Create = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call2:ctb2", Link.class);
		public static final WidgetInfo message_Tab = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:sdi3::disAcr", Link.class);
		public static final WidgetInfo message_Title = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it1::content", TextArea.class);
		public static final WidgetInfo message_Text = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:it6::content", TextArea.class);
		public static final WidgetInfo create_Contact = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call4:ctb4", Link.class);
		public static final WidgetInfo dashboard_Tab = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:sdi4::disAcr", Link.class);
		public static final WidgetInfo dashboard_Notes = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:ph2", GUIWidget.class);
	}
	
	public void createChecklist(String value)
	{
		if("yes".equalsIgnoreCase(value))
		{
			adfManager.waitForWidget(Widgets.create_Checklist, 20, 3);
			adfManager.link(Widgets.create_Checklist).click();
			adfManager.waitForWidget(Widgets.checklist_Name, 20, 3);
		}
	}
	
	public void tasks(String value)
	{
		if(!adfManager.widgetVisible(Widgets.task_Create, 2, 1))
		{
			save("Yes");
			adfManager.link(Widgets.tasks_Tab).click();
			adfManager.waitForWidget(Widgets.task_Create, 10, 1);
		}
		Tasks tasks = new Tasks();
		tasks.populateAndContinue(getDataMap(value));
	}
	
	public void message(String value)
	{
		if("Yes".equalsIgnoreCase(value))
		{
			adfManager.link(Widgets.message_Tab).click();
			adfManager.waitForWidget(Widgets.message_Title, 10, 1);
		}
	}
	
	public void dashboard(String value)
	{
		if("Yes".equalsIgnoreCase(value))
		{
			adfManager.link(Widgets.dashboard_Tab).click();
			adfManager.waitForWidget(Widgets.dashboard_Notes, 10, 1);
		}
	}
	
	public void contacts(String value)
	{
		(new MessagesAndDashboard()).populateAll(getDataMap(value));
	}
	
	public void notes(String value)
	{
		(new MessagesAndDashboard()).populateAll(getDataMap(value));
	}
	
	public void news(String value)
	{
		(new MessagesAndDashboard()).populateAll(getDataMap(value));
	}
	
	public void save(String value)
	{
		if("Yes".equalsIgnoreCase(value))
		{
		adfManager.link(Widgets.checklist_Save).click();
		adfManager.waitForWidget(By.id("pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:SubmitConfirmDialog::_ttxt"), 5, 1);
		adfManager.button(new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:okcb", Button.class)).click();
		adfManagerHelper.sleep(1);
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
		return Widgets.create_Checklist;
	}

	@Override
	public void next() {
		
	}
}
