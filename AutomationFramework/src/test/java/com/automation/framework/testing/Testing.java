package com.automation.framework.testing;

import java.io.IOException;
import java.util.logging.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.automation.framework.emailsigninpage.EmailSignInPage;
import com.automation.framework.initliazebrowser.InitiliazeBrowser;
import com.automation.framework.mainpage.MainPage;
import com.automation.framework.signinclickpage.SignInClickPage;

public class Testing extends InitiliazeBrowser {
			
			@Test
			public void mainPageOpen() throws IOException {
				
				PropertyConfigurator.configure("log4j.properties");
				Logger logger = Logger.getLogger("TetsingWithPageFactory ");
				Reporter.log("###  LAUNCHING MAINPAGE");
				logger.info("**** Intiliaze Browser ****");
				MainPage mainPageOpen = PageFactory.initElements(driversel, MainPage.class);
				mainPageOpen.mainPage();
				
			
				Reporter.log("###  LAUNCHING SIGNUP PAGE ###");
				logger.info("**** Intiliaze Signinclick page ****");
				 SignInClickPage Page2 = PageFactory.initElements(driversel, SignInClickPage.class);
				 Page2.signInClickPage();
	}
			
			@Test
			public void SignUp() throws IOException {
				
				
				PropertyConfigurator.configure("log4j.properties");
				Logger logger = Logger.getLogger("TetsingWithPageFactory ");
				 Reporter.log("###  LAUNCHING EMAILSIGNUP PAGE ###");
				 logger.info("**** Intiliaze SigninclickEmailSignup page ****");
				 EmailSignInPage Page3 = PageFactory.initElements(driversel,EmailSignInPage.class);
				 Page3.emailSignIn();
			}
			
			
		}


