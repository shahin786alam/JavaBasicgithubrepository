package datainput;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	WebDriver driver;
	
	@BeforeMethod
	public  void SetUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
		driver = new ChromeDriver();	
		driver.get("https://www.Google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.navigate().refresh();	
	}
@Test
public void Googlelugotest() { 
	boolean b = driver.findElement(By.xpath("//*[@id=\"hplogo\"]/a/img")).isDisplayed();
	System.out.println(b);
}

	
	
@AfterMethod
public void tearDown() {
	driver.quit();
} 

}