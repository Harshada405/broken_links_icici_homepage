package com.icici.brokenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class Broken_links_using_Stream_Api {

	private static WebDriver driver;
	
	public static int getResponseCode(String address) throws MalformedURLException, IOException {
		
		HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(address).openConnection();
        httpURLConnection.setConnectTimeout(8000);
        return httpURLConnection.getResponseCode();
		
	}
	
	

	public static void main(String[] args) throws MalformedURLException, IOException {
		driver= new ChromeDriver();
		driver.manage().window().maximize(); // maximise window 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait for page and elements on page to load 
		driver.get("https://www.icicibank.com/"); // open url
		List<WebElement> links = driver.findElements(By.tagName("a")); // capture links from a webpage 
		int count = links.size();
		System.out.println(count);
		List<String> url = new ArrayList<String>();
		String url1="";
		
		for(WebElement e: links) {
			 url1 = e.getAttribute("href");
			  url.add(url1);
			  long response = getResponseCode(url1);
			  //links.stream().distinct().
			  System.out.println(response);
				
		}}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}


