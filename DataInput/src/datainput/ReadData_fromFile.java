 package datainput;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadData_fromFile {
	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {

		Properties prop= new Properties();	
		FileInputStream fis = new FileInputStream("C:\\Users\\Shahin Alam\\eclipse-workspace\\DataInput\\src\\config.properties");	
		prop.load(fis);	
		String name= prop.getProperty("name");
		System.out.println(name);

		String age = prop.getProperty("age");
		System.out.println(age);

		String url= prop.getProperty("URL");
		System.out.println(url); 

		String browsername= prop.getProperty("browser");
		System.out.println(browsername);

		if( browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");	
			driver = new ChromeDriver();//launch Chrome	
			driver.manage().window().maximize();
		}
		else if(browsername.equals("FF")) {
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\geckodriver.exe");	
			driver = new FirefoxDriver();  //launch Chrome
			driver.manage().window().maximize();
		}
		else if(browsername.equals("IE")) {
			System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\internetexplorerdriver.exe");	
			driver = new InternetExplorerDriver();  //launch Chrome
			driver.manage().window().maximize();
		}

		driver.get(url);
		driver.findElement(By.xpath(prop.getProperty("Firstname_xpath"))).sendKeys(prop.getProperty("firstname"));
		driver.findElement(By.xpath(prop.getProperty("lastname_xpath"))).sendKeys(prop.getProperty("lastname"));
		driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("email"));

		Select select = new Select(driver.findElement(By.xpath(prop.getProperty("month_xpath"))));
		select.selectByVisibleText(prop.getProperty("month"));

		Select select1 = new Select(driver.findElement(By.xpath(prop.getProperty("day_xpath"))));
		select1.selectByVisibleText(prop.getProperty("day"));

		Select select2 = new Select(driver.findElement(By.xpath(prop.getProperty("year_xpath"))));
		select2.selectByVisibleText(prop.getProperty("year"));
		driver.findElement(By.xpath(prop.getProperty("checkbox_xpath"))).click();
		Thread.sleep(5000);
		driver.quit();
	}

}
