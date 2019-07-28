package datainput;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropBoxHandle1 {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();    //launch chrome
		driver.manage().window().maximize();      //maximize window
		driver.manage().deleteAllCookies();       //delete all the cookies
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");      //enter url	
		driver.findElement(By.id("dropdownMenuButton")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='dropdown-menu' and @aria-labelledby='dropdownMenuButton']//a"));
		System.out.println(list.size());
		
		
		
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("Another action")) {
				list.get(i).click();
				break;
	}
	}
      }
	}
