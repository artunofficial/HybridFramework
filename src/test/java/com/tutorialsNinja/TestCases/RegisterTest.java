package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsNinja.Pages.AccountSuccessPage;
import com.tutorialsNinja.Pages.HomePage;
import com.tutorialsNinja.Pages.RegisterPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.ExcelCode;
import com.tutorialsNinja.Utilities.Util;

public class RegisterTest extends TestBase{
	
	public RegisterTest() throws Exception {
		super();
	}
	public WebDriver driver;
	public RegisterPage registerpage;
	public HomePage homepage;
	public AccountSuccessPage accountsuccesspage;
	
	
	@BeforeMethod
	public void registerSetup() {
		
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		registerpage = homepage.combiningTwoActionsToNavigateToRegisterPage();
//		homepage.clickOnMyAccount();
//		homepage.selectRegisterOption();
		//driver.findElement(By.linkText("My Account")).click(); //We called the parent class which is HomePage
		//driver.findElement(By.linkText("Register")).click();
	}
	
	
	@Test(priority=1, dataProvider = "TNRegister", dataProviderClass = ExcelCode.class)
	public void verifyRegisterWithMandatoryDetails(String firstname, String lastname, String telephone, String password, String confirmpassword) {
		
//		registerpage = new RegisterPage(driver);
//		registerpage.enterFirstName(firstname);
//		registerpage.enterLastName(lastname);
//		registerpage.enterEmail(Util.emailWithDateTimeStamp());
//		registerpage.enterTelephone(telephone);
//		registerpage.enterPassword(password);
//		registerpage.enterConfirmPassword(confirmpassword);
//		registerpage.checkPrivacyPolicyCheckBox();
//		registerpage.clickOnContinueButton();
//		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		accountsuccesspage = registerpage.combininMandatoryDetailsToNavigateToAccountSuccesPage(firstname, lastname, Util.emailWithDateTimeStamp(), telephone, password, confirmpassword);
		Assert.assertTrue(accountsuccesspage.validateAccountSuccessCreatedMessage());
	}
	
	@Test(priority=2)
	public void verifyRegisterWithAllDetails() {
		
//		RegisterPage registerpage = new RegisterPage(driver);
//		registerpage.enterFirstName(dataProp.getProperty("firstName"));
//		registerpage.enterLastName(dataProp.getProperty("lastName"));
//		registerpage.enterEmail(Util.emailWithDateTimeStamp());
//		registerpage.enterTelephone(dataProp.getProperty("telephone"));
//		registerpage.enterPassword(prop.getProperty("validPassword"));
//		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerpage.clickOnNewsLetterRadioButton();
//		registerpage.checkPrivacyPolicyCheckBox();
//		registerpage.clickOnContinueButton();
//		AccountSuccessPage accountsuccesspage = new AccountSuccessPage(driver);
		accountsuccesspage = registerpage.combininAllDetailsToNavigateToAccountSuccesPage(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), 
				dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		Assert.assertTrue(accountsuccesspage.validateAccountSuccessCreatedMessage());
	}
	
	@Test(priority=3)
	public void verifyRegisterWithExistingEmail() {
		
		registerpage.combininAllDetailsToNavigateToAccountSuccesPage(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), prop.getProperty("validEmail"), 
				dataProp.getProperty("telephone"), prop.getProperty("validPassword"), prop.getProperty("validPassword"));
//		RegisterPage registerpage = new RegisterPage(driver);
//		registerpage.enterFirstName(dataProp.getProperty("firstName"));
//		registerpage.enterLastName(dataProp.getProperty("lastName"));
//		registerpage.enterEmail(prop.getProperty("validEmail"));
//		registerpage.enterTelephone(dataProp.getProperty("telephone"));
//		registerpage.enterPassword(prop.getProperty("validPassword"));
//		registerpage.enterConfirmPassword(prop.getProperty("validPassword"));
//		registerpage.clickOnNewsLetterRadioButton();
//		registerpage.checkPrivacyPolicyCheckBox();
//		registerpage.clickOnContinueButton();
//		String actualExistingEmailWarningMessage = registerpage.retrieveDuplicateEmailWarningMessage();
//		String expectedExistingEmailWarningMessage = dataProp.getProperty("existingEmailWarning");
		Assert.assertTrue(registerpage.retrieveDuplicateEmailWarningMessage().contains(registerpage.retrieveDuplicateEmailWarningMessage()));
	}
	
	@Test(priority=4)
	public void verifyRegisterWithWrongConfirmPassword() {
		
//		RegisterPage registerpage = new RegisterPage(driver);
//		registerpage.enterFirstName(dataProp.getProperty("firstName"));
//		registerpage.enterLastName(dataProp.getProperty("lastName"));
//		registerpage.enterEmail(Util.emailWithDateTimeStamp());
//		registerpage.enterTelephone(dataProp.getProperty("telephone"));
//		registerpage.enterPassword(prop.getProperty("validPassword"));
//		registerpage.enterConfirmPassword(dataProp.getProperty("invalidPassword"));
//		registerpage.clickOnNewsLetterRadioButton();
//		registerpage.checkPrivacyPolicyCheckBox();
//		registerpage.clickOnContinueButton();
		registerpage.combininAllDetailsToNavigateToAccountSuccesPage(dataProp.getProperty("firstName"), dataProp.getProperty("lastName"), Util.emailWithDateTimeStamp(), 
				dataProp.getProperty("telephone"), prop.getProperty("validPassword"), dataProp.getProperty("invalidPassword"));
//		String actualConfirmPasswordWarningMessage = registerpage.retrieveWrongConfirmPasswordWarningMessage();
//		String expectedWrongConfirmPasswordWarningMessage = dataProp.getProperty("wrongConfirmPasswordWarning");
		Assert.assertTrue(registerpage.retrieveWrongConfirmPasswordWarningMessage().contains(dataProp.getProperty("wrongConfirmPasswordWarning")));
	}
	
	@Test(priority=5)
	public void verifyRegisterWithNoDetails() {
		
		registerpage.clickOnContinueButton();
		Assert.assertTrue(registerpage.retrieveAllWarningMessages(dataProp.getProperty("privacyPolicyWarning"), dataProp.getProperty("firstNameWarning"), 
				dataProp.getProperty("lastNameWarning"), dataProp.getProperty("invalidEmailWarning"), dataProp.getProperty("telephoneWarning"), 
				dataProp.getProperty("passwordWarning")));
//		String actualPrivacyPolicyWarningMessage = registerpage.retrievePrivacyWarningMessage();
//		String expectedPrivacyPolicyWarningMessage = dataProp.getProperty("privacyPolicyWarning");
//		Assert.assertEquals(actualPrivacyPolicyWarningMessage, expectedPrivacyPolicyWarningMessage); EDITED VERSION BELOW HERE
		
//		String actualPrivacyPolicyWarningMessage = registerpage.retrievePrivacyWarningMessage();
//		String expectedPrivacyPolicyWarningMessage = dataProp.getProperty("privacyPolicyWarning");
//		Assert.assertEquals(registerpage.retrievePrivacyWarningMessage(), dataProp.getProperty("privacyPolicyWarning"));
		
//		String actualFirstNameWarningMessage = registerpage.retrieveFirstNameWarningMessage();
//		String expectedFirstNameWarningMessage = dataProp.getProperty("firstNameWarning");
//		Assert.assertTrue(registerpage.retrieveFirstNameWarningMessage().contains(dataProp.getProperty("firstNameWarning")));
			
//		String actualLastNameWarningMessage = registerpage.retrieveLastNameWarningMessage();
//		String expectedLastNameWarningMessage = dataProp.getProperty("lastNameWarning");
//		Assert.assertTrue(registerpage.retrieveLastNameWarningMessage().contains(dataProp.getProperty("lastNameWarning")));
		
//		String actualEmailWarningMessage = registerpage.retrieveEmailWarningMessage();
//		String expectedEmailWarningMessage = dataProp.getProperty("invalidEmailWarning");
//		Assert.assertTrue(registerpage.retrieveEmailWarningMessage().contains(dataProp.getProperty("invalidEmailWarning")));
		
//		String actualTelephoneWarningMessage = registerpage.retrieveTelephoneWarningMessage();
//		String expectedTelephoneWarningMessage = dataProp.getProperty("telephoneWarning");
//		Assert.assertTrue(registerpage.retrieveTelephoneWarningMessage().contains(dataProp.getProperty("telephoneWarning")));
		
//		String actualPasswordWarningMessage = registerpage.retrievePasswordWarningMessage();
//		String expectedPasswordWarningMessage = dataProp.getProperty("passwordWarning");
//		Assert.assertTrue(registerpage.retrievePasswordWarningMessage().contains(dataProp.getProperty("passwordWarning")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
