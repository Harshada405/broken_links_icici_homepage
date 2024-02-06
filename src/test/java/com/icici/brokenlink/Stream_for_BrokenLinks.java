package com.icici.brokenlink;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Stream_for_BrokenLinks {

	public static void main(String[] args) {

			WebDriver driver;
			driver = new ChromeDriver();
			
			driver.get("https://www.icicibank.com/");
			 
	        // Find all the links on the page
	        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
	 
	        // Use Stream to filter and collect the href attribute of each link
	        List<String> allLinkHrefs = allLinks.stream()
	                .map(link -> link.getAttribute("href"))
	                .filter(href -> href != null && !href.isEmpty())
	                .collect(Collectors.toList());
	 
	        // Print the collected hrefs
	        allLinkHrefs.forEach(System.out::println);
	 
	        // Close the WebDriver
	        driver.quit();
	    }

	}

