package pages;



import org.openqa.selenium.By;

import base.Page;
import crmPage.CRMHomePage;

public class ZohoAppPage extends Page {

	
/*	 Instead of creating constructor for every class, create a common base class and 
    inherit it to all required class
	
	
	WebDriver driver;
	public ZohoAppPage(WebDriver driver) {
		
		this.driver =driver;
		
	}
	
*/	
	
	public CRMHomePage goToCRM() throws InterruptedException {
		
		//driver.findElement(By.xpath("//ul[@class='myapps']//label[text()='CRM']")).click();
		
		// as we have created click method and stored our locator in a object repository.
		click("crmPageLink_XPATH");
		
		// If it is not directed to CRM Home page then this locator is required
		//driver.findElement(By.cssSelector(".act-btn.cta-btn.bnr-btn")).click(); 
		
		
		return new CRMHomePage();
		
	}
	
	

	public void goToMail() {
		
		driver.findElement(By.xpath("//ul[@class='myapps']//label[text()='Mail']")).click();
		
		
		
	}
	
	public void goToProjects() {
		
		driver.findElement(By.xpath("//ul[@class='myapps']//label[text()='Projects']")).click();
		
		
	}
}
