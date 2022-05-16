package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CartPage {
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Checkout']")
	private WebElement btnCheckout;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Continue Shopping']")
	private WebElement btnContinueShopping;
	
	public CartPage(WebDriver driver) {		 
		 this.driver = driver;			  
	}
	
	// page action methods
	public CheckoutInfomationPage clickCheckout() {
		btnCheckout.click();
		Reporter.log("Checkout button clicked<br>");
		return PageFactory.initElements(driver, CheckoutInfomationPage.class);
	}
	
}
