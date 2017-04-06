package com.automation.framework.initliazebrowser;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;

import com.automation.framework.browsersetup.BrowserCollections;
import com.automation.framework.browsersetup.BrowserSetUp;

public class InitiliazeBrowser {
	
		public static WebDriver driversel;
		
		@BeforeClass
		public void initiliazeBrowse() throws Exception {
			
			PropertyConfigurator.configure("log4j.properties");
			Logger logger = Logger.getLogger(" InitiliazeBrowser");	
			Reporter.log("### BROWSER SELECTING ANS LAUNCHING ###");
			logger.info("*** Selecting Browser ****");
			String driverSelected=BrowserCollections.WebBrowser();
			logger.info("*** Setup Browser ****");
			BrowserSetUp browser=new BrowserSetUp();
			logger.info("*** Running choosen Browser ****");
			driversel=(WebDriver)browser.setBrowser(driverSelected);
			driversel.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}

}


