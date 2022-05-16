package com.swaglabs.tests;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.swaglabs.pages.HomePage;
import com.swaglabs.pages.LoginPage;


public class CheckoutTest extends BaseTest{
	
	// Method for successful purchase
	@Test
	public void TC11_validateCheckout() {
		List<String> products = new ArrayList<String>();
		products.add("Sauce Labs Backpack");
		products.add("Sauce Labs Bike Light");
		products.add("Sauce Labs Fleece Jacket");		
		
		driver.navigate().to("https://www.saucedemo.com/");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		HomePage homePage = loginPage.login("standard_user", "secret_sauce");
		
		homePage.addProducts(products);
		String checkoutPageTitle = homePage.clickShoppingCart()
				.clickCheckout()
				.checkout("John", "Doe", "670517")
				.clickFinish()
				.getTitleText();
		
		String expectedPageTitle = "CHECKOUT: COMPLETE!";
		
		Assert.assertEquals(checkoutPageTitle, expectedPageTitle);
		Reporter.log("PASSED: Checking out functionality<br>", true);
		
	}

}





