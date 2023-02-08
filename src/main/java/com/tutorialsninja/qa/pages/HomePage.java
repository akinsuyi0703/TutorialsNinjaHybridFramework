package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Object or identifying webelement
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchboxField;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	//Action xpath("//div[@id='search']/descendant::button")
	
   
    
   public SearchPage searchForProduct(String productText) {
	    searchboxField.sendKeys(productText);
		searchButton.click();
		return new SearchPage(driver);
	}
    
   
	
	public LoginPage navigateToLoginPage() {
		
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
    public RegisterPage selectRegisterOption() {
		
    	myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
	}

	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}

	
	

}
