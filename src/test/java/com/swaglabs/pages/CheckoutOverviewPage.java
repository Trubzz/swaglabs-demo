package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CheckoutOverviewPage {
	private WebDriver driver;
	
	@FindBy(how = How.ID, using = "finish")
	private WebElement btnFinish;
	
	public CheckoutOverviewPage(WebDriver driver) {		 
		 this.driver = driver;			  
	}
	
	// page action methods
	public CheckoutCompletePage clickFinish() {
		btnFinish.click();
		Reporter.log("Clicked on finish button<br>");
		return PageFactory.initElements(driver, CheckoutCompletePage.class);
	}
}
