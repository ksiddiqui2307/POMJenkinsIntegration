package com.freecrm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.basesetup.BaseSetup;

public class LoginPage extends BaseSetup{

	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submitbtn;
	
	@FindBy(xpath="//*[@class='container']/div[2]/ul/li/a")
	WebElement signUp;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	
	//initializing the page object
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
//	Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateLoginPageLogo(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String uName, String pswd)
	{
		userName.sendKeys(uName);
		password.sendKeys(pswd);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", submitbtn);
		return new HomePage();
		
	}
	
	public SignUpPage signUp()
	{
		/*JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click", signUp);*/
		Actions as=new Actions(driver);
		as.moveToElement(signUp).perform();
		return new SignUpPage();
		
	}
}
