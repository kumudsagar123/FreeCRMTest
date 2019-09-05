package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'User: kumud sagar')]")
	WebElement userNameLabel;	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')] ")
	WebElement contactLinks;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')] ")
	WebElement newcontactLinks;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]  ")
	WebElement dealLinks;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')] ")
	WebElement taskLinks;
	
	//Initializing PageObjects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
		
	}
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactLinks(){
		contactLinks.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealLinks(){
		 dealLinks.click();
		return new DealsPage();
	}
	public TaskPage clickOnTaskLinks(){
		taskLinks.click();
		return new TaskPage();
	}
	public void clickOnnewContactLink(){
		Actions action=new Actions(driver);
		action.moveToElement(contactLinks).build().perform();
		
		newcontactLinks.click();
	}
}
