package com.freecrm.qa.basesetup;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.freecrm.qa.util.WebEventListener;

public class BaseSetup {
	public static WebDriver driver;
	public static Properties prop;
	public static String browserName;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public BaseSetup() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/freecrm"
					+ "/qa/config/config.properties");
			prop.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browsername");
		System.out.println(browserName);
		if(browserName.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/SeleniumWebDrivers/chromedriver.exe");
			driver=new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("FirefoxDriver")){
			System.setProperty("webdriver.gecko.driver", System.getProperty
					("user.dir")+"/SeleniumWebDrivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}else{
			System.out.println("null pointer");
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.valueOf(prop.getProperty("pageloadtime")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.valueOf(prop.getProperty("implicitwaittime")), TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
