	package datainput;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver ();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/html/html_tables.asp");	
			
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/ad[1]
		//*[@id="customers"]/tbody/tr[4]/td[1]
		//*[@id="customers"]/tbody/tr[5]/td[1]
		
		//*[@id="customers"]/tbody/tr[2]/td[2]
		//*[@id="customers"]/tbody/tr[3]/td[2]
		
		String beforeXpath_company = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_company = "]/td[1]";
		
		String beforeXpath_contact = "//*[@id=\"customers\"]/tbody/tr[";
		String afterXpath_contact = "]/td[2]";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		 System.out.println("Total number of rows => "+(rows.size()-1));
		 int rowcount = rows.size();
		 
		// Xls_Reader reader= new  Xls_Reader("C:\\Users\\Shahin Alam\\eclipse-workspace\\DataInput\\src\\datainput\\Excel.xlsx.xlsx");
		
		 
		for(int i=2; i<=rowcount; i++) {
			String actualXpath_company= beforeXpath_company+i+afterXpath_company;
		   String companyname= driver.findElement(By.xpath(actualXpath_company)).getText();
		   System.out.println(companyname);
		  
		   String actualXpath_contact= beforeXpath_contact+i+afterXpath_contact;
		   String contact= driver.findElement(By.xpath(actualXpath_company)).getText();
		   System.out.println(contact);


	}

}
}