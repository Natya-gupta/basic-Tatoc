package com.selenium.example;

import java.util.List;

//import javax.servlet.http.Cookie;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Basic1 {
	public static void main(String args[])throws InterruptedException
	{
WebDriver driver = new FirefoxDriver();
		//assignment 1
		// Navigate to URL
	//	driver.get("http://10.0.1.86/");
		driver.get("http://10.0.1.86/tatoc");
		driver.findElement(By.cssSelector(".page a")).click();
	//	Actions actions = new Actions(driver);
		//actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
	driver.findElement(By.cssSelector(".greenbox")).click();
	//assignment 2
	   driver.switchTo().frame(0);
			WebElement box1=driver.findElement(By.cssSelector("#answer"));
			String classBox1= box1.getAttribute("class");
		     driver.switchTo().frame(driver.findElement(By.cssSelector("#child")));
		     WebElement box2=driver.findElement(By.cssSelector("#answer"));
		     String classBox2= box2.getAttribute("class");
		     
	        driver.switchTo().defaultContent();
	        WebElement link;
	       
		    while(!classBox1.equals(classBox2)){
		    	driver.switchTo().frame(0);
		    	link=  driver.findElement(By.cssSelector("a"));
		    	link.click();
		    	box1=driver.findElement(By.cssSelector("#answer"));
		    	classBox1= box1.getAttribute("class");
		    	driver.switchTo().frame(driver.findElement(By.cssSelector("#child")));
		    	box2= driver.findElement(By.cssSelector("#answer"));
		    	classBox2= box2.getAttribute("class");
		    	driver.switchTo().defaultContent();
	        }
		    driver.switchTo().frame(0);
		    driver.findElement(By.cssSelector("a:last-child")).click();
		    //assignment 3
		    
		    WebElement dragElement=driver.findElement(By.id("dragbox"));
		    WebElement dropElement=driver.findElement(By.id("dropbox"));
		      
		    Actions builder = new Actions(driver);  // Configure the Action
		    
		    Action dragAndDrop = builder.clickAndHold(dragElement)
		      .moveToElement(dropElement)
		      .release(dropElement)
		      .build();  // Get the action
		      dragAndDrop.perform(); // Execute the Action
		   
		      driver.findElement(By.cssSelector("a")).click();
		  driver.findElement(By.cssSelector("a")).click();
		  //assignment 4s
	//driver.findElement(By.cssSelector("input#name")).sendKeys("natya");
		
		 driver.findElement(By.linkText("Launch Popup Window")).click();
		    
		    String winHandleBefore = driver.getWindowHandle();

		    
		    for(String winHandle : driver.getWindowHandles()){
		        driver.switchTo().window(winHandle);
		    }
		    driver.findElement(By.cssSelector("input#name")).sendKeys("heyaa");
		    Thread.sleep(3000);
		    driver.findElement(By.cssSelector("input#submit")).click();
		    driver.switchTo().window(winHandleBefore);
		    driver.findElement(By.linkText("Proceed")).click();
		//assignment 5
		    driver.findElement(By.linkText("Generate Token")).click();
		
		    String inbox = driver.findElement(By.cssSelector("#token")).getText();
		inbox=inbox.substring(7);
		 Cookie cookie = new Cookie("Token", inbox);
	       driver.manage().addCookie(cookie);
	       driver.findElement(By.linkText("Proceed")).click();

		
		  
	}
}