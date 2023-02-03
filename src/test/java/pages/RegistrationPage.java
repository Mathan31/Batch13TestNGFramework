package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper; 

public class RegistrationPage extends BaseClass{
	

	private By oFirstName = By.id("firstName");
	private By oMiddleName = By.id("middleName"); 
	private By oLastName = By.id("lastName");
	private By oUserName = By.id("username");
	private By oEmail = By.id("email");
	private By oPassword = By.id("password");
	private By oRegister = By.xpath("//button[text()='Register']");
	private By oTitle = By.id("title");
	private By oGender = By.id("sex");
	private By oUILogo = By.xpath("//a[@class='navbar-brand']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public RegistrationPage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean verifyAllTheRegistrationFields() {
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(oUserName)) && oWrap.verifyDisplayedwithReturn(driver.findElement(oPassword))
				&& oWrap.verifyDisplayedwithReturn(driver.findElement(oEmail))&& oWrap.verifyDisplayedwithReturn(driver.findElement(oRegister),"Register Button")) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public RegistrationPage enterFirstName(String fName) {
		oWrap.type(driver.findElement(oFirstName), fName);
		return this;
	}
	
	public RegistrationPage selectTitle(String title) {
		oWrap.selectDropDownUsingVisibleText(driver.findElement(oTitle), title);
		return this;
	}
	
	public RegistrationPage enterMiddleName(String mName) {
		oWrap.type(driver.findElement(oMiddleName), mName);
		return this;
	}
	
	public RegistrationPage enterLastName(String lName) {
		oWrap.type(driver.findElement(oLastName), lName);
		return this;
	}
	
	public RegistrationPage selectGender(String gender) {
		oWrap.selectDropDownUsingVisibleText(driver.findElement(oGender), gender);
		return this;
	}
	
	public RegistrationPage enterUserName(String uName) {
		oWrap.type(driver.findElement(oUserName), uName);
		return this;
	}
	
	public RegistrationPage enterEmail(String email) {
		oWrap.type(driver.findElement(oEmail), email);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) {
		oWrap.type(driver.findElement(oPassword), password);
		return this;
	}
	
	public EmailVerificationPage clickOnRegisterBtn() {
		oWrap.click(driver.findElement(oRegister));
		return new EmailVerificationPage(driver,node);
	}

	public LoginPage clickOnUILogo() {
		oWrap.click(driver.findElement(oUILogo),"UIBank Logo");
		return new LoginPage(driver,node);
	}
}
