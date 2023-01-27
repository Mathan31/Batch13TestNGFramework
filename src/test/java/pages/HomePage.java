package pages;

import org.openqa.selenium.By;

import base.BaseClass;

public class HomePage extends BaseClass{
	
	private By oWelcome = By.xpath("//h3[contains(text(),' Welcome!')]");
	private By oLogout = By.xpath("//a[text()='Logout']");
	

	public HomePage validateHomePage() {
		if(driver.findElement(oWelcome).isDisplayed()&& driver.findElement(oLogout).isDisplayed()) {
			System.out.println("User Landed to the Home Page!!!");
			return this;
		}else {
			System.out.println("User not in Home Page.");
			return this;
		}
	}
	
//	public ApplyForNewAccountPage clickApplyForNewAccount() {
//		wrap.click(driver.findElement(oApplyForNewAccount));
//		return new ApplyForNewAccountPage(driver,node);
//	}
	 
	public LoginPage clickonLogout() {
		driver.findElement(oLogout).click();;
		return new LoginPage();
	}
	

}
