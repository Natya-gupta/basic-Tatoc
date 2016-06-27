package com.selenium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class basic2 {


	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		//assignment 1
		// Navigate to URL
		driver.get("http://10.0.1.86/");
		driver.get("http://10.0.1.86/tatoc");	
	driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
JavascriptExecutor js=(JavascriptExecutor) driver;
js.executeScript("document.getElementsByClassName('greenbox')[0].click();");//.click();

		//Assignment 2
String color1 = (String) js.executeScript("return document.querySelector('#main').contentWindow.document.querySelector('#answer').className;");
System.out.println(color1);
String color2 = (String) js.executeScript("return document.querySelector('#main').contentWindow.document.querySelector('#child').contentWindow.document.getElementById('answer').getAttribute('class');");
System.out.println(color2);
while(!color1.equals(color2))
{
	js.executeScript("document.getElementById('main').contentWindow.document.getElementsByTagName('a')[0].click();");
	Thread.sleep(3000);
	color2=(String)js.executeScript("return document.querySelector('#main').contentWindow.document.querySelector('#child').contentWindow.document.getElementById('answer').getAttribute('class');");
}		
js.executeScript("document.getElementById('main').contentWindow.document.getElementsByTagName('a')[1].click();");

Thread.sleep(2000);

//Assignment 3

Actions action = new Actions(driver);
WebElement Sourcelocator= (WebElement) js.executeScript(" return document.getElementById('dragbox');");
          WebElement  Destinationlocator = (WebElement) js.executeScript(" return document.getElementById('dropbox');");
action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
WebElement n = (WebElement) js.executeScript("document.getElementsByTagName('a')[0].click();");

//Assignment 4

js.executeScript("document.getElementsByTagName('a')[0].click();");

String winHandleBefore = driver.getWindowHandle();


for(String winHandle : driver.getWindowHandles()){
    driver.switchTo().window(winHandle);
}
js.executeScript("document.getElementById('name').value='heyaa';");
Thread.sleep(3000);
js.executeScript("document.getElementById('submit').click();");
driver.switchTo().window(winHandleBefore);
js.executeScript("document.getElementsByTagName('a')[1].click();");
//Assignment 5
js.executeScript("document.getElementsByTagName('a')[0].click();");
String s=(String) js.executeScript("return document.getElementById('token').innerHTML;");
s=s.substring(7);
Cookie cookie = new Cookie("Token",s);
driver.manage().addCookie(cookie);
js.executeScript("document.getElementsByTagName('a')[1].click();");
}
}