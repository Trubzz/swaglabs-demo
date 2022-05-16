package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CheckoutInfomationPage {
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	private WebElement btnContinue;
	
	@FindBy(how = How.ID, using = "first-name")
	private WebElement txtFirstName;
	
	@FindBy(how = How.ID, using = "last-name")
	private WebElement txtLastName;
	
	@FindBy(how = How.ID, using = "postal-code")
	private WebElement txtPostalCode;
	
	public CheckoutInfomationPage(WebDriver driver) {		 
		 this.driver = driver;			  
	}
	
	// page action methods
	public CheckoutOverviewPage clickContinue() {
		btnContinue.click();
		Reporter.log("Continue button clicked<br>");
		return PageFactory.initElements(driver, CheckoutOverviewPage.class);
	}
	
	
	// Checkout business method which returns CheckoutOverviewPage
	public CheckoutOverviewPage checkout(String firstName, String lastName, String postalCode) {
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		txtPostalCode.sendKeys(postalCode);
		Reporter.log("Filled checkout details<br>");
		
		return clickContinue();		
	}
}
