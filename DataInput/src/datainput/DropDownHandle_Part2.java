package datainput;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle_Part2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
    driver.get("https://www.facebook.com");
    
    WebElement day= driver.findElement(By.id("day"));
    WebElement month= driver.findElement(By.id("month"));
    WebElement year= driver.findElement(By.id("year"));
    
    Select select = new Select(day);
    //select.selectByIndex(15);    //should not use selectByIndex
	select.selectByVisibleText("15");
	
	select.isMultiple();
	System.out.println(select.isMultiple());
	List<WebElement> listday= select.getOptions();
	System.out.println(listday.size());
	int Totaldays= listday.size()-1;
	System.out.println("Total days are===>"+Totaldays);
	
	for(int i=0; i<listday.size();i++) {
	String dayval = listday.get(i).getText();
	System.out.println(dayval);
	if(dayval.equals("15")) {
		listday.get(i).click();
		break;
	}
	}
	}
}
