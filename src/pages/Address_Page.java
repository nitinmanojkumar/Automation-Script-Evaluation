package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.Helper;

public class Address_Page {

	WebDriver driver;
	Helper helper = new Helper();

	@FindBy(css = "[title='Addresses']")
	WebElement addressBtn;

	@FindBy(css = "[title='Add an address']")
	WebElement addNewaddressBtn;

	@FindBy(id = "address1")
	WebElement address1Field;

	@FindBy(id = "city")
	WebElement cityField;

	@FindBy(id = "id_state")
	WebElement stateDropDown;

	@FindBy(id = "postcode")
	WebElement zipField;

	@FindBy(id = "phone")
	WebElement phoneField;
	
	@FindBy(css="[name='alias']")
	WebElement aliasField;

	@FindBy(id = "submitAddress")
	WebElement saveBtn;

	public Address_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addAddress() {
		try {
			addressBtn.click();
			helper.explicitWait(this.driver, addNewaddressBtn);
			addNewaddressBtn.click();
			helper.explicitWait(this.driver, address1Field);
			address1Field.sendKeys("address1");
			cityField.sendKeys("New York");
			Select select = new Select(stateDropDown);
			select.selectByValue("32");
			zipField.sendKeys("10001");
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			phoneField.sendKeys("8089934334");
			aliasField.sendKeys(driver.getWindowHandle().substring(13,19));
			saveBtn.click();
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
