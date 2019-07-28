package datainput;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink_EasyTest1 {

	public static void main(String[] args) throws IOException {
		
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
	WebDriver driver = new ChromeDriver();	//launch chrome
	driver.manage().window().maximize();     //maximize window
	driver.manage().deleteAllCookies();       //delete all the cookies
	//dynamic wait
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS );
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.facebook.com");
	
	//add all link and img
	List<WebElement> linklist = driver.findElements(By.tagName("a"));
	linklist.addAll(driver.findElements(By.tagName("img")));
	System.out.println("Total size of link and img====>"+linklist.size());
	
	for(int i=0; i<linklist.size(); i++) {
		String url= linklist.get(i).getAttribute("href");
		URL links = new URL(url);
		HttpURLConnection connection = (HttpURLConnection)links.openConnection();
		connection.connect();
		int rescode = connection.getResponseCode();
		if(rescode>=400) {
			System.out.println(url+"====>"+"is broken link");
		}
		else {
			System.out.println(url+"===>"+"is valid link");
  }
  }
	} 
	}
