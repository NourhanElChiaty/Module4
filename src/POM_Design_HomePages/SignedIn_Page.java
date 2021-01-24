package POM_Design_HomePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignedIn_Page {
	WebDriver browser;
	
	public SignedIn_Page(WebDriver browser) {
		// TODO Auto-generated constructor stub
		this.browser = browser;
	}
	
	
	public WebElement SignInInput() {
		WebElement input =	browser.findElement(By.cssSelector("input[aria-label=\"Email or phone\"]"));
		return input;
}
	
	public WebElement loginButton() {
		WebElement btn =	browser.findElement(By.xpath("//button[@jscontroller=\"soHxf\" and @jsname=\"LgbsSe\"]"));
		return btn;
}
	
	public WebElement result() {
		WebElement result =	browser.findElement(By.xpath("//div[@jsname=\"B34EJ\"]/div[@class=\"o6cuMc\"]"));
		return result;
}
	
	public WebElement SignInURL() {
		WebElement url =	browser.findElement(By.xpath("//button[@jsname=\"Cuz2Ue\"]"));
		return url;
}

}
