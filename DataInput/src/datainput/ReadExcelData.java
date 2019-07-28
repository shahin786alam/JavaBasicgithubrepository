package datainput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcelData {

	public static void main(String[] args) throws InterruptedException, IOException {

		File file= new File("C:\\Users\\Shahin Alam\\eclipse-workspace\\RedExleFile\\src\\redexlefile\\Excel.xlsx.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		//int totalrow = sheet.getLastRowNum();
		//System.out.println("total rows"+totalrow);
		
		String data0=sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println(data0);
		
		//String data1=sheet.getRow(1).getCell(0).getStringCellValue();
		//System.out.println(data1);
		
		//String data2=sheet.getRow(0).getCell(2).getStringCellValue();
		//System.out.println(data2);
		//Xls_Reader Reader = new Xls_Reader("C:\\Users\\Shahin Alam\\eclipse-workspace\\RedExleFile\\src\\redexlefile\\Excel.xlsx.xlsx");
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(data0);
		
	}

}
