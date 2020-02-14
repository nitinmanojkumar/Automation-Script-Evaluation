package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn_Page {

	WebDriver driver;
	
	@FindBy(css="[class='login']")
	WebElement signInIcon;
	
	@FindBy(id="email")
	WebElement emailField;
	
	@FindBy(id="passwd")
	WebElement pwdField;
	
	@FindBy(css="[name='SubmitLogin']")
	WebElement signInBtn;
	
	public SignIn_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sigin(String usnm,String pwd) {
		signInIcon.click();
		emailField.sendKeys(usnm);
		pwdField.sendKeys(pwd);
		signInBtn.click();
	}
	
	
}
