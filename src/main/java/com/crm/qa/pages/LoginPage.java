package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	//PageFactor-OR

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[@href='https://ar.crmpro.com']")
	WebElement SignUp;
	
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing Page Objects
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	public boolean validateCRMLogo(){
	return	crmLogo.isDisplayed();
	}
	public HomePage Login(String un,String pwd) throws Exception{
		Thread.sleep(2000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	public void logittest(){
		
	}
}
