package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public  static WebDriver driver;
	public  int iBrowserType = 1;
	public String sURL = "https://uibank.uipath.com/";
	
	@BeforeClass
	public  void invokingBrowser() {
		switch (iBrowserType) {
		case 1:
			System.out.println("User option is : "+iBrowserType+" ,So invoking Chrome Browser. ");
			driver = new ChromeDriver();
			break;
			
		case 2:
			System.out.println("User option is : "+iBrowserType+" ,So invoking FF Browser. ");
			driver = new FirefoxDriver();
			break;
			
		case 3:
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
	}
	
	@AfterClass
	public  void closeBrowser() {
		driver.quit();
	}
	

}
