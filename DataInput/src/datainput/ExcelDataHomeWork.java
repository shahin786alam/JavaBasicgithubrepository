 package datainput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.dump.DumpArchiveEntry.TYPE;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelDataHomeWork {
 
	public static void main(String[] args) throws IOException, Exception {
		
		File file= new File("C:\\Users\\Shahin Alam\\eclipse-workspace\\DataInput\\src\\datainput\\Excel.xlsx.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		System.out.println(rowcount);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.get("https://www.Google.com");
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		 
		for(int  rowNum=1; rowNum<= rowcount; rowNum++) {
			String FirstName = sheet.getRow(rowNum).getCell(0).getStringCellValue();
			System.out.println(FirstName);
			String LastName = sheet.getRow(rowNum).getCell(1).getStringCellValue();
			System.out.println( LastName);
			String Emill = sheet.getRow(rowNum).getCell(2).getStringCellValue();
			System.out.println( Emill);
			String Password = sheet.getRow(rowNum).getCell(3).getStringCellValue();
			System.out.println( Password);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='firstname']")).clear();
			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys( FirstName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='lastname']")).clear();
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys( LastName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='reg_email__']")).clear();
			driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys( Emill);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).clear();
			driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(Password);
			Thread.sleep(2000);
			TakesScreenshot ts = ((TakesScreenshot)driver);
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("C:\\Users\\Shahin Alam\\eclipse-workspace\\DataInput\\gmail.png"));
			System.out.println("TakesScreenshot taken");
		}
		//String data0=sheet.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(data0);
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		//   driver = new ChromeDriver();
		//driver.get("https://www.Google.com");
		//driver.get("https://www.facebook.com");
		//driver.manage().window().maximize();
		 
		//Thread.sleep(3000);	
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys(data0);
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys(username);
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> activelinks = new ArrayList<WebElement> ();
		
	//!=null && (!linkslist.get(i).getAttribute("href").contains("javascript")
		for (int i=0; i<linkslist.size();i++) {
			if(linkslist.get(i).getAttribute("href")!=null ) {
				 activelinks.add(linkslist.get(i));	
			}
		}
		System.out.println("size of active links and img--->"+activelinks.size());
		for(int j=0; j<activelinks.size();j++) {
			HttpURLConnection Connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href")).openConnection();
			Connection.connect();
			String response= Connection.getResponseMessage();
			Connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+"====>"+response);
	}
	}
	}
