package com.swaglabs.pages;

import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;



public class LoginPage {
			
	WebDriver driver;

	//WebElements for Login Page 
		
	@FindBy(how = How.ID, using = "user-name")
	private WebElement txtUsername; 
	
	@FindBy(how = How.ID, using = "password")
	private WebElement txtPassword;
	
	@FindBy(how = How.ID, using = "login-button")
	private WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//h3[@data-test='error']")
	private WebElement txtErrorMsg;
	  
	 public LoginPage(WebDriver driver) {		 
		 this.driver = driver;			  
	  }
	
	 // Page Action methods
		public void clickLogin () {	
			btnLogin.click();
		}
		
		public void setUsername(String username) {
			txtUsername.sendKeys(username);
		}
		
		public void setPassword(String password) {
			txtPassword.sendKeys(password);
		}
		
		public String getErrorMsg() {
			return txtErrorMsg.getText(); 
		}
		
		
		// Login business method which returns HomePage
		public HomePage login(String username, String password) {
			setUsername(username);
			setPassword(password);
			clickLogin();
			Reporter.log("Logged into SwagLabs<br>");
			return PageFactory.initElements(driver, HomePage.class);
		}
	}


	
