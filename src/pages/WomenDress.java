package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import common.Helper;

public class WomenDress {

	WebDriver driver;
	Helper helper = new Helper();

	@FindBy(xpath = "(//*[@title='Women'])[1]")
	WebElement womensBtn;

	
	@FindBy(xpath = "(//*[@href='http://automationpractice.com/index.php?id_category=8&controller=category'])[3]")
	WebElement DressBtn;
	
	@FindBy(xpath = "(//*[@href='http://automationpractice.com/index.php?id_category=11&controller=category'])[3]")
	WebElement SummDressBtn;

	@FindBy(xpath = "[title='Summer Dresses']")
	WebElement summerDressBtn;

	@FindBy(xpath = "//*[@title='List']//i")
	WebElement listViewICon;

	String productView="(//*[@class='product-container']//*[contains(text(),'More')])";
	//@FindBy(xpath = "(//img[@title='Printed Summer Dress'])[1]")
	//WebElement firsProductView;

	@FindBy(css = "[id='quantity_wanted']")
	WebElement quantityField;

	@FindBy(css = "[id='group_1']")
	WebElement sizeDropDown;

	@FindBy(xpath = "//*[@class='color_pick']")
	WebElement colorSelect;

	@FindBy(css = "[name='Submit']")
	WebElement submitBtn;
	
	@FindBy(css = "[title='Continue shopping']")
	WebElement continueShoppingBtn;
	
	@FindBy(css = "[title='Proceed to checkout']")
	WebElement checkOutBtn;
	

	@FindBy(xpath = "(//*[@title='Proceed to checkout'])[2]")
	WebElement checkOutBtn1;
	
	@FindBy(xpath="//*[contains(text(),'I agree to the terms of service and will adhere to them unconditionally.')]")
	WebElement agreeCheckBox;
	
	@FindBy(css = "[title='Pay by check.']")
	WebElement payByCheck;
	
	@FindBy(xpath = "//*[@name='processAddress']")
	WebElement submitBtn2;
	
	@FindBy(xpath = "//*[@name='processCarrier']")
	WebElement submitBtn3;
	
	@FindBy(css = "[type='Submit']")
	WebElement submitBtn1;
	
	

	public WomenDress(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void addDress(String Qunatity,int prodNumber,boolean checkout) throws InterruptedException {
		helper.explicitWait(this.driver, womensBtn);
		womensBtn.click();
		/*Actions action = new Actions(driver);
		action.moveToElement(womensBtn).moveToElement(summerDressBtn).click().build().perform();
		summerDressBtn.click();*/
		Thread.sleep(500);
		helper.explicitWait(this.driver, DressBtn);
		DressBtn.click();Thread.sleep(500);
		helper.explicitWait(this.driver, SummDressBtn);
		SummDressBtn.click();
		
		helper.explicitWait(this.driver, listViewICon);
		listViewICon.click();
		
		WebElement element=driver.findElement(By.xpath(productView+"["+prodNumber+"]"));
		helper.explicitWait(this.driver, element);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		element.click();
		helper.explicitWait(this.driver, quantityField);
		quantityField.clear();
		quantityField.sendKeys(Qunatity);
		Select select = new Select(sizeDropDown);
		select.selectByValue("3");
		colorSelect.click();
		submitBtn.click();
		helper.explicitWait(this.driver, continueShoppingBtn);
		if(checkout==false) {
			continueShoppingBtn.click();
		}else {
			checkOutBtn.click();
		}
		

	}
	
	public void completePayment() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		helper.explicitWait(this.driver, checkOutBtn1);
		js.executeScript("window.scrollBy(0,500)");
		checkOutBtn1.click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,500)");
		submitBtn2.click();
		Thread.sleep(2000);
		helper.explicitWait(this.driver, agreeCheckBox);
		agreeCheckBox.click();
		submitBtn3.click();
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,500)");
		helper.explicitWait(this.driver, payByCheck);
		payByCheck.click();
		helper.explicitWait(this.driver, submitBtn1);
		submitBtn1.click();
	}
}
