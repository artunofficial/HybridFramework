package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	//In the page class we will define the WebElements, we will initialize the WebElements and we will create action for those WebElements
	
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	@FindBy(name = "search")
	private WebElement searchBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
		//Action to call these Object in the form of methods
		
		public void clickOnMyAccount() {
			myAccountDropdown.click();
		}
		
		public LoginPage selectLoginOption() {
			loginOption.click();
			return new LoginPage(driver);
		}
		
		public LoginPage combiningTwoActionsToNavigateToLoginPage() {
			myAccountDropdown.click();
			loginOption.click();
			return new LoginPage(driver);
		}
		
		public RegisterPage combiningTwoActionsToNavigateToRegisterPage() {
			myAccountDropdown.click();
			registerOption.click();
			return new RegisterPage(driver);
		}
		
		public void selectRegisterOption() {
			registerOption.click();
		}
		
		public void enterProductName(String validProductText) {
			searchBox.sendKeys(validProductText);
		}
		
		public ProductPage clickOnSearchButton() {
			searchButton.click();
			return new ProductPage(driver);
		}
		
		public ProductPage navigateToProductPage(String validProductText) {
			searchBox.sendKeys(validProductText);
			searchButton.click();
			return new ProductPage(driver);
		}
		
	
	
	
	
	
}
