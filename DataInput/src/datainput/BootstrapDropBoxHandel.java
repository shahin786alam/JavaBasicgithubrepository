  package datainput;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropBoxHandel {

	public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();    //launch chrome
		driver.manage().window().maximize();      //maximize window
		driver.manage().deleteAllCookies();       //delete all the cookies
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		driver.get("http://www.jquery-az.com/boots/demo.php?ex=63.0_2");      //enter url
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		List<WebElement> list= driver.findElements(By.xpath("//ul[contains(@class,'multiselect-container dropdown-menu')]//li//a//label"));
        System.out.println(list.size());
        
        //click all the option or check box
        for(int i=0; i<list.size(); i++) {
    	System.out.println(list.get(i).getText());
    	list.get(i).click();
    		
 }
       /* if(list.equals("HTML")) {
        	
        
        		
    		
    		System.out.println("correct messg");
    	}
    	else {
    		System.out.println("in-correct  messg");	
    	}*/
 }
     //click on Java only   
        
        /*for(int i=0; i<list.size(); i++) {
        	System.out.println(list.get(i).getText());
        	if(list.get(i).getText().contains("Java")) {
        		list.get(i).click();
        		break;
     }
     }*/
   }
	
