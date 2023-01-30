package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@BeforeTest
	public void dataSetUp() {
		excelName = "TC001";
	}
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage()
		.validateLoginUIElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "ExcelData")
	public void loginWithValidateCredential(String uName,String password) {
		boolean result = new LoginPage()
		.enterUserName(uName)
		.enterPassword(password)
		.clickOnSignInButton()
		.validateHomePage()
		.clickonLogout()
		.validateLoginUIElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidateCredential() {
		boolean result = new LoginPage()
		.enterUserName("Mathan")
		.enterPassword("Test123")
		.clickOnSignInButtonWithInvalid()
		.validateLoginFailedText();
		Assert.assertTrue(result);
	}

}
