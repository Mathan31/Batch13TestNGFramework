package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;
import utilities.FakerDataFactory;

public class TC002_Registration extends BaseClass{
	
	@BeforeTest
	public void dataSetUp() {
		testName = "Registration Validation";
		testDescription = "Validate Registration with mandatory and non mandatory fields";
		module = "Registration";
	}
	
	@Test(priority = 1)
	public void registrationFieldValidation() {
		boolean resultRegistration = new LoginPage(driver)
		.clickOnRegistrationLink()
		.verifyAllTheRegistrationFields();
		
		boolean result = new RegistrationPage(driver)
		.clickOnUILogo()
		.validateLoginUIElements();
		
		Assert.assertTrue(resultRegistration);
		Assert.assertTrue(result);
		
	}
	
	@Test(priority = 2)
	public void registrationWithMandatoryFields() {
		boolean result = new LoginPage(driver)
		.clickOnRegistrationLink()
		.enterFirstName(FakerDataFactory.getFirstName())
		.selectTitle(FakerDataFactory.getTitle())
		.enterMiddleName(FakerDataFactory.getMiddleName())
		.enterLastName(FakerDataFactory.getLastName())
		.selectGender(FakerDataFactory.getGender())
		.enterUserName(FakerDataFactory.getUserName())
		.enterEmail(FakerDataFactory.getEmailAddress())
		.enterPassword(FakerDataFactory.getPassword())
		.clickOnRegisterBtn()
		.verifyUserRegistration()
		.clickOnUILogo()
		.validateLoginUIElements();
		Assert.assertTrue(result);
	}
	
	//@Test(priority = 3)
	public void registrationWithMandatoryOptionalFields() {
		
	}
	
}
