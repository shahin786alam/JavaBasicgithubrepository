package datainput;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();    //launch chrome
		driver.manage().window().maximize();      //maximize window
		driver.manage().deleteAllCookies();       //delete all the cookies
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		driver.get("https://www.google.co.in");      //enter url
		
		
		//links-----//a href<http://www.google.com
		//img-------//img href<http://www.facebook
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> activelinks = new ArrayList<WebElement> ();
		//!=null && (!linkslist.get(i).getAttribute("href").contains("javascript")
		
		for (int i=0; i<linkslist.size();i++) {
			if(linkslist.get(i).getAttribute("href")!=null ) {
				 activelinks.add(linkslist.get(i));	
			}
		}
		System.out.println("size of active links and img--->"+activelinks.size());
		for(int j=0; j<activelinks.size();j++) {
			HttpURLConnection Connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
			Connection.connect();
			String response= Connection.getResponseMessage();
			Connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+"====>"+response);
			
		}		
	}
}
