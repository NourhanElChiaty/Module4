package POM_Design_Test_Cases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.print.Pageable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Design_HomePages.HomePages;
import POM_Design_HomePages.SignedIn_Page;

public class T_01_How_To_Locate_Elements {

	 WebDriver driver;
	





@BeforeTest
public  void Launch_Browser()
{
	
	String chromePath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	System.setProperty("webdriver.chrome.driver", chromePath);
	driver = new ChromeDriver();

	driver.manage().window().maximize();
	driver.navigate().to("https://www.google.com/?hl=ar");

	driver.findElement(By.partialLinkText("Eng")).click();
}


@Test(priority=1)
public  void Login_With_Invalid_Email() throws InterruptedException
{
	
	HomePages page = new HomePages(driver);
	SignedIn_Page signedIn = new SignedIn_Page(driver);
	//driver.findElement(By.id("gb_70")).click();
	page.SignInButton().click();

	signedIn.SignInInput().sendKeys("asw2");

	signedIn.loginButton().click();

	Thread.sleep(2000);

	String actualResult;
	actualResult = signedIn.result().getText();
	Reporter.log(actualResult);
	//System.out.println(actualResult);
	assertEquals(actualResult, "Couldn�t find your Google Account");
	
	//System.out.println(actualResult.equals("Couldn�t find your Google Account"));
	

}

@Test(priority=2)
public void Verify_Forgot_Email_URL()
{
   SignedIn_Page urlObject = new SignedIn_Page(driver);
   WebElement url = urlObject.SignInURL();
   url.click();
	//driver.findElement(By.xpath("//button[@jsname=\"Cuz2Ue\"]")).click();

	String actualResult;
	actualResult = driver.getCurrentUrl();
	Reporter.log(actualResult);
	//System.out.println(actualResult);
	
	assertTrue(actualResult.contains("/signin/v2/usernamerecovery"));
	//System.out.println(actualResult.contains("/signin/v2/usernamerecovery"));

}

@Test(priority=3)
public  void Google_Search() {
	driver.navigate().to("https://www.google.com/?hl=eng");
	HomePages page = new HomePages(driver);
	WebElement search = page.search();
	search.click();
	
	
	page.enterBtn("Selenium");
	page.enterBtn(Keys.ENTER);
	
	
	WebElement actual = page.result();
	//System.out.println(actual.getText());
	Reporter.log(actual.getText());

	SoftAssert soft = new SoftAssert();
	soft.assertEquals(actual.getText().equals("46,200,000"),true);
try {
    soft.assertAll();
	}
	catch(AssertionError e) {
		System.out.println(e.getMessage());
		System.out.println(e.toString());
	}
	//System.out.println(actual.getText().contains("46,200,000"));
	
	
}
@AfterMethod
public void goToHomePage(ITestResult result) {
	
	if(result.isSuccess() == true) 
	{
		System.out.println("Pass");
	}
	else if(result.isSuccess()== false) {
		System.out.println("Failed");
		
	}
	
	//driver.navigate().to("https://www.google.com/?hl=en");
}
@AfterTest
public void Close_Driver()
{
	driver.quit();

}

}
