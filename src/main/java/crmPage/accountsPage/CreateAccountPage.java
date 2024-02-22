package crmPage.accountsPage;

import org.openqa.selenium.By;

import base.Page;

public class CreateAccountPage extends Page {
	
	
	public void createAccount(String accountName) {
		
	//	driver.findElement(By.cssSelector("#Crm_Accounts_ACCOUNTNAME_LInput")).sendKeys(accountName);
		
		// as we have created click method and stored our locator in a object repository.
		
		type("accountName_CSS", accountName);
		
		
		
	}
	

}
