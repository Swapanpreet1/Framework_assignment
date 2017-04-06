package com.automation.framework.mainpage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
	public WebDriver driver;
	public String fileName="mainpage.properties";
	private String urlLink;
	private String LoginClick;
	
	public  MainPage(WebDriver driver) {
		this.driver = driver; 
    }
    
	 public void mainPage() throws IOException { 
	 FileInputStream fs= new FileInputStream(new File(fileName));
	 Properties ps=new Properties();
	 ps.load(fs);
	 urlLink=ps.getProperty("urlLink");
	 LoginClick=ps.getProperty("LoginClick");
	 openUrl();
	 LoginClick();
	 }
	
	 //Open the Browser
	public void openUrl() {
		driver.get(urlLink);
	}
	
	//Click on login link on mainpage
	public void LoginClick() {
		 driver.findElement(By.cssSelector(LoginClick)).click(); 
    }


}
