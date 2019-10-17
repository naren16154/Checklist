package com.checklist.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import oracle.adf.core.AutoPopulator;
import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.Table;
import oracle.adf.widgetactions.TextField;
import oracle.adf.widgets.WidgetInfo;

public class PersonManagement extends BaseScreen{

	public static final String EXPECTED_SCREEN_ID = "personManagement";
	public static final String EXPECTED_SCREEN_TITLE = "";
	
	public static class Widgets
	{
		public static final WidgetInfo name = new WidgetInfo("xpath=//label[text()='Name']/../..//input", TextField.class);
		public static final WidgetInfo personNumber = new WidgetInfo("xpath=//label[text()='Person Number']/../..//input", TextField.class);
		public static final WidgetInfo effDate = new WidgetInfo("xpath=//label[text()='Effective As-of Date']/../..//input", TextField.class);
		public static final WidgetInfo search = new WidgetInfo("xpath=//button[text()='Search']", Button.class);
		public static final WidgetInfo resultsTable = new WidgetInfo("xpath=//*[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAt1:0:pt1:Perso1:0:SP3:table1:_ATp:table2' or @id='_FOpt1:_FOr1:0:_FOSritemNode_workforce_management_person_management:1:MAt1:0:pt1:Perso1:0:SP3:table1:_ATp:table2']", Table.class);
	}
	
	public void selectPerson(String value)
	{
		AutoPopulator.populateWidget(Widgets.search, "search", "click");
		adfManager.waitForWidget(Widgets.resultsTable, 60, 2);
		if(value.matches("[0-9]*"))
			adfManager.table(Widgets.resultsTable).selectRow(Integer.parseInt(value));
		else
		{
			String[] values = value.split(":");
			adfManager.table(Widgets.resultsTable).selectRow(values[0], values[1]);
		}
	}
	
	public void performAction(String value)
	{
		adfManager.waitForAjaxToLoad();
		WebDriver driver = adfManager.getCurrentWebDriver();
		adfManager.waitForWidget(By.xpath("//a[text()='Actions']"), 5, 1);
		driver.findElement(By.xpath("//a[text()='Actions']")).click();
		String[] values = value.split(":");
		adfManager.waitForWidget(By.xpath("//td[text()='"+values[0]+"']"), 5, 1);
		driver.findElement(By.xpath("//td[text()='"+values[0]+"']")).click();
		adfManager.waitForWidget(By.xpath("//td[text()='"+values[1]+"']"), 5, 1);
		driver.findElement(By.xpath("//td[text()='"+values[1]+"']")).click();
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
		return Widgets.name;
	}

	@Override
	public void next() {
		
	}
	
}
