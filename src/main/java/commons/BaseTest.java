package commons;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import factoryBrowser.ChromeWebDriverManager;
import factoryBrowser.FirefoxWebDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class BaseTest {
	
	WebDriver driver;
	
	protected final Log log;
	
	protected BaseTest() {
		log = LogFactory.getLog(getClass());
	}
	
	
	protected boolean verifyTrue(boolean condition) {
		boolean status = true;
		try {
			Assert.assertTrue(condition);
			log.info("---------PASSED---------");
		} catch (Throwable e) {
			status = false;
			log.info("---------FAILED---------");
		}	
		return status;
	}
	
	protected boolean verifyFalse(boolean condition) {
		boolean status = true;
		try {
			Assert.assertFalse(condition);
			log.info("---------PASSED---------");
		} catch (Throwable e) {
			status = false;
			log.info("---------FAILED---------");
		}
		return status;
	}
	
	protected boolean verifyEquals(Object actualResult, Object expectedResult) {
		boolean status = true;
		try {
			Assert.assertEquals(actualResult, expectedResult);
			log.info("---------PASSED---------");
		} catch (Throwable e) {
			status = false;
			log.info("---------FAILED---------");
		}
		return status;
	}
	
	protected WebDriver getBrowserName(String browserName, String url) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		switch (browserList) {
		case CHROME:
			driver = new ChromeWebDriverManager().getBrowserDriver();
			break;
		case FIREFOX:
			driver = new FirefoxWebDriverManager().getBrowserDriver();
			break;
		default:
			throw new IllegalArgumentException("Browser name is invalid");
		}
		driver.get(url);
	 	driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
	 	driver.manage().window().maximize();
		return driver;
	}
	
	protected static int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
 	
 	protected void sleepInSecond(long second) {
 		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
		}
 	}

 	protected void closeBrowserAndDriver() {
		String cmd = "";
		try {
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);
			
			String driverInstanceName = driver.toString().toLowerCase();
			log.info("Driver instance name = " + driverInstanceName);

			if (driverInstanceName.contains("chrome")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverInstanceName.contains("internetexplorer")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driverInstanceName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverInstanceName.contains("edge")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
				} else {
					cmd = "pkill msedgedriver";
				}
			} else if (driverInstanceName.contains("opera")) {
				if (osName.contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq operadriver*\"";
				} else {
					cmd = "pkill operadriver";
				}
			} else if (driverInstanceName.contains("safari")) {
				if (osName.contains("mac")) {
					cmd = "pkill safaridriver";
				}
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		} finally {
			try {
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
 	
 	protected String getCurrentTime() {
 		Date date = new Date();
 		return date.toString();
 				
 	}
 	
 	protected static long getRandomNumberByDateTime() {
		return Calendar.getInstance().getTimeInMillis();
 	}

	public WebDriver getDriver() {
		return this.driver;
	}
}
