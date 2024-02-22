package base;



import org.openqa.selenium.By;

import crmPage.accountsPage.AccountsPage;




public class TopMenu extends Page {


// We can import page class to this class in current version of selenium 
// but The TopMenu class is already encapsulated in page class
// So we really can't import page class to the TopMenu Class
// Or we can create a constructor of WebDriver driver and
// we can pass this driver as  into page class of TopMenu object, then we can also use driver in this way also. 
		
/*
// We create a constructor bcoz this driver will act as the driver which is declared in page class inside base package.
	WebDriver driver;
	public TopMenu(WebDriver driver) {
		this.driver = driver;
		
	}
	
	*/
	
	public void goToHome() {

		
		
	}

	public void goToLeads() {

		
		
	}

	public void goToContacts() {

		
		
	}

	public AccountsPage goToAccounts() {

	
		//driver.findElement(By.xpath("//div[@class='lyteMenuItems']//span[text()='Accounts']")).click();
		//driver.findElement(By.cssSelector("#Visible_Accounts")).click();
		
		// as we have created click method and stored our locator in a object repository.
		click("accountsMenuLink_XPATH");
		
		return new AccountsPage();
		
	}

	
	
	public void goToDeals() {

		
		
	}

	
	
	public void goToTasks() {

		
		
	}

	
	
	public void goToMeetings() {

		
		
	}

	
	
	public void goToServices() {

		
		
	}

	
	
	public void goToProjects() {

		
		
	}

	
	
}
