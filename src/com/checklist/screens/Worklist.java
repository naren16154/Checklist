package com.checklist.screens;

import oracle.adf.core.AutoPopulator;
import oracle.adf.core.Verify;
import oracle.adf.widgetactions.Link;
import oracle.adf.widgetactions.ListBox;
import oracle.adf.widgetactions.Table;
import oracle.adf.widgetactions.TextField;
import oracle.adf.widgets.WidgetInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Worklist extends BaseScreen{

	public static final String EXPECTED_SCREEN_ID = "worklist";
	public static final String EXPECTED_SCREEN_TITLE = "";
	public static String notification;
	
	public static class Widgets
	{
		public static final WidgetInfo searchCriteria = new WidgetInfo("xpath=//*[contains(@id,'_FOTsr1:0:pt1:r3:1:tldc:statusFilter::content')]", ListBox.class);
		public static final WidgetInfo searchText = new WidgetInfo("xpath=//*[contains(@id,'_FOTsr1:0:pt1:r3:1:tldc:keywordFilter::content')]", TextField.class);
		public static final WidgetInfo searchIcon = new WidgetInfo("xpath=//*[contains(@id,'_FOTsr1:0:pt1:r3:1:tldc:searchButton1')]", Link.class);
		public static final WidgetInfo resultsTable = new WidgetInfo("xpath=//*[contains(@id,'_FOTsr1:0:pt1:r3:1:tldc:taskTable')]", Table.class);
	}
	
	public void searchNotification(String value)
	{
		if(value.contains(","))
			notification = value.split(",")[0].trim()+", "+HireAnEmployee.person_Num+" "+value.split(",")[1].trim();
		else
			notification = value+" ,  ("+HireAnEmployee.person_Num+")";
		if(!"Worklist - Worklist - Oracle Applications".equals(adfManagerHelper.getWebDriver().getTitle()))
			navigator_Link("Worklist");
		adfManager.waitForWidget(Widgets.searchText, 30, 2);
		AutoPopulator.populateWidget(Widgets.searchCriteria, "searchCriteria", "Any");
		AutoPopulator.populateWidget(Widgets.searchText, "searchText", notification);
		AutoPopulator.populateWidget(Widgets.searchIcon, "searchIcon", "click");
		adfManager.waitForAjaxToLoad();
	}
	
	public void action(String action)
	{
		adfManager.waitForWidget(Widgets.resultsTable, 30, 2);
		if(adfManager.table(Widgets.resultsTable).getRecordsCount()>0)
		{
			adfManager.table(Widgets.resultsTable).selectRow("Title", notification);
			WebDriver driver = adfManager.getCurrentWebDriver();
			adfManager.waitForAjaxToLoad();
			adfManager.waitForWidget(By.xpath("//a[text()='Actions']"), 5, 1);
			driver.findElement(By.xpath("//a[text()='Actions']")).click();
			adfManager.waitForWidget(By.xpath("//td[text()='"+action+"']"), 5, 1);
			driver.findElement(By.xpath("//td[text()='"+action+"']")).click();
			adfManager.waitForPageToLoad();
		}
		else
		{
			adfLogger.error("No Search results Found");
		}
	}
	
	public void verifyNotification(String value)
	{
		adfManager.waitForWidget(Widgets.resultsTable, 30, 2);
		if("Yes".equalsIgnoreCase(value))
		{
			if(adfManager.table(Widgets.resultsTable).recordExists("Title", notification))
				Verify.verifyEquals("Notification titled : "+notification+" present in Worklist", true);
			else
				Verify.verifyEquals("Notification titled : "+notification+" not present in Worklist", false);
		}
		if("No".equalsIgnoreCase(value))
		{
			if(adfManager.table(Widgets.resultsTable).recordExists("Title", notification))
				Verify.verifyEquals("Notification titled : "+notification+" present in Worklist", false);
			else
				Verify.verifyEquals("Notification titled : "+notification+" not present in Worklist", true);
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
		return null;
	}

	@Override
	public void next() {
		
	}

}
