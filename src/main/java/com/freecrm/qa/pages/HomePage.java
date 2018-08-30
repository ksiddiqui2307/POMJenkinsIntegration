package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.basesetup.BaseSetup;

public class HomePage extends BaseSetup {

	@FindBy(xpath="//td[contains(text(),'Kashif')]")
	WebElement currentUsrName;
	
	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement homePageLogo;
	
	@FindBy(xpath="//*[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[@title='Tasks']")
	WebElement tasksLink;
	
	@FindBy(xpath="//*[@title='New Contact']")
	WebElement newContactsLink;
	
	//initializing the page objects
	public HomePage(){
	PageFactory.initElements(driver, this);
	}
	
//	Actions:
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateHomePageLogo(){
		return homePageLogo.isDisplayed();
	}
	
	public ContactsPage clickOnNewContactsLink(){
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	
}
