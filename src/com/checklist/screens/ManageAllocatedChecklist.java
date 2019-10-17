package com.checklist.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import oracle.adf.core.AutoPopulator;
import oracle.adf.core.Verify;
import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.DropDown;
import oracle.adf.widgetactions.Link;
import oracle.adf.widgetactions.ListBox;
import oracle.adf.widgetactions.Table;
import oracle.adf.widgetactions.TextField;
import oracle.adf.widgets.WidgetInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ManageAllocatedChecklist extends BaseScreen {
	
	public static final String EXPECTED_SCREEN_ID = "manageChecklist";
	public static final String EXPECTED_SCREEN_TITLE = "";
	
	public static class Widgets
	{
		public static final WidgetInfo createAndAdd = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:AP1:ATT1:_ATTp:commandButton2", Link.class);
		public static final WidgetInfo selectAndAdd = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:AP1:ATT1:_ATTp:commandImageLink2", Link.class);
		public static final WidgetInfo refresh = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:AP1:ATT1:_ATTp:ctb2", Link.class);
		public static final WidgetInfo delete = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:AP1:ATT1:_ATTp:commandImageLink1", Link.class);
		public static final WidgetInfo edit = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:AP1:ATT1:_ATTp:commandToolbarButton1", Link.class);
		public static final WidgetInfo duplicate = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:AP1:ATT1:_ATTp:commandImageLink4", Link.class);
		
		public static final WidgetInfo checklistName = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:1:AP2:q1:value00::content", TextField.class);
		public static final WidgetInfo country = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:1:AP2:q1:value10::content", DropDown.class);
		public static final WidgetInfo category = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:1:AP2:q1:value20::content", ListBox.class);
		public static final WidgetInfo actionName = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:1:AP2:q1:value30::content", DropDown.class);
		public static final WidgetInfo search = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:1:AP2:q1::search", Button.class);
		public static final WidgetInfo resultsTable = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:1:AP2:ATR1:_ATTp:tt1", Table.class);
		public static final WidgetInfo allocateButton = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:2:vacpanel3:vaccommandButton2", Button.class);
		public static final WidgetInfo allocationDate = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:2:vacpanel3:id1::content", TextField.class);
		public static final WidgetInfo allocate_Ok = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:2:vacpanel3:commandButton3", Button.class);
		public static final WidgetInfo confirmation = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:2:vacpanel3:vaccommandButton4", Button.class);
		public static final WidgetInfo allocatedChecklists = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:AP1:ATT1:_ATTp:tt1", Table.class);
	}
	
	public void allocate (String value)
	{
		adfManager.waitForWidget(Widgets.resultsTable,60,2);
		adfManager.waitForPageToLoad();
		adfManager.table(Widgets.resultsTable).getCell("Name", "Name", value).findElements(By.tagName("a")).get(1).click();
		adfManager.waitForAjaxToLoad();
		adfManager.waitForWidget(Widgets.allocateButton, 10, 1);
		AutoPopulator.populateWidget(Widgets.allocateButton, "allocateButton", "click");
		adfManager.waitForWidget(Widgets.allocationDate, 10, 1);
//		AutoPopulator.populateWidget(Widgets.allocationDate, "allocationDate", "");
		AutoPopulator.populateWidget(Widgets.allocate_Ok, "allocate_Ok", "click");
		adfManager.waitForWidget(Widgets.confirmation, 30, 1);
		AutoPopulator.populateWidget(Widgets.confirmation, "confirmation", "click");
		adfManager.waitForAjaxToLoad();
	}
	
	public boolean checklistExists(String value)
	{
		adfManager.waitForWidget(Widgets.allocatedChecklists,60,2);
		expandAll();
		for(int i=0; i<10; i++)
		{
			if(adfManager.table(Widgets.allocatedChecklists).recordExists("Name", value))
			{
				Verify.verifyEquals("Checklist :  "+value+" allocated successfully", true);
				return true;
			}
			adfManagerHelper.sleep(30);
			adfManager.link(Widgets.refresh).click();
			adfManager.waitForAjaxToLoad();
		}
		Verify.verifyEquals("Checklist :  "+value+" did not get allocated", false);
		return false;
	}
	
	public void verifyChecklistStatus(String value)
	{
		String checklist = value.split(":")[0];
		String statusExpected = value.split(":")[1];
		if(checklistExists(checklist))
		{
			WebElement record = adfManager.table(Widgets.allocatedChecklists).returnRow("Name", checklist);
			String statusActual = record.findElements(By.xpath("descendant::td[contains(@class,'af_column_data-cell')]")).get(1).findElement(By.tagName("img")).getAttribute("title").trim();
			Verify.verifyEquals("Checklist : "+checklist+" status :", statusExpected, statusActual);
		}
	}
	
	public void verifyTasktStatus(String value)
	{
		expandAll();
		String task = value.split(":")[0];
		String statusExpected = value.split(":")[1];
		if(checklistExists(task))
		{
			WebElement record = adfManager.table(Widgets.allocatedChecklists).returnRow("Name", task);
			String statusActual = record.findElements(By.xpath("descendant::td[contains(@class,'af_column_data-cell')]")).get(2).findElement(By.tagName("img")).getAttribute("title").trim();
			Verify.verifyEquals("Task : "+task+" status :", statusExpected, statusActual);
		}
	}
	
	public void verifyDetails(String value)
	{
		verifyData(getDataMap(value));
	}
	
	public void verifyData(List<Map<String, String>> screenData)
	{
		List<String> headers = getHeaders();
		for(Map<String, String> rowData : screenData)
		{
			if(!rowData.containsKey("name"))
				continue;
			String name= rowData.get("name");
			WebElement record= null;
			if(checklistExists(name))
				record = adfManager.table(Widgets.allocatedChecklists).returnRow("Name", name);
			else
				continue;
			adfLogger.info("Verifying the details of record : "+name);
			List<WebElement> dataCells = record.findElements(By.xpath("descendant::td[contains(@class,'af_column_data-cell')]"));
			String expectedValue;
			String actualValue;
			for (String fieldName : rowData.keySet()) {
				if(fieldName.toLowerCase().contains("status"))
				{
					try{
						actualValue = dataCells.get(headers.indexOf(fieldName.toLowerCase())).findElement(By.tagName("img")).getAttribute("title").trim();
					}catch(NoSuchElementException e){
						actualValue="";
					}
				}
				else
					actualValue = dataCells.get(headers.indexOf(fieldName.toLowerCase())).getText().trim();
				expectedValue = rowData.get(fieldName);
				Verify.verifyEquals(fieldName +" :",expectedValue, actualValue);
			}
		}
	}
	
	public List<String> getHeaders()
	{
		List<String> list = new ArrayList<String>();
		list.add("name");
		list.add("checkliststatus");
		list.add("taskstatus");
		list.add("targetstartdate");
		list.add("actualstartdate");
		list.add("targetenddate");
		list.add("actualenddate");
		list.add("performer");
		return list;
	}
	
	public void collapseAll()
	{
		for(WebElement element : adfManagerHelper.getWebElement(Widgets.allocatedChecklists).findElements(By.xpath("//a[@title='Collapse']")))
		{
			element.click();
			adfManager.waitForAjaxToLoad();
			adfManagerHelper.sleep(2);
		}
	}
	
	public void expandAll()
	{
		for(WebElement element : adfManagerHelper.getWebElement(Widgets.allocatedChecklists).findElements(By.xpath("//a[@title='Expand']")))
		{
			element.click();
			adfManager.waitForAjaxToLoad();
			adfManagerHelper.sleep(2);
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
		return Widgets.createAndAdd;
	}

	@Override
	public void next() {
		
	}

}
