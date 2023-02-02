package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentTest;

import libraries.HTMLReport;
import utilities.ExcelReader;
import utilities.PropertiesReader;

public class BaseClass extends HTMLReport{
	
	public WebDriver driver;
	public String prodFileName = "Environment_Details";
	public String iBrowserType = PropertiesReader.getPropertyValue(prodFileName, "browser");
	public String sURL = PropertiesReader.getPropertyValue(prodFileName, "production");
	public String excelName = "";
	public String testName,testDescription,module;
	
	@BeforeSuite
	public void reportIniti() {
		startReport();
	}
	
	@AfterSuite
	public void endReport() {
		endReport();
	}

	@BeforeClass
	public  void invokingBrowser() {
		iBrowserType = iBrowserType.toLowerCase();
		switch (iBrowserType) {
		case "chrome":
			System.out.println("User option is : "+iBrowserType+" ,So invoking Chrome Browser. ");
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			System.out.println("User option is : "+iBrowserType+" ,So invoking FF Browser. ");
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			System.out.println("User option is : "+iBrowserType+" ,So invoking Edge Browser. ");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("User option is wrong : "+iBrowserType+" ,So invoking the default Chrome Browser. ");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		startTestCase(testName, testDescription);
		startTestcase(module);
	}
	
	@AfterClass
	public  void closeBrowser() {
		driver.quit();
	}
	
	
	@DataProvider(name="ExcelData")
	public Object[][] readExcelValue() {
		Object[][] valueFromExcel = ExcelReader.getValueFromExcel(excelName);
		return valueFromExcel;
	}

	@Override
	public String takeScreenshot() {
		String sPath = System.getProperty("user.dir")+"/snap/img"+System.currentTimeMillis()+".png";
		TakesScreenshot oShot = (TakesScreenshot)driver;
		File osrc = oShot.getScreenshotAs(OutputType.FILE);
		File dis = new File(sPath);
		try {
			FileUtils.copyFile(osrc, dis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sPath;
	}

}
