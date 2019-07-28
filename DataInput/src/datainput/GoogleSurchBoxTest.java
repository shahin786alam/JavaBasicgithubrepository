package datainput;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSurchBoxTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();	
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.navigate().refresh();
		driver.get("https://www.Google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("love");
		List <WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		System.out.println("Total list of suggession in searchbox====>"+list.size());
		Thread.sleep(5000);//ul[@role='listbox']//li/descendant::div[@class='sbl1
		
		for(int i=0; i<list.size(); i++) {
		System.out.println(list.get(i).getText());	
		if(list.get(i).getText().equals("love park")) {
		list.get(i).click();
		break;
		}
		}
		driver.close();
	}
}
