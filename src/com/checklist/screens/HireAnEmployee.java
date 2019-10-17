package com.checklist.screens;


import oracle.adf.core.AutoPopulator;
import oracle.adf.widgetactions.Button;
import oracle.adf.widgetactions.DropDown;
import oracle.adf.widgetactions.Label;
import oracle.adf.widgetactions.Link;
import oracle.adf.widgetactions.ListBox;
import oracle.adf.widgetactions.TextField;
import oracle.adf.widgets.WidgetInfo;

import org.openqa.selenium.By;

public class HireAnEmployee extends BaseScreen {

	public static final String EXPECTED_SCREEN_ID = "HireEmployee";
	public static final String EXPECTED_SCREEN_TITLE = "";
	
	public static String person_Name = null;
	public static String person_Num = null;
	
	public static class Widgets
	{
		public static final WidgetInfo subTaskMenu = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTsdiAddCwkDefaultRegional::disAcr", Link.class);
		public static final WidgetInfo hireEmployee_Link = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:_FOTRaT:0:RAtl1", Link.class);
		public static final WidgetInfo hireDate = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:inputDate1::content", TextField.class);
		public static final WidgetInfo hireAction = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice1::content", ListBox.class);
		public static final WidgetInfo hireReason = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice2::content", ListBox.class);
		public static final WidgetInfo legalEmployer = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:selectOneChoice3::content", DropDown.class);
		public static final WidgetInfo lastName = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:r1:0:i1:4:it20::content", TextField.class);
		public static final WidgetInfo firstName = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:r1:0:i1:5:it60::content", TextField.class);
		public static final WidgetInfo nameTitle = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:r1:0:i1:6:selectOneChoice4::content", ListBox.class);
		public static final WidgetInfo middleName = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:r1:0:i1:9:it24::content", TextField.class);
		public static final WidgetInfo gender = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:soc3::content", ListBox.class);
		public static final WidgetInfo DOB = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:NewPe1:0:pt_r1:0:id3::content", TextField.class);
		public static final WidgetInfo next = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:0:pt1:SP1:tt1:next']", Link.class);
		
		public static final WidgetInfo address1 = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:pfl2']//descendant::input[2]", TextField.class);
		public static final WidgetInfo address2 = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:pfl2']//descendant::input[3]", TextField.class);
		public static final WidgetInfo address3 = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:pfl2']//descendant::input[4]", TextField.class);
		public static final WidgetInfo city= new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:pfl2']//descendant::input[5]", DropDown.class);
		public static final WidgetInfo state = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:pfl2']//descendant::input[6]", DropDown.class);
		public static final WidgetInfo zipcode = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:pfl2']//descendant::input[7]", DropDown.class);
		public static final WidgetInfo country = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:1:pt1:SP1:Perso2:0:Perso1:0:Maint1:0:pfl2']//descendant::input[9]", DropDown.class);
		public static final WidgetInfo businessUnit = new WidgetInfo("xpath=//label[text()='Business Unit']/../..//input", DropDown.class);
		public static final WidgetInfo managerName_Vision = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FOSritemNode_manager_resources_new_person:1:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:0:r3:0:pgl1']//descendant::input[1]", DropDown.class);
		public static final WidgetInfo assignment_link = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:showDetailItem2::ti", Link.class);
		public static final WidgetInfo managerName_GBI = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:2:pt1:sP2:NewPe3:1:r3:0:pgl1']//descendant::input[1]", DropDown.class);
		public static final WidgetInfo person_Name = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:4:pt1:AP1:NewPe3:0:Perso1", Label.class);
		public static final WidgetInfo person_Number = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:4:pt1:AP1:NewPe3:0:outputText4", Label.class);
		public static final WidgetInfo submit_Button = new WidgetInfo("xpath=//div[@id='_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:4:pt1:AP1:tt1:submit']", Link.class);
		
		
		public static final WidgetInfo warning_Yes = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:4:pt1:AP1:tt1:okWarningDialog", Button.class);
		public static final WidgetInfo confirmation_Ok = new WidgetInfo("id=_FOpt1:_FOr1:0:_FONSr2:0:MAnt2:1:pt1:pt_r1:4:pt1:AP1:tt1:okConfirmationDialog", Button.class);
	}
	
	public void hireAnEmployee(String value)
	{
		if("yes".equalsIgnoreCase(value))
		{
//			adfManagerHelper.sleep(10);
			adfManager.waitForWidget(Widgets.subTaskMenu, 20, 2);
			AutoPopulator.populateWidget(Widgets.subTaskMenu, "subTaskMenu", "click");
			adfManager.widgetEnabled(Widgets.hireEmployee_Link, 10, 1);
			AutoPopulator.populateWidget(Widgets.hireEmployee_Link, "hireEmployee_Link", "click");
			adfManager.waitForAjaxToLoad();
		}
	}
	
	public void nextLink(String value)
	{
		if("click".equalsIgnoreCase(value))
		{
			String id = adfManager.getCurrentWebDriver().findElement(By.xpath("//*[text()='Save']//ancestor::div[1]")).getAttribute("id");
			id = id.substring(0, id.lastIndexOf(":")+1);
			AutoPopulator.populateWidget(new WidgetInfo("id="+id+"next", Link.class), "next", "click");
			adfManager.waitForAjaxToLoad();
		}
	}
	
	public void submit(String value)
	{
		if("yes".equalsIgnoreCase(value))
		{
			sc.takeScreenshot();
			person_Name = adfManager.label(Widgets.person_Name).getDisplayValue();
			person_Num = adfManager.label(Widgets.person_Number).getDisplayValue();
			AutoPopulator.populateWidget(Widgets.submit_Button, "submit_Button", "click");
			adfManager.waitForWidget(Widgets.warning_Yes, 10, 1);
			AutoPopulator.populateWidget(Widgets.warning_Yes, "warning_Yes", "click");
			adfManager.waitForAjaxToLoad();
			adfManager.waitForWidget(Widgets.confirmation_Ok, 60, 4);
			AutoPopulator.populateWidget(Widgets.confirmation_Ok, "confirmation_Ok", "click");
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
		return Widgets.subTaskMenu;
	}

	@Override
	public void next() {
		
	}

}
