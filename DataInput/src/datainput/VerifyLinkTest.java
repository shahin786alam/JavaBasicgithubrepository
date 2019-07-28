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

public class VerifyLinkTest {

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
		
		//1.get the list of all the links and images:50
		List<WebElement> linklist= driver.findElements(By.tagName("a"));
		 linklist.addAll(driver.findElements(By.tagName("img")));
		 System.out.println("size of active links and img=====>"+linklist.size());
		 
		 List<WebElement> activelinks= new ArrayList <WebElement>();//45
		 
		 //2.iterate linklist : exclude all the links/images - does not have any href attribute
		 for(int i=0; i< linklist.size();i++) {
			 //System.out.println(linklist.get(i).getAttribute("href"));
			 if( linklist.get(i).getAttribute("href") !=null) {
				 activelinks.add(linklist.get(i));	 
			 }
		 }
		 //get the size of active link list:
		 System.out.println("size of active links and img=====>"+activelinks.size());
		//chek the url, with httpconnection api: 
		 //200=== ok
		 //404---not found
		 //500---internal error
		 //400---bad request
		 for(int j=0; j<activelinks.size();j++) {
		 HttpURLConnection connection=	(HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
		connection.connect();
		String respons = connection.getResponseMessage();
		connection.disconnect();
		System.out.println(activelinks.get(j).getAttribute("href")+"===>"+respons);
		
		 }	
	}
}
