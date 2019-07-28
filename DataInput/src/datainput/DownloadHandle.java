package datainput;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DownloadHandle {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Program Files\\\\Java\\\\chromedriver_win32\\\\chromedriver.exe");
		String downloadfilepath="C:\\Users\\Shahin Alam\\eclipse-workspace\\DataInput\\src\\datainput\\filedownloaded";
		HashMap<String, Object> ChromePref = new HashMap<String, Object>();
		ChromePref.put("profile.default_content_settings.popups", 0);
		ChromePref.put("download.default_directory", downloadfilepath);
		ChromeOptions option= new  ChromeOptions();
		option.setExperimentalOption("prefs",ChromePref);
		driver = new ChromeDriver(option);

		driver.manage().window().maximize();
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );

		driver.get("https://www.yahoo.com");
		driver.findElement(By.xpath("//a[@id='uh-signin']")).click();
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys("shahin786alam@yahoo.com");
		driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys("nushratjahan");
		driver.findElement(By.xpath("//input[@id='login-passwd']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[@id='uh-mail-link']")).click();
		driver.findElement(By.xpath("//div[@class='D_F ab_C o_h H_6D6F em_N E_fq7 J_x']")).click();
		driver.findElement(By.xpath("//div[@class='D_F ab_C gl_C H_6D6F']")).click();
		driver.findElement(By.xpath("//button[@title='Download']//span[@class='D_F ab_C gl_C W_6D6F']")).click();

		File filelocation = new File("C:\\Users\\Shahin Alam\\eclipse-workspace\\DataInput\\src\\datainput\\filedownloaded");
		File [] totalfile = filelocation.listFiles();
		for (File file : totalfile) {
			String f1 =	file.getName();
			System.out.println(f1);
			if( file.getName().equals("SKMBT_C22019040114030.pdf")) {
				System.out.println("file is downloaded");
				break;

			}

		}
		driver.close();
		//*[@id="mail-app-component"]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/ul[1]/li[12]/a/div[1]/div[1]/button/span
		//*[@id="mail-app-component"]/div[2]/div/div[2]/div/div[2]/div/div[2]/div[2]/ul[1]/li[11]/a/div[1]/div[1]/button/span
	}
	

}
