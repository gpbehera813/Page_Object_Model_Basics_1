package crmPage.accountsPage;

import org.openqa.selenium.By;

import base.Page;

public class AccountsPage extends Page  {
	
		
	public CreateAccountPage goToCreateAccount() {
		
	// we can automate using static dropdown but We are simply writing the code to automate the framework 

		//driver.findElement(By.xpath("//button[@data-zcqa='cv_createbtn']")).click();
		
		// as we have created click method and stored our locator in a object repository.
		
		click("accountbtn_XPATH");  
		
		return new CreateAccountPage();
		
	}

	
	
	public void goToImportAccounts() {
		
		
		
		
	}

	
	
}
