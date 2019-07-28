 package datainput;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUpLoadPopUp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();  //launch Chrome	
		driver.get("http://html.com/input-type-file/");	
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.id("fileupload")).sendKeys("C:\\Users\\Shahin Alam\\Desktop");
		
		
		
		
		
		
		
		

	}

}
