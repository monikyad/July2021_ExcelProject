package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

	static WebDriver driver;
	static String browser;
	static String url;
	
	public static void readConfig() {
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("src\\main\\java\\config\\config.properties");
			prop.load(input);
			browser= prop.getProperty("browser");
			System.out.println("Browser used: " +browser);
			url = prop.getProperty("url");
			
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static WebDriver init() {
		readConfig();
		if(browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.firefox.bin", "drivers\\geckodriver.exe");
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver.exe");
			System.out.println(System.getProperty("webdriver.gecko.driver"));
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(driver);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
	
	public static void tearDown() {
		driver.close();
		driver.quit();
	}
}
