package pages;

import org.openqa.selenium.By;
import base.BaseClass;

public class EmailVerificationPage extends BaseClass{
	
	private By oWelcome = By.xpath("//h2[contains(text(),'Welcome To The UiBank Family!')]");
	//private By oLogin = By.linkText("Login");
	private By oUILogo = By.xpath("//a[@class='navbar-brand']");

		
	public EmailVerificationPage verifyUserRegistration() {
		boolean displayed = driver.findElement(oWelcome).isDisplayed();
		if(displayed) {
			System.out.println("User Registration is Successfull!!!");
		}else {
			System.out.println("User Registration is Not Successfull!!!");
		}
		return this;
	} 
	
	public LoginPage clickOnUILogo() {
		driver.findElement(oUILogo).click();
		return new LoginPage();
	}

}
