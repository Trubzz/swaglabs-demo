package com.swaglabs.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//span[@class='title']")
	private WebElement pageTitle;
	
	@FindBy(how = How.XPATH, using = "//select[@class='product_sort_container']")
	private WebElement selectSort;
	
	@FindBy(how = How.XPATH, using = "//div[@class='inventory_item']")
	private List<WebElement> products;
	
	@FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
	private WebElement shoppingCart;
	
	public HomePage(WebDriver driver) {		 
		 this.driver = driver;			  
	}
	
	public WebElement getPageTitle() {
		return this.pageTitle;
	}
	
	// Page action methods
	public void clickAddToCart(String productName) {
		String xPath = "//div[text()=\""+ productName+ "\"]/../../..//button[text()=\"Add to cart\"]";
		
		WebElement btnAddToCart = driver.findElement(By.xpath(xPath));
		btnAddToCart.click();
	}
	
	public CartPage clickShoppingCart() {
		shoppingCart.click();
		return PageFactory.initElements(driver, CartPage.class);
	}
	
	// Business methods
	public void selectSortOrder(String option) {
		Select sortMenu = new Select(selectSort);		
		sortMenu.selectByValue(option);
	}
	
	// Get all products' names from home page
	public List<String> getProductNames(){
		List<String> productNames = new ArrayList<String>();		
		for (WebElement product : products){ 
		    String itemName = product.findElement(By.xpath(".//div[@class='inventory_item_name']")).getText();
		    productNames.add(itemName);	
		    System.out.println(itemName);
		}		
		return productNames;
	}
	
	public void addProducts(List<String> productNames) {
		for(String product : productNames) {
			clickAddToCart(product);
		}
	}
}
