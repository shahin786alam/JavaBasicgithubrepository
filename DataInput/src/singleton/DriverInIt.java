package singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverInIt {
	private static DriverInIt instanceDriver=null;
	private WebDriver driver;
	
	private DriverInIt() {
		
	}
	
	public WebDriver openBrowser() {
    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
	driver= new ChromeDriver();
	return driver;
	}
	
	public static DriverInIt getInstance() {
		if(instanceDriver == null) 
			instanceDriver = new DriverInIt();
			return instanceDriver;
		}

}
