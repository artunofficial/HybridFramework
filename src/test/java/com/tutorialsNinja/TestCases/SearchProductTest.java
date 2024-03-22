package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.ProductPage;
import com.tutorialsNinja.TestBase.TestBase;

public class SearchProductTest extends TestBase{
	public SearchProductTest() throws Exception {
		super();
	}
	
	public WebDriver driver;
	public HomePage homepage;
	ProductPage productpage;
	
	
	@BeforeMethod
	public void searchProductSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));

	}
	
	@Test(priority=1)
	public void verifySearchValidProduct() {
		homepage = new HomePage(driver);
//		homepage.enterProductName(dataProp.getProperty("validProduct"));
		productpage = homepage.navigateToProductPage(dataProp.getProperty("validProduct"));
		ProductPage productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.verifyValidProductPresence());
	}
	
	@Test(priority=2)
	public void verifySearchInvalidProduct() {
		
		homepage = new HomePage(driver);
//		homepage.enterProductName(dataProp.getProperty("invalidProduct"));
		productpage = homepage.navigateToProductPage((dataProp.getProperty("invalidProduct")));
//		homepage.clickOnSearchButton();
//		ProductPage productpage = new ProductPage(driver);
		Assert.assertFalse(productpage.verifyInvalidProductWarningMessageDisplay());
	}
	
	@Test(priority=3)
	public void verifySearchNoProduct() {
		
		homepage = new HomePage(driver);
		productpage = homepage.clickOnSearchButton();
//		ProductPage productpage = new ProductPage(driver);
		Assert.assertTrue(productpage.verifyInvalidProductWarningMessageDisplay());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
