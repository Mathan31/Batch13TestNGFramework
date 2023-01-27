package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_Registration extends BaseClass{
	
	@Test(priority = 1)
	public void registrationFieldValidation() {
		boolean resultRegistration = new LoginPage()
		.clickOnRegistrationLink()
		.verifyAllTheRegistrationFields();
		
		boolean result = new RegistrationPage()
		.clickOnUILogo()
		.validateLoginUIElements();
		
		Assert.assertTrue(resultRegistration);
		Assert.assertTrue(result);
		
	}
	
	@Test(priority = 2)
	public void registrationWithMandatoryFields() {
		boolean result = new LoginPage()
		.clickOnRegistrationLink()
		.enterFirstName("Credo")
		.selectTitle("Mr")
		.enterMiddleName(" ")
		.enterLastName("Systemz")
		.selectGender("Male")
		.enterUserName("credosystemz"+getRandomIntNumber(1,10000))
		.enterEmail("credosystemz"+getRandomIntNumber(1,10000)+"@gmail.com")
		.enterPassword("Testing123")
		.clickOnRegisterBtn()
		.verifyUserRegistration()
		.clickOnUILogo()
		.validateLoginUIElements();
		Assert.assertTrue(result);
	}
	
	//@Test(priority = 3)
	public void registrationWithMandatoryOptionalFields() {
		
	}
	
	public int getRandomIntNumber(int start,int end) {
		Random ran = new Random();
		int result = ran.nextInt((end - start)+1) + 1;
		return result;
	}

}
