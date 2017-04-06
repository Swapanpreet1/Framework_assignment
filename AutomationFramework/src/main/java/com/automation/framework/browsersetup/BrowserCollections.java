package com.automation.framework.browsersetup;

import java.util.Random;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BrowserCollections {
	private static String browserValue=null;
	
	public static String WebBrowser() {  
    	
	    PropertyConfigurator.configure("log4j.properties");
		Logger logger = Logger.getLogger("BrowserCollections");	
		Random random = new Random();
		int choose = random.nextInt(4);  
  		logger.info("****  RANDOMLY Select the browser from range 1 to 3  *** ");
  		logger.info("1)  CHROME");
  		logger.info("2)  FIREFOX");
  		logger.info("3)  SAFARI");
  		switch(choose ) {
        case 1:logger.info("Chrome");
  		 browserValue="Chrome";       
  		 break;
  		 case 2: logger.info("Firefox");
  		 browserValue="FireFox";
  	     break;
  		 case 3:logger.info("SaFari");
  		 browserValue="Safari";
  		 break;
  		 default:logger.info("Chrome");
  		  browserValue="Chrome";
  		  }
  		 return browserValue;

    }
	

}
