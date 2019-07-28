package datainput;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupWindow {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver ();
	driver.get("http://www.ksrtc.in/oprs-web/");	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.navigate().refresh();
	Thread.sleep(5000);
	driver.findElementByXPath("//*[@id=\"bookingsForm\"]/div/div/div[2]/div[3]/button").click(); //search for bus
	Thread.sleep(5000);
	Alert alert = driver.switchTo().alert();	
	alert.accept();
	//driver.quit();
	//alert.sendKeys("I can writing anything in here");	
	//alert.getText();	
	//alert.dismiss();//if you click on cancel button	
		
		
		
		
		
		
		
		
	}

}
