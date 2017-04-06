package com.automation.framework.emailsigninpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSignInPage {
	public WebDriver driver;
	public  EmailSignInPage (WebDriver driver) {
		this.driver=driver;
	}

	 final String randomEmail = randomEmail(); 
	 String enterEmail;
	 String clickSignUp;
	 String fileName="emailsignin.properties";
	
 //Function for Generating Random Email Every Time
     private static String randomEmail() {
	        return "random-" + UUID.randomUUID().toString() + "@yopmail.com";
	    }
		
//Reading File and maintaining Functions
     
	public void emailSignIn() throws IOException {
    FileInputStream fin= new FileInputStream(new File(fileName));
   	Properties pr=new Properties();
   	pr.load(fin);
   	enterEmail=pr.getProperty(" enterEmail");
    clickSignUp=pr.getProperty("clickSignUp");
    enterEmail();
    clickSignUp();
    }

// Enter the Random Email
	public void enterEmail() {
	driver.findElement(By.cssSelector(enterEmail)).sendKeys(randomEmail);
	     }
	
// Click on SignUp button	
    public void  clickSignUp() {
	driver.findElement(By.cssSelector(clickSignUp)).click();
	}

}
