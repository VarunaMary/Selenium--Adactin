package com.project;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AdactinHotelApp {

	public static void main(String[] args) throws IOException {
//Launching the browser in incognito mode.         
		ChromeOptions ch=new ChromeOptions ();
		ch.addArguments("incognito");
		WebDriver dr=new ChromeDriver(ch);
		dr.manage().window().maximize();
		dr.get("http://adactinhotelapp.com/index.php");
//Login 
		dr.findElement(By.id("username")).sendKeys("VarunaMary");
		dr.findElement(By.id("password")).sendKeys("papputyson10");
		dr.findElement(By.id("login")).click();
//Search hotel
		WebElement location = dr.findElement(By.id("location"));
		Select a=new Select(location);
		a.selectByIndex(8);
		WebElement hotel = dr.findElement(By.id("hotels"));
		Select b=new Select(hotel);
		b.selectByValue("Hotel Sunshine");
		WebElement roomType = dr.findElement(By.id("room_type"));
		Select c=new Select(roomType);
		c.selectByVisibleText("Super Deluxe");
		WebElement checkIn = dr.findElement(By.id("datepick_in"));
		checkIn.clear();
		checkIn.sendKeys("10/03/2023");
		WebElement checkOut = dr.findElement(By.id("datepick_out"));
		checkOut.clear();
		checkOut.sendKeys("17/03/2023");
		dr.findElement(By.id("Submit")).click();
//Select hotel
		dr.findElement(By.xpath("//input[@type='radio']")).click();
		dr.findElement(By.id("continue")).click();
//Book a hotel & cancel
		dr.findElement(By.id("first_name")).sendKeys("Varuna");
		dr.findElement(By.id("last_name")).sendKeys("Mary");
		dr.findElement(By.id("address")).sendKeys("17/36b,Kulasekharam,Kanyakumari district.");
		dr.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("1234 5678 4321 8765");
		WebElement cardType = dr.findElement(By.xpath("//select[@id='cc_type']"));
		Select d=new Select(cardType);
		d.selectByVisibleText("VISA");
		WebElement expiryMonth = dr.findElement(By.xpath("//select[@id='cc_exp_month']"));
		Select e=new Select(expiryMonth);
		e.selectByValue("5");
		WebElement expiryYear = dr.findElement(By.xpath("//select[@id='cc_exp_year']"));
		Select f=new Select(expiryYear);
		f.selectByVisibleText("2022");
		dr.findElement(By.id("cc_cvv")).sendKeys("371");
		dr.findElement(By.id("cancel")).click();
//Log out
		dr.findElement(By.linkText("Logout")).click();
//Capture Screenshot
		TakesScreenshot ts=(TakesScreenshot) dr;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\varun\\eclipse-workspace\\Selenium\\Screenshot\\Project\\Adactin Hotel App.png");
		FileUtils.copyFile(src, des);
		
		
		
		
		
		
		
		
		
	}

}
