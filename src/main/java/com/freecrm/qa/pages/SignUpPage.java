package com.freecrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.qa.basesetup.BaseSetup;

public class SignUpPage extends BaseSetup{
	
@FindBy(id="payment_plan_id")
WebElement editionDrpDwn;

//initializing the page object
public SignUpPage(){
	PageFactory.initElements(driver, this);
}

public boolean validateSignUpPageLanding(){
	return editionDrpDwn.isDisplayed();
}


}
