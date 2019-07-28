package datainput;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DrowBorderTest {

	public static void main(String[] args) throws InterruptedException, IOException {
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Thread.sleep(5000);	
		WebElement gmail=driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a"));
		flash( gmail,driver );
		drawBorder (gmail,driver);
		TakesScreenshot ts= (TakesScreenshot)driver;
		File sr=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sr, new File("C:\\Users\\Shahin Alam\\eclipse-workspace\\DataInput\\src\\gmail.png"));
		 
	}
		
		 public static void flash(WebElement element, WebDriver driver) {
		        JavascriptExecutor js = ((JavascriptExecutor) driver);
		        String bgcolor  = element.getCssValue("backgroundColor");
		        for (int i = 0; i <100; i++) {
		            changeColor("rgb(0,600,0)", element, js);
		            changeColor(bgcolor, element, js);
		        }
		    }
		    public static void changeColor(String color, WebElement element,  JavascriptExecutor js) {
		        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

		        try {
		            Thread.sleep(20);
		        }  catch (InterruptedException e) {
		        }
		    }
		        public static void drawBorder(WebElement element, WebDriver driver){
		        	JavascriptExecutor js = ((JavascriptExecutor) driver);
		        	js.executeScript("arguments[0].style.border='3px solid red'", element);
		        }
		        
 	
		      

		    
}



