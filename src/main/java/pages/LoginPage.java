package pages;


import base.Page;

public class LoginPage extends Page {

	
/*   Instead of creating constructor for every class, create a common base class and 
    inherit it to all required class


	WebDriver driver;
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
*/	
	
	public ZohoAppPage doLogin(String username, String password) throws InterruptedException {
		
		/*
		
		//As it is already declared in goToLogin method in HomePage class
		//driver.findElement(By.cssSelector(".login")).click(); 
		//driver.switchTo().frame(".mobileFlag");
		driver.findElement(By.cssSelector(".textbox.uvtextindent0")).sendKeys(username);
		driver.findElement(By.cssSelector("form[name='login']>.btn.blue")).click();
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("form[name='login']>.btn.blue")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(3000);
		// It aditionally used if we logged in more than 15 times
		driver.findElement(By.xpath("//a[text()='I Understand']")).click();
		*/
		
	// Code optimised and locators are used from properties file and data are used from excel & data provider
		// as we have created click method and stored our locator in a object repository.	
		type("username_CSS", username);
		click("loginBtn_CSS");
		type("password_CSS", password);
		click("loginBtn_CSS");
		
		// It aditionally used if we logged in more than 15 times
		
		//click("understandBtn_XPATH");
		
		
		return new ZohoAppPage();
		
	}
	
	
	
	
	
	public void goToSales() {
		
			
	}
	
	
	
	public void gotoFinance() {
		
		
		
	}
	
	
	
	
}
