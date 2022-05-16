package com.swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutCompletePage {
	// //span[@class='title']
	
private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//span[@class='title']")
	private WebElement pageTitle;
	
	public CheckoutCompletePage(WebDriver driver) {		 
		 this.driver = driver;			  
	}
	
	// Method for get the title of Check out Complete page
	public String getTitleText() {
		return pageTitle.getText();
	}
}
