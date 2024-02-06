package com.icici.brokenlink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class icici_webpage_broken_links {


	public static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		// Initiate driver 
		//ChromeOptions opt = new ChromeOptions();
        //opt.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(); 	
		driver.manage().window().maximize(); // maximise window 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait for page and elements on page to load 
		driver.get("https://www.icicibank.com/"); // open url
	    Thread.sleep(5000); // explicit delay 
		
		List<WebElement> links = driver.findElements(By.tagName("a")); // capture links from a webpage 
		int count = links.size();
		System.out.println(count);
		
		List<String> urlList = new ArrayList<String>();
		String url = "";
		
		for ( WebElement e: links) {
			url = e.getAttribute("href");
			//urlList.add(url);
			checkBrokenLink(url); 
			}
		
		
		//long sTime = System.currentTimeMillis();
		//urlList.parallelStream().forEach(e->checkBrokenLink(e));  ll by using paralle stream
		//long endtime = System.currentTimeMillis();
        driver.quit();  
        }
		
	public static void checkBrokenLink(String linkUrl) {
		  Set<String> brokenurls = new HashSet<String>();
		try {  
     // using set to store brokenurls
     URL url = new URL(linkUrl);	                                                                                      //	Proxy proxy = new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress("hostname",8080));
     HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();   
     httpconn.setConnectTimeout(5000);                                                                                                // u can give here proxy argument
     int response= httpconn.getResponseCode();
	 if ( response>=400) {
		   System.out.println(linkUrl+"====broken link =====" +httpconn.getResponseMessage());
			brokenurls.add(linkUrl);   // add url with status code greater than 400 that is broken url
	 }
	 else {System.out.println(linkUrl+ " =====valid url ====" +httpconn.getResponseMessage()); }}
	 
//	 for( String brokenurl: brokenurls) {		
//			System.out.println(brokenurl);}
//		}

     catch(Exception e )
     
     {
	       e.printStackTrace();

     }


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	}


