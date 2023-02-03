package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class HomePage extends BaseClass{
	
	private By oWelcome = By.xpath("//h3[contains(text(),' Welcome!')]");
	private By oLogout = By.xpath("//a[text()='Logout']");
	private WebDriver driver;
	private SeleniumWrapper oWrap;

	public HomePage(WebDriver driver,ExtentTest node) {
		this.driver = driver;
		this.node = node;
		oWrap = new SeleniumWrapper(driver, node);
	}

	public HomePage validateHomePage() {
		if(oWrap.verifyDisplayedwithReturn(driver.findElement(oWelcome), "Welcome Text")&& oWrap.verifyDisplayedwithReturn(driver.findElement(oLogout), "Logout Link")) {
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
		oWrap.click(driver.findElement(oLogout));
		return new LoginPage(driver,node);
	}
	

}
