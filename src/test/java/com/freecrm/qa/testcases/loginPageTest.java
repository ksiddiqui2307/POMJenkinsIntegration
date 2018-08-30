package com.freecrm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.qa.basesetup.BaseSetup;
import com.freecrm.qa.pages.HomePage;
import com.freecrm.qa.pages.LoginPage;
import com.freecrm.qa.pages.SignUpPage;

import junit.framework.Assert;

public class loginPageTest extends BaseSetup{
	
	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signUpPage;
	
	public loginPageTest()
	{
	super();
	}
	
	@BeforeMethod
	public void setUp(){
		
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test (priority=1)
	public void loginPageTitleTest(){
		String pageTitle=loginPage.validateLoginPageTitle();
		Assert.assertEquals("Title Could Not be Matched", pageTitle, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test (priority=2)
	public void loginAppTest(){
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String homePageTitle=homePage.validateHomePageTitle();
		Assert.assertEquals("Homepage Title Could Not Be Matched", "CRMPRO", homePageTitle);
	}
	
	@Test (priority=3)
	public void validateSignUpPageLanding(){
		signUpPage=loginPage.signUp();
		//boolean pageLanded=signUpPage.validateSignUpPageLanding();
		//Assert.assertTrue("Sign Up Page Could Not Be Landed", pageLanded);
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
