package common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import pages.SignIn_Page;

public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
	}
	
	@AfterSuite
	public void afterSuite() {
		//driver.quit();
	}
	
	
}
