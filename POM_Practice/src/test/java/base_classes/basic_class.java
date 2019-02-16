package base_classes;

import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Utility.ExcelUtil;


public class basic_class {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream file;
	public static WebDriverWait wait;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	//public static final String testDataExcelFileName = "TestData.xlsx";
	//ExcelUtil excel;
	
	
	@BeforeClass
	public void setup() throws Exception {
		
		log.info("*****Test Init stage*****");
		
		if(driver==null) {
			file=new FileInputStream("./src/test/resources/Properties/config.properties");
			config.load(file);
		}
		
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			log.info("Open Chrome driver..");
		}else if(config.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/Drivers/geckodriver.exe");
			driver=new FirefoxDriver();
			log.info("Open Firefox driver..");
		}else if(config.getProperty("browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./src/test/resources/Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			log.info("Open IE driver..");
		}else {
			System.setProperty("webdriver.chrome.driver", "./src/test/resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			log.info("Open Chrome driver..");
		}
		
		driver.get(config.getProperty("testURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,20);
		log.info("Web browser window maximized..");
		
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		log.info("*****Close driver*****");

	}

	public WebElement waitForElement(WebDriver driver, WebElement element, long timeOutInSeconds) {
		wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	
	public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void staticWait(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (Exception e) {
			System.out.println("Wait failed!");
		}
	}
	
	
	
}
