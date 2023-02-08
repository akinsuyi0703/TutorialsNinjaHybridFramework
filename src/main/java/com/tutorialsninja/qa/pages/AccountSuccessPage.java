package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	WebDriver driver;

	@FindBy(xpath="//div[@id='content']/h1")//(xpath="//h1[text()='Your Account Has Been Created!']")
	private WebElement accountSuccessPageHeading;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public String retrieveAccountSussessPageHeading() {
		
		String accountSuccessPageHeadingText=accountSuccessPageHeading.getText();
		return accountSuccessPageHeadingText;
	}

}
