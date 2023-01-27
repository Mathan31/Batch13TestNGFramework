package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class LoginPage extends BaseClass{

	private By oUsernameText = By.id("username");
	private By oPasswordText = By.id("password");
	private By oSignInBtn = By.xpath("//button[text()='Sign In']");
	private By oForgotLink = By.xpath("//*[text()='Register For Account']");
	private By oRegisterLink = By.xpath("//*[text()='Register For Account']");
	private By oLoginFailedInnerText = By.xpath("//div[contains(text(),'login failed')]");
	
	public boolean validateLoginUIElements() {
		if(driver.findElement(oUsernameText).isDisplayed() && 
				driver.findElement(oPasswordText).isDisplayed() &&
				driver.findElement(oSignInBtn).isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
	public LoginPage enterUserName(String uName) {
		driver.findElement(oUsernameText).sendKeys(uName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		driver.findElement(oPasswordText).sendKeys(password);
		return this;
	}
	
	public HomePage clickOnSignInButton() {
		driver.findElement(oSignInBtn).click();
		return new HomePage();
	}
	
	public LoginPage clickOnSignInButtonWithInvalid() {
		driver.findElement(oSignInBtn).click();
		return this;
	}
	
	public boolean validateLoginFailedText() {
		boolean result = driver.findElement(oLoginFailedInnerText).isDisplayed();
		return result;
	}

	public RegistrationPage clickOnRegistrationLink() {
		driver.findElement(oRegisterLink).click();
		return new RegistrationPage();
	}
}
