package com.automation.framework.browsersetup;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;


// Setting chrome,firefox,safari drivers

public class BrowserSetUp {
	public WebDriver setBrowser(String driverValue) throws IOException
	{
		
		 WebDriver driver;
		 String fileName="browserpath.properties";
		 PropertyConfigurator.configure("log4j.properties");
		 Logger logger = Logger.getLogger("BrowserSetUp");	
		 Reporter.log("#### BROWSER SETUP CLASS ####"); 
		 logger.info("*** Reading values from file browsersetup.properties****");
		 FileInputStream fs=new FileInputStream(new File(fileName));
		 Properties ps=new Properties();
		 ps.load(fs);
		 String chromDriverPath=ps.getProperty("chromeDriverPath");
		 String firefoxDriverPath=ps.getProperty("fireFoxDriverPath");
		 String safariDriverPath=ps.getProperty("chromeDriverPath");
		 if (BrowserType.Safari.toString().equalsIgnoreCase(driverValue)){
				Reporter.log("#### SAFARI BROWSER SETUP ####"); 
				System.setProperty("webdriver.gecko.driver",safariDriverPath);
				DesiredCapabilities capabilities=DesiredCapabilities.safari();
				capabilities.setCapability("marionette", true);
				driver = new SafariDriver(capabilities);
	    } else if(BrowserType.Firefox.toString().equalsIgnoreCase(driverValue)){
				Reporter.log("#### FIREFOX BROWSER SETUP ####"); 
			    System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
			    DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		        logger.info("// setting marionette to true for not getting time errors");
			    capabilities.setCapability("marionette", true);
			    driver = new FirefoxDriver(capabilities);
	    } else { Reporter.log("#### CHROMEDRIVER BROWSER SETUP ####"); 
			   System.setProperty("webdriver.chrome.driver",chromDriverPath);
			   driver = new ChromeDriver();
			
		}
		return driver;
		
	}

}
