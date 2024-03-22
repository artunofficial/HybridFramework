package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.AccountPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.LoginPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.ExcelCode;
import com.tutorialsNinja.Utilities.Util;

public class LoginTest extends TestBase{
	
	
	public LoginTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public AccountPage accountpage;
	
	
	
	@BeforeMethod
	public void loginSetup() {
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		loginpage = homepage.combiningTwoActionsToNavigateToLoginPage();
		//homepage.clickOnMyAccount();
		////driver.findElement(By.linkText("My Account")).click();
		//loginpage = homepage.selectLoginOption(); //This action returns a new page known as LoginPage
		//driver.findElement(By.linkText("Login")).click(); We are calling those from HomePage class
		
	}
	
	
	@Test(priority = 1, dataProvider = "TNLogin", dataProviderClass = ExcelCode.class)
	public void loginWithValidCredentials(String email, String password) {
		
//		loginpage.enterEmail(email);
//		loginpage.enterPassword(password);
//		loginpage.clickOnLoginButton();
		accountpage = loginpage.navigateToLoginPageByCombiningTheActions(email, password);
		//driver.findElement(By.id("input-email")).sendKeys(email);
		//driver.findElement(By.id("input-password")).sendKeys(password);
		//driver.findElement(By.cssSelector("input.btn.btn-primary")).click(); //We are calling those from LoginPage class
//		accountpage = new AccountPage(driver);
		Assert.assertTrue(accountpage.validateDisplayDatasOfLogoutLink());
		//Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed()); //We are calling those from AccountPage class
		
	}
	
	@Test(priority = 2)
	public void loginWithValidEmailInvalidPassword() {
		
		loginpage.navigateToLoginPageByCombiningTheActions(prop.getProperty("validEmail"), dataProp.getProperty("invalidPassword"));
//		loginpage.enterEmail(prop.getProperty("validEmail"));
//		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
//		loginpage.clickOnLoginButton();
//		String actualWarningMessage = loginpage.retrieveLoginMessageWarningText();
		//String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class, 'alert-dismissible')]")).getText();
//		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
//		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
	}
	
	@Test(priority = 3)
	public void loginWithInvalidEmailValidPassword() {
		
		loginpage.navigateToLoginPageByCombiningTheActions(Util.emailWithDateTimeStamp(), prop.getProperty("validPassword"));
//		loginpage.enterEmail(Util.emailWithDateTimeStamp());
//		loginpage.enterPassword(prop.getProperty("validPassword"));
//		loginpage.clickOnLoginButton();
//		String actualWarningMessage = loginpage.retrieveLoginMessageWarningText();
//		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
	}
	
	@Test(priority = 4)
	public void loginWithInvalidCredentials() {

		loginpage.navigateToLoginPageByCombiningTheActions(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
//		loginpage.enterEmail(Util.emailWithDateTimeStamp());
//		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
//		loginpage.clickOnLoginButton();
//		String actualWarningMessage = loginpage.retrieveLoginMessageWarningText();
//		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
	}
	
	@Test(priority = 5)
	public void loginWithNoCredentials() {

		loginpage.navigateToLoginPageByCombiningTheActions(Util.emailWithDateTimeStamp(), dataProp.getProperty("invalidPassword"));
//		loginpage.clickOnLoginButton();
		String actualWarningMessage = loginpage.retrieveLoginMessageWarningText();
		String expectedWarningMessage = dataProp.getProperty("loginWarningMessage");
		Assert.assertTrue(loginpage.retrieveLoginMessageWarningText().contains(dataProp.getProperty("loginWarningMessage")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
