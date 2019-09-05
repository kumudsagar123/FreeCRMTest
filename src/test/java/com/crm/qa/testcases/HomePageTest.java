package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	public HomePageTest(){
		super();
	}

	//testcases should be separated or independent with each other
	//before each test case-launch the browser and login
	//after each testcase -close the browse
	//@test-execute testcases
	@BeforeMethod
	public void setUp() throws Exception{
	initialization();
	 loginpage=new LoginPage();
	 testutil=new TestUtil();
	 contactspage=new ContactsPage();
	 homepage=loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void homePageTitle(){
		String homepagetitle=homepage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Home PageTitle not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	
	@Test(priority=3)
	public void verifyContactLinkTest(){
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactLinks();
	}
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
