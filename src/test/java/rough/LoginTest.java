package rough;

import base.Page;
import crmPage.accountsPage.AccountsPage;
import crmPage.accountsPage.CreateAccountPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ZohoAppPage;



public class LoginTest extends Page  {
	
	public static void main(String[] args) throws InterruptedException {

// We can extend the class HomePage to the class loginTest
// We can us e the WebDriver driver as globally by declaring as WebDriver as globally with public & Static
// or we can pass the driver as a parameter to the HomePage object		
		
		
		/* As we declare in one base class and inherit that class to all required class 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.zoho.com/");
		*/
		
	
	/*	This code example of simple page object model
		
		HomePage hp = new HomePage();
		
		hp.goToLogin();
		
		LoginPage lp = new LoginPage();
		
		lp.doLogin("seleniumpractice2024@gmail.com", "Selenium@12345");
		
		ZohoAppPage zp = new ZohoAppPage();
		
		zp.goToCRM();
		
		page.menu.goToAccounts();
		
		AccountsPage account = new AccountsPage();
		
		account.goToCreateAccount();
		
		CreateAccountPage cap = new CreateAccountPage();
		
		cap.createAccount("Shyam");
		
		*/
		
	// Here we do not want create object of each class instead of that
	// we return the upcomming class which will execute after execution of current class
	// After that we can optimize our code into simpler version or small no. of lines	
		
		HomePage hp = new HomePage();
		
		LoginPage lp = hp.goToLogin();
		
		ZohoAppPage zp = lp.doLogin("seleniumpractice2024@gmail.com", "Selenium@12345");
		
		zp.goToCRM();
		
		AccountsPage account = Page.menu.goToAccounts();
		
		CreateAccountPage cap = account.goToCreateAccount();
		
		cap.createAccount("Shyam");
		
		
		
		/*
		 *  // We can use all this method in single line code as it return the upcomming class method 
		 * 
		hp.goToLogin().doLogin("seleniumpractice2024@gmail.com", "Selenium@12345").goToCRM();
		Page.menu.goToAccounts().goToCreateAccount().createAccount("Shyam");
		*/
		
		
		
	}

}
