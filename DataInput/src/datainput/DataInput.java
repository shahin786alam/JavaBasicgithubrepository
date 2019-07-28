package datainput;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataInput {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
	ChromeDriver driver = new ChromeDriver();	
	driver.get("https://www.yahoo.com");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();	
	driver.navigate().refresh();	
	/*driver.findElementByXPath("//a[@id='uh-signin']").click();	
	driver.findElementByXPath("//input[@class='phone-no ']").sendKeys("shahin786alam@yahoo.com");
	Thread.sleep(3000);
	driver.findElementByXPath("//*[@id=\"login-signin\"]").click();
	Thread.sleep(3000);
	driver.findElementByXPath("//input[@id='login-passwd']").sendKeys("nushratjahan");
	Thread.sleep(3000);
	driver.findElementByXPath("//*[@id=\"login-signin\"]").click();	
	driver.findElementByXPath("//span[@class=' D(ib) Fz(14px) Fw(b) Va(t) C(#4d00ae) Lh(37px)']").click();
	driver.findElementByXPath("//span[@role='presentation']").click();
	driver.findElementByXPath("//span[contains(text(),'Sign out')]").click();*/
	driver.navigate().to("https://www.facebook.com");
	Select select = new Select(driver.findElementByXPath("//select[@name='birthday_month']"));
	select.selectByVisibleText("Dec");
	Select Select = new Select(driver.findElementByXPath("//*[@id=\"day\"]"));
	select.deselectByVisibleText("20");
	
	
		
	}

}
