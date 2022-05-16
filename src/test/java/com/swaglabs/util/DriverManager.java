package com.swaglabs.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver==null) {
			System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://www.saucedemo.com/");
		}
		
		return driver;
	}
	
	
}
