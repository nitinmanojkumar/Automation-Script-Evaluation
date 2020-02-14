package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper{

	
	
	public void explicitWait(WebDriver driver,WebElement element) {
		WebDriverWait webdriverWait=new WebDriverWait(driver, 10);
		webdriverWait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void explicitWait_Invisible(WebDriver driver,WebElement element) {
		WebDriverWait webdriverWait=new WebDriverWait(driver, 10);
		webdriverWait.until(ExpectedConditions.invisibilityOf(element));
	}
}
