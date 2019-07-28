package datainput;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();  //launch Chrome	
		driver.get("http://spicejet.com/");	
		driver.manage().window().maximize();	
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("ADD-ONS"))).build().perform();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Travel Insurance")).click();
		
		 
		
		
		
		
		
		
	}

}
