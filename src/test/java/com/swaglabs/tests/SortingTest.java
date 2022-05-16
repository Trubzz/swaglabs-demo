package com.swaglabs.tests;

import java.util.List;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.swaglabs.pages.HomePage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.util.Sort;

public class SortingTest extends BaseTest{

	@Test
	public void TC08_validateSorting_ZA() {
		
		driver.navigate().to("https://www.saucedemo.com/");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		HomePage homePage = loginPage.login("standard_user", "secret_sauce");
		
		homePage.selectSortOrder("za");
		List<String> productNames = homePage.getProductNames();
		
		boolean isDescendingOrder = Sort.isDescendingString(productNames);
		
		Assert.assertTrue(isDescendingOrder);
	}
}
