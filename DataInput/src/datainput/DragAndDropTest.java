package datainput;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
		ChromeDriver driver = new ChromeDriver();  //launch Chrome
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		
		//how many iframe is there
		List<WebElement> totaliframe = driver.findElements(By.tagName("iframe"));
		System.out.println("Total frame is===>"+totaliframe.size());
		
        //switch to particular frame
		driver.switchTo().frame(0);
		
		//doing drag and drop
		Actions action = new Actions(driver);
		// two way we can handle this is frist
		/*action.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
		.moveToElement(driver.findElement(By.xpath("//div[@id='droppable']")))
		.release()
		.build()
		.perform(); */

		// two way we can handle this is second
		WebElement src = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement terget= driver.findElement(By.xpath("//div[@id='droppable']"));
		action.dragAndDrop(src,terget).perform();
		driver.close();
		
	}

}
