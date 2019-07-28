package datainput;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

public class HtmlUnitDriverTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");

		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new HtmlUnitDriver();

		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.manage().window().maximize();
		driver.get("https://www.google.com");


		String s=driver.getTitle();
		System.out.println(s);
		String f=driver.getCurrentUrl();
		System.out.println(f);
		
        //this two line for right click
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.name("q"))).contextClick().build().perform();




	}

}
