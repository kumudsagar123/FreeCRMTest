package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @ value='Save']")
	WebElement saveBtn;
	
	
public ContactsPage(){
		
		PageFactory.initElements(driver, this);
	}
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	public void selectContact(String name){
		driver.findElement(By.xpath("//input[@value='52707947']")).click();
	}
	public void createNewContact(String title,String ftname,String ltname,String companyname){
		Select select =new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftname);
		lastName.sendKeys(ltname);
		company.sendKeys(companyname);
		saveBtn.click();
	}
}
