package com.tutoialsninja.qa.testcasesWithPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends BaseClass{
	
	SearchPage searchpage;
	HomePage homepage;
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	
	 @BeforeMethod
	   public void setUp() {
		 
		 driver=initializeBrowserAndApplicationURL(prop.getProperty("browserName"));
		 homepage=new HomePage(driver);
		 
	 }
	 @AfterMethod
		public void tearDown() {
			driver.quit();
		}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() {
		
		searchpage=homepage.searchForProduct(dataProp.getProperty("validProduct"));
		Assert.assertTrue(searchpage.displayStatusOfHPValidProduct());
		
	}
	
	@Test(priority=2)
	public void verifySearchWithInvalidProduct() {
		
		searchpage=homepage.searchForProduct(dataProp.getProperty("invalidProduct"));
		//String actualSearchMessage = searchpage.retrieveNoProductMessageText();
		Assert.assertEquals(searchpage.retrieveNoProductMessageText(), "abcd", "No product message in search results is not displayed");
	   //dataProp.getProperty("noProductTestInseachResult") replace "abcd"
	}
	
	@Test(priority=3, dependsOnMethods= {"verifySearchWithInvalidProduct"})
	public void verifySearchWithoutAnyProduct() {
		
		searchpage=homepage.clickOnSearchButton();
	    //String actualSearchMessage = searchpage.retrieveNoProductMessageText();
		Assert.assertEquals(searchpage.retrieveNoProductMessageText(), dataProp.getProperty("noProductTestInseachResult"), "No product message in search results is not displayed");
		 
	}

}
