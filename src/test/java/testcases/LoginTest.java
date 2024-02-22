package testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.Utilities;

public class LoginTest  {
	
	@Test(dataProviderClass= Utilities.class, dataProvider="dp")
	public void loginTest(Hashtable<String, String> data) throws InterruptedException {
		
		HomePage hp = new HomePage();
		
		LoginPage lp = hp.goToLogin();
		
		lp.doLogin(data.get("username"), data.get("password"));
		
	}
	

}
