package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement myFirstnameField;
	
	@FindBy(id="input-lastname")
	private WebElement myLastnameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsLetterOption;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	private WebElement firstnameWarning;
	
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	private WebElement lastnameWarning;
	
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	private WebElement emailWarning;
	
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarning;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public AccountSuccessPage registerWithMandatoryFields(String firstnameText, String lastnameText, String emailText, String telephoneText, String passwordText) {
		myFirstnameField.sendKeys(firstnameText);
		myLastnameField.sendKeys(lastnameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
        confirmPasswordField.sendKeys(passwordText);
    	privacyPolicyField.click();
    	continueButton.click();
		return new AccountSuccessPage(driver);
		
		
	}
	
	public AccountSuccessPage registerWithAllField(String firstnameText, String lastnameText, String emailText, String telephoneText, String passwordText) {
		myFirstnameField.sendKeys(firstnameText);
		myLastnameField.sendKeys(lastnameText);
		emailAddressField.sendKeys(emailText);
		telephoneField.sendKeys(telephoneText);
		passwordField.sendKeys(passwordText);
        confirmPasswordField.sendKeys(passwordText);
        yesNewsLetterOption.click();
    	privacyPolicyField.click();
    	continueButton.click();
		return new AccountSuccessPage(driver);
		
		
	}
   
	
	public String retrieveDuplicateEmailAddressWarning() {
	   
	   String duplicateEmailWarningText=duplicateEmailAddressWarning.getText();
	   return duplicateEmailWarningText;
		
	   
	}
   
    public String retrievePrivacyPolicyWarningText() {
	   
	   String PrivacyPolicyWarningText= privacyPolicyWarning.getText();
	   return PrivacyPolicyWarningText;
	   
   }
   public String retrieveFirstnameWarningText() {
	   
	   String firstnameWarningText= firstnameWarning.getText();
	   return firstnameWarningText;
	   
   }
   
   public String retrieveLastnameWarningText() {
	   
	   String lastnameWarningText= lastnameWarning.getText();
	   return lastnameWarningText;

  }
   public String retrieveEmailWarningText() {
	   
	   String emailWarningText= emailWarning.getText();
	   return emailWarningText;
	   
   }
   public String retrieveTelephoneWarningText() {
	   
	   String telephoneWarningText= telephoneWarning.getText();
	   return telephoneWarningText;
	   
   }
   
   public String retrievePasswordWarningText() {
	   
	   String passwordWarningText= passwordWarning.getText();
	   return passwordWarningText;

   }

   public boolean displayStatusOfWarningMessage(String expprivacyPolicyWarning, String expfirstNameWarning, String explastNameWarning, String expemailWarning, String exptelephoneWarning, String exppasswordWarning) {

	   boolean privatePolicyWarningStatus=privacyPolicyWarning.getText().contains(expprivacyPolicyWarning);
	   boolean firstnameWarningStatus= firstnameWarning.getText().equals(expfirstNameWarning);
	   boolean lastnameWarningStatus= lastnameWarning.getText().equals(explastNameWarning);
	   boolean emailWarningStatus= emailWarning.getText().equals(expemailWarning);
	   boolean telephoneWarningStatus= telephoneWarning.getText().equals(exptelephoneWarning);
	   boolean passwordWarningStatus= passwordWarning.getText().equals(exppasswordWarning);
	   return privatePolicyWarningStatus && firstnameWarningStatus && lastnameWarningStatus && emailWarningStatus && telephoneWarningStatus && passwordWarningStatus;
}

   public void clickOnContinueButton() {
	continueButton.click();
	
}
}
