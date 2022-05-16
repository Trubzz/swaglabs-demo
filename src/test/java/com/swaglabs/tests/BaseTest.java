package com.swaglabs.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.swaglabs.pages.HomePage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.util.DriverManager;

public class BaseTest {

	static WebDriver driver;
	
	@BeforeSuite
	public static void LoadDriver() {
		driver = DriverManager.getDriver();
	}
	
	@AfterSuite
	public static void QuitDriver() {
		driver.quit();
	}
	
}
