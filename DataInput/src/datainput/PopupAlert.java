package datainput;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupAlert {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
	ChromeDriver driver = new ChromeDriver();  //launch Chrome	
	driver.get("https://mail.rediff.com/cgi-bin/login.cgi");	
	driver.manage().window().maximize();
	//driver.navigate().refresh();
	//dynamic wait:
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.findElementByXPath("//input[@type='submit']").click();	
	//Thread.sleep(4000);	
	Alert alert = driver.switchTo().alert();	
	System.out.println("what is that:"+alert.getText());	
	String text = alert.getText();
	if(text.equals("Please enter a valid user name")) {
		System.out.println("correct alert messg");
	}
	else {
		System.out.println("in-correct alert messg");	
	}
	alert.accept();   //click on Ok button	
	//alert.dismiss();	//click on cancel button
	driver.quit();	
	}

}
