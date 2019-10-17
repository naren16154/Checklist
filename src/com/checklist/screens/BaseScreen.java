package com.checklist.screens;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import oracle.adf.core.ADFManager;
import oracle.adf.core.ADFManagerHelper;
import oracle.adf.core.AutoPopulator;
import oracle.adf.core.AutoVerifier;
import oracle.adf.scripts.ADFBaseScript;
import oracle.adf.utilities.ADFLogger;
import oracle.adf.utilities.ScreenShotUtility;
import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.CheckBox;
import oracle.adf.widgetactions.Link;
import oracle.adf.widgets.WidgetInfo;


public abstract class BaseScreen{
	public static ADFManager adfManager = ADFManager.getInstance();
	public static ADFManagerHelper adfManagerHelper = ADFManagerHelper.getInstance();
	public static ADFLogger adfLogger = ADFLogger.getInstance();
	ScreenShotUtility sc = ScreenShotUtility.getInstance();
	
	public static class Widgets
	{
		public static final WidgetInfo menu_link = new WidgetInfo("xpath=//a[@id='pt1:_UISmmLink' or @id='_FOpt1:_UISmmLink']", Link.class);
		public static final WidgetInfo more_Link = new WidgetInfo("xpath=//a[@id='pt1:nv_moreLk' or @id='_FOpt1:nv_moreLk']", Link.class);
		public static final WidgetInfo task_Menu = new WidgetInfo("id=pt1:r1:0:r0:0:r1:0:sdi10::disAcr", Link.class);
		public static final WidgetInfo search_Link = new WidgetInfo("id=pt1:r1:0:r0:0:r1:0:r10:0:i3:6:cl11", Link.class);
		public static final WidgetInfo search_Field = new WidgetInfo("id=pt1:r1:0:r0:1:AP1:s9:it1::content", Link.class);
		public static final WidgetInfo search_Icon = new WidgetInfo("id=pt1:r1:0:r0:1:AP1:s9:ctb1", Link.class);
		public static final WidgetInfo all_Tasks_Link = new WidgetInfo("id=pt1:r1:0:r0:1:AP1:s9:pgl5", Link.class);
		public static final WidgetInfo all_Checkbox = new WidgetInfo("id=pt1:r1:0:r0:1:AP1:sml1::saId", CheckBox.class);
		public static final WidgetInfo done_Button = new WidgetInfo("id=pt1:r1:0:r0:1:AP1:d1::ok", Button.class); 
	}

	public abstract String getExpectedScreenID();
	public abstract String getExpectedScreenTitle();
	public abstract WidgetInfo getExpectedWidget();
	public abstract void next();
	
	public void populateAndContinue(List<Map<String, String>> screenData) {
		this.populateAll(screenData);
//		sc.takeScreenshot();
//		this.verify(ADFBaseScript.dataMap.get(screenData.getClass().getName()+"Verification").get(0));
		this.next();
		
	}
	
	public void populateAll(List<Map<String, String>> screenData) {
		List<Map<String, String>> sheetData = screenData;
		for(Map<String, String> rowData : sheetData)
		{
			this.populate(rowData);
		}
	}
	
	public void populate(Map<String, String> rowData) {
		try {
			AutoPopulator.populate(this, rowData);
		} catch (IllegalAccessException | IllegalArgumentException e) {
			adfLogger.error(e);
		} catch (InvocationTargetException e) {
			adfLogger.error(e.getCause());
		}
	}
	
	public void verify(Map<String, String> rowData) {
		AutoVerifier.verify(this, rowData);
	}
	
	public List<Map<String, String>> getDataMap(String iterations)
	{
		if(iterations.contains("("))
		{
			String num = iterations.replaceAll(".*\\(|\\).*", "").trim();
			String sheet = iterations.substring(0, iterations.lastIndexOf("("));
			int start = Integer.parseInt(num.split(",")[0].trim())-1;
			int end = Integer.parseInt(num.split(",")[1].trim());
			return ADFBaseScript.getDataMap().get(sheet).subList(start, end);
		}
		else
			return ADFBaseScript.getDataMap().get(iterations);			
	}
	
	public void login(String value)
	{
		(new Login()).login(value);
	}
	
	public void navigator_Link(String navigator_Link_Text)
	{
		adfManager.widgetEnabled(Widgets.menu_link, 60, 2);
		AutoPopulator.populateWidget(Widgets.menu_link, "menu_link", "click");
		adfManager.waitForAjaxToLoad();
		if(!navigator_Link_Text.contains("_"))
		{
			WidgetInfo link = new WidgetInfo("xpath=//span[text()='"+navigator_Link_Text+"']", Link.class);
			adfManager.getJSExecutor().executeScript("arguments[0].click();", adfManagerHelper.getWebElement(link));
		}
		else
		{
			String group = navigator_Link_Text.split("_")[0];
			String task = navigator_Link_Text.split("_")[1];
			adfManager.waitForWidget(By.xpath("//div[@id='_FOpt1:_UISnvr:0:nv_npgl1' or @id='pt1:_UISnvr:0:nv_npgl1']"), 30, 1);
			WebElement groupPanel = adfManager.getCurrentWebDriver().findElement(By.xpath("//div[@id='_FOpt1:_UISnvr:0:nv_npgl1' or @id='pt1:_UISnvr:0:nv_npgl1']"));
			List<WebElement> groups = groupPanel.findElements(By.xpath("div"));
			for(int i=1; i<groups.size();i++)
			{
				WebElement ele = groups.get(i);
				if(group.equalsIgnoreCase(ele.findElement(By.xpath("div/div/div/div")).getText().trim().replaceAll(" ", "")))
				{
					List<WebElement> links = ele.findElements(By.xpath("descendant::a"));
					if("visibility: hidden;".equals(ele.findElement(By.xpath("div/div[2]/div")).getAttribute("style")))
						links.get(0).click();
					for(int j=1 ; j< links.size() ;j++)
					{
						if(task.equalsIgnoreCase(links.get(j).getAttribute("title").trim().replaceAll(" ", "")))
						{
							adfManager.getJSExecutor().executeScript("arguments[0].setAttribute('style', 'background-color: red')", links.get(j));
							links.get(j).click();
							break;
						}
					}
					break;
				}
			}
		}
		ADFLogger.getInstance().info("Clicked on : "+navigator_Link_Text+" link");
		adfManagerHelper.sleep(2);
		adfManager.waitForPageToLoad();
	}
	
	public void task(String taskName)
	{
		adfManager.waitForWidget(Widgets.task_Menu, 20, 5);
		adfManager.link(Widgets.task_Menu).click();
		adfManager.link(Widgets.search_Link).click();
		adfManager.link(Widgets.all_Tasks_Link).click();
		adfManager.checkBox(Widgets.all_Checkbox).setDisplayValue("check");
		adfManager.button(Widgets.done_Button).click();
		adfManager.textField(Widgets.search_Field).setDisplayValue(taskName);
		adfManager.link(Widgets.search_Icon).click();
		adfManager.link(new WidgetInfo("linktext="+taskName, Link.class)).click();
		adfManager.waitForAjaxToLoad();
	}
	
	public void resetPassword(String value)
	{
		(new ResetPassword()).resetPassword(value);
	}

	public void logout(String value)
	{
		(new Logout()).logout(value);
	}
	
}
