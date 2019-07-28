package datainput;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilitytest {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();    //launch chrome
		driver.manage().window().maximize();      //maximize window
		driver.manage().deleteAllCookies();       //delete all the cookies
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		driver.get("https://register.freecrm.com/register/");      //enter url		
		
		driver.findElement(By.id("terms")).click();
		boolean b1= driver.findElement(By.id("terms")).isSelected();
		System.out.println(b1);
		boolean b2= driver.findElement(By.xpath("//button[@name='action']")).isEnabled();
		System.out.println(b2);
		boolean b3= driver.findElement(By.xpath("//button[@name='action']")).isDisplayed();
		System.out.println(b3 );
	}

}
