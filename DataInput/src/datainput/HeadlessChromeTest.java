package datainput;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HeadlessChromeTest {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions option= new ChromeOptions ();
		option.addArguments("window-size=1400,800");
		option.addArguments("headless");
		WebDriver driver = new ChromeDriver(option);
		
		driver.get("https://www.facbook.com");
		//driver.manage().window().maximize();
		
		String crentpage= driver.getCurrentUrl();
		System.out.println(crentpage);
		String title = driver.getTitle();
		System.out.println(title);
		
		Select select = new Select(driver.findElement(By.id("month")));
		select.selectByVisibleText("Dec");
		System.out.println("month");
		
		
		
	}

}
