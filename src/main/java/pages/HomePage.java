package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


import base.Page;

public class HomePage extends Page {
	
	//public static WebDriver driver;
	
	
/*  Instead of creating constructor for every class, create a common base class and 
    inherit it to all required class
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
	}

*/	
	
	
	public LoginPage goToLogin() {
		/*
		 *  We optimized the code by storing the locator in properties file and Element
		 * 
		driver.findElement(By.cssSelector(".login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		*/
		
		// as we have created click method and stored our locator in a object repository.
		
		click("loginLink_XPATH");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new LoginPage();
		
	}
	
	
	public void goToSignUp() {
		
		driver.findElement(By.cssSelector(".signUp")).click();
		
		
	}

	
	public void validateFooterLinks() {
		
		
		
	}
	
	
	
	
	
	
	
}
