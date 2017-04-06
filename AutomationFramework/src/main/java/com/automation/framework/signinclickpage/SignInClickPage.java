package com.automation.framework.signinclickpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInClickPage {
	public  WebDriver driver;
	String fileName="signinclick.properties";
    String signInclick;
	
	public  SignInClickPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void signInClickPage() throws IOException {
    FileInputStream fs= new FileInputStream(new File(fileName));
   	Properties ps=new Properties();
   	ps.load(fs);
   	signInclick=ps.getProperty("signInclick");
    signInClick(); 
    }
	 
//Clicking on SignUp button
	public void signInClick() {
		 driver.findElement(By.cssSelector(signInclick)).click(); 
     }


}
