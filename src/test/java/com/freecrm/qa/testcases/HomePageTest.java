package com.freecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.basesetup.BaseSetup;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.CommonUtils;

public class HomePageTest extends BaseSetup{
	LoginPage loginPage;
	HomePage homePage;
	CommonUtils commonUtils;
	
	public HomePageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		commonUtils=new CommonUtils();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void validateDealsLink(){
		commonUtils.switchToFrame("mainpanel");
		homePage.clickOnDealsLink();
	}
	
	@Test(priority=2)
	public void validateNewContactsLink(){
		commonUtils.switchToFrame("mainpanel");
		homePage.clickOnNewContactsLink();
	}
	
	@Test(priority=3)
	public void validateTasksLink(){
		commonUtils.switchToFrame("mainpanel");
		homePage.clickOnTasksLink();
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
