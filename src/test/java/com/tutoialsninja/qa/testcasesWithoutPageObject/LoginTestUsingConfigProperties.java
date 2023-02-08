package com.tutoialsninja.qa.testcasesWithoutPageObject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;
import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.utils.Utilities;



public class LoginTestUsingConfigProperties extends BaseClass{
	
	public LoginTestUsingConfigProperties() {
		super();
	}
	
	
	 
	WebDriver driver;
	
	   @BeforeMethod
	   public void setUp() {
		 
		   //loadPropertiesFile(); you can call this method from baseclass direct or use the construction of this class
		   driver=initializeBrowserAndApplicationURL(prop.getProperty("browserName"));
		   driver.findElement(By.xpath("//span[text()='My Account']")).click();
		   driver.findElement(By.linkText("Login")).click();
		   
		   
	   }
	   
	   @AfterMethod
		public void tearDown() {
			driver.quit();
		}
	

   @Test(priority=1)
   public  void verifyLoginWithValidCredentials() {
	   
	
	   driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
	   driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
	   driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	   Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	   
		
		
	}


	   
   
   
   @Test(priority=2)
   public  void verifyLoginWithInvalidCredentials() {
	   
	   driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
	   driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
	   driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	   String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	   String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatch");
	   Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
	   
		
		
	}
   
   @Test(priority=3)
   public  void verifyLoginWithValidEmailAndInvalidPasswordCredentials() {
	   
	   driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
	   driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
	   driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	   String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	   String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatch");
	   Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
	   
		
		
	}
   
   @Test(priority=4)
   public  void verifyLoginWithValidEmailAndInalidPasswordCredentials() {
	   
	  
	   driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
	   driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
	   driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	   String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	   String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatch");
	   Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
	   
		
		
	}
   
   @Test(priority=5)
   public  void verifyLoginWithoutEmailAndPassword() {
	   
	   //driver.findElement(By.id("input-email")).sendKeys("");
	   //driver.findElement(By.id("input-password")).sendKeys("");
	   driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	   String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
	   String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatch");
	   Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected Warning message is not displayed");
	   
		
		
   }
   
  
   

   
  

}
