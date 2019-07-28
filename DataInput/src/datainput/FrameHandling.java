package datainput;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();  //launch Chrome	
		driver.get("https://classic.crmpro.com/index.html");	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.navigate().refresh();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("khamerbari");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Shahin786");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		//handle frame for this code
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();

	}

}
