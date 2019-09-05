package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	String sheetName="Contacts";
	public ContactsPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception{
	initialization();
	 loginpage=new LoginPage();
	 testutil=new TestUtil();
	 contactspage=new ContactsPage();
	 homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	 
	 testutil.switchToFrame();
	 contactspage= homepage.clickOnContactLinks();
	
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactspage.verifyContactsLabel(),"contacts label is missing");
	}
	
	@Test(priority=2)
	public void selectContactsTest(){
		contactspage.selectContact("tom peter");
	}
	
	@DataProvider
	public Object[][] getCrmTestData() throws Exception{
		
		
	Object data[][]=	TestUtil.getTestData(sheetName);
	return data;
		
	}
	
	@Test(priority=3,dataProvider="getCrmTestData")
	public void validateCreatenewContact(String Title,String Firstname,String Lastname,String company){
		homepage.clickOnnewContactLink();
		//contactspage.createNewContact("Mr.", "Tom", "peter", "google");
		contactspage.createNewContact(Title, Firstname, Lastname, company);
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
