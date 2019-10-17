package com.checklist.screens;

import java.util.Map;

import oracle.adf.core.AutoPopulator;
import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.CheckBox;
import oracle.adf.widgetactions.DropDown;
import oracle.adf.widgetactions.Link;
import oracle.adf.widgetactions.ListBox;
import oracle.adf.widgetactions.Table;
import oracle.adf.widgetactions.TextArea;
import oracle.adf.widgetactions.TextField;
import oracle.adf.widgets.WidgetInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tasks extends BaseScreen{
	
	public static final String EXPECTED_SCREEN_ID = "tasks";
	public static final String EXPECTED_SCREEN_TITLE = "";
	
	public static class Widgets{
		public static final WidgetInfo task_Create = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call2:ctb2", Link.class);
		public static final WidgetInfo task_Select = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call2:ctb5", Link.class);
		public static final WidgetInfo task_Configure = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:1:ctpanel2:call2:ctb7", Link.class);
		public static final WidgetInfo task_Name = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:it1::content", TextField.class);
		public static final WidgetInfo task_Description = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:it2::content", TextArea.class);
		public static final WidgetInfo task_Status = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc1::content", ListBox.class);
		public static final WidgetInfo task_Elg_Profile = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:eligProfileNameId::content", DropDown.class);
		public static final WidgetInfo task_Sequence = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:it8::content", TextField.class);
		public static final WidgetInfo task_Checklist = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:checklistNameId::content", DropDown.class); 
		public static final WidgetInfo preceding_Task = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc12::content", ListBox.class);
		public static final WidgetInfo mandatory_Task = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:sbc1::content", CheckBox.class);
		public static final WidgetInfo target_Duration = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:inputText2::content", TextField.class);
		public static final WidgetInfo target_Duration_UOM = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:selectOneChoice2::content", ListBox.class);
		public static final WidgetInfo delay_Duration = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:it4::content", TextField.class);
		public static final WidgetInfo delay_Duration_UOM = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc4::content", ListBox.class);
		public static final WidgetInfo performer = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc10::content", ListBox.class);
		public static final WidgetInfo performer_AOR = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc5::content", ListBox.class);
		public static final WidgetInfo performer_User = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:performerUsernameId::content", DropDown.class);
		public static final WidgetInfo owner = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc8::content", ListBox.class);
		public static final WidgetInfo owner_User = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:ownerUsernameId::content", DropDown.class);
		public static final WidgetInfo owner_AOR = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc9::content", ListBox.class);
		public static final WidgetInfo action_type = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc2::content", ListBox.class);
		public static final WidgetInfo action_URL = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:it5::content", TextField.class);
		public static final WidgetInfo app_Task = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc3::content", ListBox.class);
		public static final WidgetInfo customForm = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc11::content", ListBox.class);
		public static final WidgetInfo customForm_Attachments = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:sbc3::content", CheckBox.class);
		public static final WidgetInfo customForm_Comments = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:sbc4::content", CheckBox.class);
		public static final WidgetInfo notificationReminders = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:sdi1::disAcr", Link.class);
		public static final WidgetInfo overrideScenario = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:AT1:_ATp:_tbx", ListBox.class);
		public static final WidgetInfo add_Button = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:AT1:_ATp:_tbx", Button.class);
		public static final WidgetInfo overrideTable = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:AT1:_ATp:ATt1", Table.class); 
		public static final WidgetInfo enableReminder = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:sbc2", CheckBox.class);
		public static final WidgetInfo reminder_Condition = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:soc6", ListBox.class);
		public static final WidgetInfo remindEvery = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:it7", TextField.class);
		public static final WidgetInfo reminder_repeat = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:it6", TextField.class);
		public static final WidgetInfo notes_Link = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:sdi2::disAcr", Link.class);
		public static final WidgetInfo notes_Title = new WidgetInfo("id=pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:it14::src", TextArea.class);
		public static final WidgetInfo saveAndClose = new WidgetInfo("xpath=//div[@id='pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:ctb3']//td[1]", Link.class);
	}
	
	public void createTask(String value)
	{
		adfManager.link(Widgets.task_Create).click();
		adfManager.widgetNotExists(Widgets.task_Create, 20, 1);
	}
	
	public void notificationAndReminder(String value)
	{
		adfManager.link(Widgets.notificationReminders).click();
		adfManager.widgetExists(Widgets.enableReminder, 20, 1);
	}
	
	public void notificationOverrides(String value)
	{
		for(Map<String, String> rowData : getDataMap(value))
		{
			AutoPopulator.populateWidget(Widgets.overrideScenario, "overrideScenario", rowData.get("overrideScenario"));
			AutoPopulator.populateWidget(Widgets.add_Button, "add_Button", "click");
			adfManager.waitForAjaxToLoad();
			if(rowData.containsKey("performer"))
				adfManager.table(Widgets.overrideTable).getCell("Performer", "Notify", rowData.get("overrideScenario")).findElement(By.tagName("input")).click();
			if(rowData.containsKey("owner"))
				adfManager.table(Widgets.overrideTable).getCell("Owner", "Notify", rowData.get("overrideScenario")).findElement(By.tagName("input")).click();
		}
	}
	
	public void notes(String value)
	{
		adfManager.waitForWidget(Widgets.notes_Link, 20, 1);
		adfManager.link(Widgets.notes_Link).click();
		if(!adfManager.widgetExists(Widgets.notes_Title, 20, 1))
			adfManager.link(Widgets.notes_Link).click();
		adfManager.waitForAjaxToLoad();
		adfManager.getCurrentWebDriver().switchTo().frame(adfManager.getCurrentWebDriver().findElement(By.id("pt1:r1:0:rt:1:r2:0:dynamicRegion1:0:pt1:pt_r1:2:AP1:it14::cont")));
		WebElement text= adfManager.getCurrentWebDriver().findElement(By.cssSelector("body"));
			text.click();
		adfManager.waitForAjaxToLoad();
		adfManager.getJSExecutor().executeScript("arguments[0].innerHTML = '"+value+"'", text);
		adfManager.getCurrentWebDriver().switchTo().defaultContent();
	}
	
	public void selectTask(String value)
	{
		adfManager.link(Widgets.task_Select).click();
		adfManager.widgetNotExists(Widgets.task_Select, 20, 1);
	}
	
	public void configureTask(String value) throws Exception
	{
		if(adfManager.widgetEnabled(Widgets.task_Configure, 2, 1))
		{
			adfManager.link(Widgets.task_Configure).click();
			adfManager.widgetNotExists(Widgets.task_Create, 20, 1);
		}
		else
			throw new Exception("Configure tasks button is disabled");
	}
	
	public void saveClose(String value)
	{
		if("Yes".equalsIgnoreCase(value))
		{
			adfManager.waitForAjaxToLoad();
			AutoPopulator.populateWidget(Widgets.saveAndClose, "saveAndClose", "click");
			adfManager.waitForWidget(Widgets.task_Create, 20, 1);
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
		return Widgets.task_Create;
	}

	@Override
	public void next() {
		
	}

}
