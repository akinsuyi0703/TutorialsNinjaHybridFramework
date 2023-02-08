package com.tutoialsninja.qa.testcasesWithPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.pages.AccountSuccessPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends BaseClass{
	
	RegisterPage registerpage;
	AccountSuccessPage accountsuccesspage;
	
	public RegisterTest() {
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup()  {
		
		   driver=initializeBrowserAndApplicationURL(prop.getProperty("browserName"));
		   
		   HomePage homepage =new HomePage(driver);
		   registerpage=homepage.selectRegisterOption();
		   
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		
		accountsuccesspage=registerpage.registerWithMandatoryFields(dataProp.getProperty("firstname"), dataProp.getProperty("lastname"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNo"), prop.getProperty("validPassword"));
      
		Assert.assertEquals(accountsuccesspage.retrieveAccountSussessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");
		
		 
	}
	
	@Test(priority=2)
	public void verifyRegisteringAnAccountByProvidindAllFields() {
		
		 accountsuccesspage=registerpage.registerWithAllField(dataProp.getProperty("firstname"), dataProp.getProperty("lastname"), Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("telephoneNo"), prop.getProperty("validPassword"));
		  
		 Assert.assertEquals(accountsuccesspage.retrieveAccountSussessPageHeading(), dataProp.getProperty("accountSuccessfullyCreatedHeading"), "Account Success page is not displayed");
		
		

}
	
	@Test(priority=3)
	public void verifyRegisteringAnAccountWithAnExistingEmailAddress() {
		
		registerpage.registerWithAllField(dataProp.getProperty("firstname"), dataProp.getProperty("lastname"), prop.getProperty("validEmail"), dataProp.getProperty("telephoneNo"), prop.getProperty("validPassword"));
		   
        Assert.assertEquals(registerpage.retrieveDuplicateEmailAddressWarning(), dataProp.getProperty("duplicateEmailWarning"), "Warning message regarding email address is not displayed");
		  

}

	@Test(priority=4)
	public void verifyRegisteringAnAccountWithoutFillingAnyDetails() {
		
		   registerpage.clickOnContinueButton();

		   Assert.assertTrue(registerpage.displayStatusOfWarningMessage(dataProp.getProperty("privacyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning")));
		  // Assert.assertTrue(registerpage.displayStatusOfWarningMessage(dataProp.getProperty("privacyWarning"), dataProp.getProperty("firstNameWarning"), dataProp.getProperty("lastNameWarning"), dataProp.getProperty("emailWarning"), dataProp.getProperty("telephoneWarning"), dataProp.getProperty("passwordWarning"), "Password Warning message is not displayed")));
		   
          

}

}
