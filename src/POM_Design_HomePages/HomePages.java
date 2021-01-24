package POM_Design_HomePages;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePages {
	 WebDriver browser;
	public HomePages(WebDriver browser) {
		// TODO Auto-generated constructor stub
		this.browser = browser;
		
	}

	public WebElement SignInButton() {
		
		WebElement btn = browser.findElement(By.id("gb_70"));
		return btn;
		
		
	}
	
public WebElement search() {
		
		WebElement search = browser.findElement(By.name("q"));
		return search;
		
		
	}

public WebElement result() {
	
	WebElement result = browser.findElement(By.id("result-stats"));
	return result;
	
	
}
public void enterBtn(Keys k) {
	
	browser.findElement(By.name("q")).sendKeys(k);
	
	
}

public void enterBtn(String text) {
	
	browser.findElement(By.name("q")).sendKeys(text);
	
	
}
}