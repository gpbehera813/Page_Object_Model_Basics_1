package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.Utilities;

public class Page {

	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader("src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public static ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test; //= new ExtentTest( "","");
	public static String browser;
	public static TopMenu menu;
	public static WebElement dropdown;
	
	
	
	public Page() {

		if (driver == null) {

			// this code is used for getting data from properties file
			// (we can use this by try catch method or by throwing exception

			PropertyConfigurator
					.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");

			try {

				fis = new FileInputStream(new File(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Configuration.properties"));

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			try {

				Config.load(fis);

			} catch (IOException e) {
				e.printStackTrace();
			}

			log.debug("Configuration file loaded !!!");

			// We can use the fileInputStream method like below method also.
			// FileInputStream fis = new
			// FileInputStream(System.getProperty("user.dir")+"src\\test\\resources\\properties\\Configuration.properties");

			try {

				fis = new FileInputStream(new File(
						System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\ObjectRepo.properties"));

			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			try {

				OR.load(fis);

			} catch (IOException e) {
				e.printStackTrace();
			}

			log.debug("Object Repo file loaded !!!");

			// Jenkins Browser Filter Configuration

			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");

			} else {

				browser = Config.getProperty("browser");

			}

			Config.setProperty("browser", browser);

			if (Config.getProperty("browser").equals("Chrome")) {

				// ChromeOptions code is used for disable notifications which was generated
				// during page loading

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable-extentions");
				options.addArguments("--disable-infobars");

				// It will act as a constructor but it is not required as it is opening two
				// browser at the same time
				// driver = new ChromeDriver(options);

				driver = new ChromeDriver(options);
				log.debug("Chrome browser launched !!!");

			} else if (Config.getProperty("browser").equals("Edge Driver")) {

				driver = new EdgeDriver();
				log.debug("Microsoft Edge browser is launched !!!");

			} else if (Config.getProperty("browser").equals("Firefox")) {

				driver = new FirefoxDriver();
				log.debug("Firefox browser is launched !!!");

			} else {

				driver = new InternetExplorerDriver();
				log.debug("Internet Explorer browser is launched !!!");

			}

			driver.manage().window().maximize();
			driver.navigate().to(Config.getProperty("testenvironment"));
			log.debug("Navigated to: " + Config.getProperty("testenvironment"));

			// We can add implicity wait like below method
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("waitTime")),TimeUnit.SECONDS);
			// Thread.sleep(3000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			menu = new TopMenu();
			
			
		}

	}
	
	
	
	
	public static void quit() {
		
		driver.quit();
	}
	

	
	public static void click(String locator) {

		
		if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_TAGNAME")) {

			driver.findElement(By.tagName(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).click();

		} else if (locator.endsWith("_CLASSNAME")) {

			driver.findElement(By.className(OR.getProperty(locator))).click();

		} else {

			driver.findElement(By.name(OR.getProperty(locator))).click();
		}

		// As we declared individually by separate locators by using if else statemnt
		// driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		
		 test.log(LogStatus.INFO, "Clicked on : " + locator);

	}

	public static void type(String locator, String value) {
		

		if (locator.endsWith("_CSS")) {

			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_XPATH")) {

			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_TAGNAME")) {

			driver.findElement(By.tagName(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_ID")) {

			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_CLASSNAME")) {

			driver.findElement(By.className(OR.getProperty(locator))).sendKeys(value);

		} else {

			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);

		}

		// As we declared individually by separate locators by using if else statemnt
		// driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		log.debug("Typing in an Element : " + locator + "entered value as :"+value);
		test.log(LogStatus.INFO, "Typed in : " + locator + "Entered value as :" + value);

	}

	

	public static void select(String locator, String value) {
		

		if (locator.endsWith("_CSS")) {

			dropdown = driver.findElement(By.cssSelector(OR.getProperty(locator)));

		} else if (locator.endsWith("_XPATH")) {

			dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));

		} else if (locator.endsWith("_TAGNAME")) {

			dropdown = driver.findElement(By.tagName(OR.getProperty(locator)));

		} else if (locator.endsWith("_ID")) {

			dropdown = driver.findElement(By.id(OR.getProperty(locator)));

		} else if (locator.endsWith("_CLASSNAME")) {

			dropdown = driver.findElement(By.className(OR.getProperty(locator)));

		} else {

			dropdown = driver.findElement(By.name(OR.getProperty(locator)));

		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		
		log.debug("Selecting from an Element : " + locator + " value as : " + value);
		test.log(LogStatus.INFO, "Selecting from dropdown : " + locator + "value as :" + value);

	}

	public static void verifyEquals(String expected, String actual) throws IOException {
		

		try {

			Assert.assertEquals(actual, expected);

		} catch (Throwable t) {

			Utilities.captureScreenshot();
			// This code is for report NG report
			// if failure occure its will generate failure message & screenshot and
			// it will further execute the remaining codes
			Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
			Reporter.log("<a target=\"_Blank\" href=" + Utilities.screenshotName + "><img src=" + Utilities.screenshotName + " height=300 width=300></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");

			// same concept report generation for Extent reports if code fails

			test.log(LogStatus.FAIL, "Verification failed with exception :" + t.getMessage());

			test.log(LogStatus.FAIL, test.addScreenCapture(Utilities.screenshotName));

		}

	}

	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {

			return false;

		}

	}

}
