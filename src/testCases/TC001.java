package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import common.TestBase;
import pages.Address_Page;
import pages.CheckOutPage;
import pages.SignIn_Page;
import pages.WomenDress;

public class TC001 extends TestBase{


	SignIn_Page signInPage;
	Address_Page addressPage;
	WomenDress womenDressPage;
	CheckOutPage checkoutObj;
	
	@Test
	public void test() throws InterruptedException, IOException {
		driver.get("http://automationpractice.com/index.php");
		signInPage=new SignIn_Page(driver);
		signInPage.sigin("nitinmanojkumar@gmail.com","123456");
		addressPage=new Address_Page(driver);
		addressPage.addAddress();
		womenDressPage=new WomenDress(driver);
		womenDressPage.addDress("5",1,true);
		//womenDressPage.addDress("5",2,false);
		//womenDressPage.addDress("5",3,true);
		womenDressPage.completePayment();
		checkoutObj=new CheckOutPage(driver);
		checkoutObj.orderHistory();
	}
	
}
