/*package com.tutoialsninja.qa.testcasesWithoutPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.utils.Utilities;

public class Register extends BaseClass{
	
	public Register() {
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		   driver=initializeBrowserAndApplicationURL(prop.getProperty("browserName"));
		   driver.findElement(By.xpath("//span[text()='My Account']")).click();
		   driver.findElement(By.linkText("Register")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		
		
		   driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstname"));
		   driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastname"));
		   driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		   driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNo"));
		   driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPasswoed"));
		   driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		   driver.findElement(By.name("agree")).click();
		   driver.findElement(By.xpath("//input[@value='Continue']")).click();
		   
		   String actualSuccessHeading = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		   Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!", "Account Success page is not displayed");
		   
		  
	}
	
	@Test(priority=2)
	public void verifyRegisteringAnAccountByProvidindAllFields() {
		
		
		   driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstname"));
		   driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastname"));
		   driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailWithTimeStamp());
		   driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNo"));
		   driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		   driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		   driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		   driver.findElement(By.name("agree")).click();
		   driver.findElement(By.xpath("//input[@value='Continue']")).click();
		   
		   String actualSuccessHeading = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		   Assert.assertEquals(actualSuccessHeading, "Your Account Has Been Created!", "Account Success page is not displayed");
		   
		   

}
	
	@Test(priority=3)
	public void verifyRegisteringAnAccountWithAnExistingEmailAddress() {
		
		  
		   driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstname"));
		   driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastname"));
		   driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		   driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNo"));
		   driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		   driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		   driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		   driver.findElement(By.name("agree")).click();
		   driver.findElement(By.xpath("//input[@value='Continue']")).click();
		   
		   //String actualWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		   
		   //Assert.assertTrue(actualWarning.contains(dataProp.getProperty("duplicateEmailWarning"), "Warning message regarding email address is not displayed");
		

}

	@Test(priority=4)
	public void verifyRegisteringAnAccountWithoutAny() {
		
	
           driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		   driver.findElement(By.name("agree")).click();
		   driver.findElement(By.xpath("//input[@value='Continue']")).click();
		   
           
		   String actualPrivatePolicyWarning=driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText();
		   
		   Assert.assertEquals(actualPrivatePolicyWarning, dataProp.getProperty("firstNameWarning", actualPrivatePolicyWarning), "Firstname Warning message is not displayed");
		   
		   
		   String actualFirstNameWarning=driver.findElement(By.xpath("//input[@name='firstname']/following-sibling::div")).getText();
		   
		   Assert.assertEquals(actualFirstNameWarning, dataProp.getProperty("firstNameWarning", actualFirstNameWarning), "Firstname Warning message is not displayed");
		   
		   
           String actualLastNameWarning=driver.findElement(By.xpath("//input[@name='lastname']/following-sibling::div")).getText();
		   
		   Assert.assertEquals(actualLastNameWarning, dataProp.getProperty("lastNameWarning"), "Firstname Warning message is not displayed");
		   

           String actualEmailWarning=driver.findElement(By.xpath("//input[@name='email']/following-sibling::div")).getText();
		   
		   Assert.assertEquals(actualEmailWarning, dataProp.getProperty("emailWarning"), "Email Warning message is not displayed");
		   
		   
           String actualTelephoneWarning=driver.findElement(By.xpath("//input[@name='telephone']/following-sibling::div")).getText();
		   
		   Assert.assertEquals(actualTelephoneWarning, dataProp.getProperty("telephoneWarning"), "Telephone Warning message is not displayed");
		   
		   
           String actualPasswordWarning=driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
		   
		   Assert.assertEquals(actualPasswordWarning, dataProp.getProperty("passwordWarning"), "Password Warning message is not displayed");
		
		   
          

}

}*/
