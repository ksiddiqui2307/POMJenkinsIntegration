package com.freecrm.qa.testcases;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.basesetup.BaseSetup;
import com.freecrm.qa.pages.ContactsPage;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.util.CommonUtils;

public class NewContactsPageTest extends BaseSetup {

	LoginPage loginPage;
	HomePage homePage;
	CommonUtils commonUtils;
	ContactsPage contactsPage;
	
	public NewContactsPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage= new LoginPage();
		homePage=new HomePage();
		commonUtils=new CommonUtils();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		commonUtils.switchToFrame("mainpanel");
		homePage.clickOnNewContactsLink();
	}
	
	@Test(priority=1)
	public void validateFnameState(){
		boolean state=contactsPage.validateFnameIsEnabled();
		Assert.assertTrue("FirstName Field Is Not Enabled",state);
	}
	
	@Test(priority=2)
	public void validateLnameState(){
		boolean state=contactsPage.validateLnameIsEnabled();
		Assert.assertTrue("FirstName Field Is Not Enabled",state);
	}
	
	@Test(priority=3)
	public void createNewContact(){
		contactsPage.createNewContact("Mr.", "ABC", "XYZ", "TCS");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
