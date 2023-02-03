package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class LoginPage extends BaseClass{

	private By oUsernameText = By.id("username");
	private By oPasswordText = By.id("password");
	private By oSignInBtn = By.xpath("//button[text()='Sign In']");
	private By oForgotLink = By.xpath("//*[text()='Register For Account']");
	private By oRegisterLink = By.xpath("//*[text()='Register For Account']");
	private By oLoginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	private WebDriver driver;
	private SeleniumWrapper oWrap;
	
	public LoginPage(WebDriver driver,ExtentTest node) { 
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}
	
	public boolean validateLoginUIElements() {
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(oUsernameText))  && 
				oWrap.verifyDisplayedwithReturn(driver.findElement(oPasswordText)) &&
				oWrap.verifyDisplayedwithReturn(driver.findElement(oSignInBtn), "SignIn Button")) {
			return true;
		}else {
			return false;
		}
	}
	
	public LoginPage enterUserName(String uName) {
		oWrap.type(driver.findElement(oUsernameText), uName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		oWrap.type(driver.findElement(oPasswordText), password);
		return this;
	}
	
	public HomePage clickOnSignInButton() {
		oWrap.click(driver.findElement(oSignInBtn));
		return new HomePage(driver,node);
	}
	
	public LoginPage clickOnSignInButtonWithInvalid() {
		oWrap.click(driver.findElement(oSignInBtn));
		return this;
	}
	
	public boolean validateLoginFailedText() {
		boolean result = oWrap.verifyDisplayedwithReturn(driver.findElement(oLoginFailedInnerText), "Login Fail Text");
		return result;
	}

	public RegistrationPage clickOnRegistrationLink() {
		oWrap.click(driver.findElement(oRegisterLink));
		return new RegistrationPage(driver,node);
	}
}
