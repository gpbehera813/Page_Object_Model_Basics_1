package testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import base.Page;
import crmPage.accountsPage.AccountsPage;
import crmPage.accountsPage.CreateAccountPage;
import pages.ZohoAppPage;
import utilities.Utilities;

public class CreateAccountTest extends BaseTest{
	
	
	@Test(dataProviderClass= Utilities.class, dataProvider="dp")
	public void createAccountTest(Hashtable<String, String> data) throws InterruptedException {
		
		ZohoAppPage zp = new ZohoAppPage();
		zp.goToCRM();
		
		AccountsPage account = Page.menu.goToAccounts();
		
		CreateAccountPage cap = account.goToCreateAccount();
		
		cap.createAccount(data.get("accountName"));
		
		
	}
	

}
