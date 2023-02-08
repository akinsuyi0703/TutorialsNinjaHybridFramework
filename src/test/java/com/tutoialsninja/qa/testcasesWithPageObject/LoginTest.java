package com.tutoialsninja.qa.testcasesWithPageObject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseClass;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends BaseClass{
	
	public WebDriver driver;
	LoginPage loginpage;
	AccountPage accountpage;
	
	public LoginTest() {
		super();
	}
	
	
	   @BeforeMethod
	   public void setUp() {
		   
		   //System.setProperty("webdriver.chrome.silentOutput", "true");// Timed out receiving message from renderer:
		   driver=initializeBrowserAndApplicationURL(prop.getProperty("browserName"));
		   HomePage homepage=new HomePage(driver);
		   loginpage=homepage.navigateToLoginPage();
		   
		   
		   
	   }
	   
	   @AfterMethod
		public void tearDown() {
			driver.quit();
		}
	

   @Test(priority=1, dataProvider="supplyTestData")
   public  void verifyLoginWithValidCredentials(String email, String password) {
	   
	   accountpage=loginpage.login(email, password);
	   Assert.assertTrue(accountpage.getDisplaStatusOfEditYourAccountInformationOption());
	   
  }
   @DataProvider//(name="validCredentialsSupplier")
   public Object[][] supplyTestData() {
	   
	   Object[][] data=Utilities.getTestDataFromExcel("Login");//sheetname is Login in the excel
	   return data;
	   
   }
   
   @Test(priority=2)
   public  void verifyLoginWithInvalidCredentials() {
	   
	   loginpage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
       Assert.assertTrue(loginpage.retriveEmailPasswordNotMatchingWarning().contains(dataProp.getProperty("emailPasswordNoMatch")), "Expected Warning message is not displayed");
	   
  }
   
   @Test(priority=3)
   public  void verifyLoginWithInvalidEmailAndInvalidPasswordCredentials() {
	  
	   loginpage.login(Utilities.generateEmailWithTimeStamp(), dataProp.getProperty("invalidPassword"));
	    //String actualWarningMessage= loginpage.retriveEmailPasswordNotMatchingWarning();
	   //String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatch");
	   Assert.assertTrue(loginpage.retriveEmailPasswordNotMatchingWarning().contains(dataProp.getProperty("emailPasswordNoMatch")), "Expected Warning message is not displayed");
		
	}
   
   @Test(priority=4)
   public  void verifyLoginWithValidEmailAndInvalidPasswordCredentials() {

	   loginpage.login(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
	   // String actualWarningMessage= loginpage.retriveEmailPasswordNotMatchingWarning();
	   //String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatch");
	   Assert.assertTrue(loginpage.retriveEmailPasswordNotMatchingWarning().contains(dataProp.getProperty("emailPasswordNoMatch")), "Expected Warning message is not displayed");
		
	  
}
   
   @Test(priority=5)
   public  void verifyLoginWithoutEmailAndPassword() {
	   
	   loginpage.clickLoginButton();
	   //String actualWarningMessage= loginpage.retriveEmailPasswordNotMatchingWarning();
	   //String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatch");
	   Assert.assertTrue(loginpage.retriveEmailPasswordNotMatchingWarning().contains(dataProp.getProperty("emailPasswordNoMatch")), "Expected Warning message is not displayed");
		
		
   }
   
  
   

   
  


}
