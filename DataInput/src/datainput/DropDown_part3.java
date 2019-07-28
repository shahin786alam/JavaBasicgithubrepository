package datainput;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown_part3 {
static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://www.facebook.com");
	    
	     //WebElement day= driver.findElement(By.id("day"));
	   // WebElement month= driver.findElement(By.id("month"));
	   // WebElement year= driver.findElement(By.id("year"));
	    
	   // List<WebElement> yearlist= driver.findElements(By.xpath("//select[@id='year']//option"));
	  //  System.out.println(yearlist.size());
	    
	    /*for(int i=0; i<yearlist.size(); i++) {
	    System.out.println(yearlist.get(i).getText());
	    if(yearlist.get(i).getText().equals("1991")) {
	    	yearlist.get(i).click();
	    	break;
	}
	    }
}*/
	    String day_xpath="//select[@id='day']//option";
	    String month_xpath="//select[@id='month']//option";
	    String year_xpath="//select[@id='year']//option";
	    
	    selectDropDownValue(day_xpath, "20");
	    selectDropDownValue(month_xpath, "Dec");
	    selectDropDownValue(year_xpath, "1990"); 
	
}
	public static void selectDropDownValue(String xpathvalue, String value) {
		List<WebElement> yearlist= driver.findElements(By.xpath(xpathvalue));
		    System.out.println(yearlist.size());
		    
		    for(int i=0; i<yearlist.size(); i++) {
		    System.out.println(yearlist.get(i).getText());
		    if(yearlist.get(i).getText().equals(value)) {
		    	yearlist.get(i).click();
		    	break;
	}
    }
	}
	}
