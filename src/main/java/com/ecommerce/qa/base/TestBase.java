//second commit
package com.ecommerce.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class TestBase {
	 static WebDriver driver;
	 static Properties prop;
	 
	public TestBase() throws FileNotFoundException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\pmohaldar\\eclipse-workspace\\"
				+ "EcommerceDemo\\src\\main\\java\\com\\ecommerce\\qa\\config\\config.properties");
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void initialize()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.getProperty("webdriver.chrome.driver","C:\\Users\\pmohaldar\\eclipse-workspace\\chromedriver_win32");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("FF"))
		{
			System.getProperty("webdriver.gecko.driver","C:\\Users\\pmohaldar\\eclipse-workspace\\geckodriver-v0.23.0-win32");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	

}
