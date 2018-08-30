package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.qa.basesetup.BaseSetup;

public class ContactsPage extends BaseSetup{

	@FindBy(xpath="//select[@name='title']")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	//initializing the page objects
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
//	Actions:
	
	public boolean validateFnameIsEnabled()
	{
		return firstName.isEnabled();
	}
		
	public boolean validateLnameIsEnabled()
	{
		return lastName.isEnabled();
	}
	
	public void createNewContact(String titleVal, String fName,String lName, String comName)
	{
		new Select(title).selectByVisibleText(titleVal);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		company.sendKeys(comName);
		saveBtn.click();
		
	}
}
