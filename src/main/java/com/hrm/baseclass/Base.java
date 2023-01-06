package com.hrm.baseclass;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.hrm.utilities.ConfigReader;
import com.hrm.utilities.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	
public static WebDriver driver;
public static Logger logger;

@BeforeMethod(alwaysRun = true)
public static WebDriver setUp() {
	//launch browser
	ConfigReader.readProperties(Constants.CONFIGS_FILE_PATH);
	switch (ConfigReader.getProperty("browser").toLowerCase()) {
	case "chrome":
		//System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		break;
	case "Edge":
		WebDriverManager.edgedriver();
		driver = new EdgeDriver();
		break;
	default:
		throw new RuntimeException("Browser is not supported");
	}
	//Full screen current window
	driver.manage().window().fullscreen();
	//implicit wait 
	driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
	//For Loggin 
	logger = LogManager.getLogger("HRM");
	//Open url 
	driver.get(ConfigReader.getProperty("URL"));
	return driver;
			}	
		@AfterMethod(alwaysRun = true) // to make this method to run after every @Test method
			public static void tearDown() {
				if (driver != null) {
					driver.quit();
				}
			}

}
