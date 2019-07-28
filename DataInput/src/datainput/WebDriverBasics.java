package datainput;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver_win32\\chromedriver.exe");
ChromeDriver driver = new ChromeDriver();   //launch chrome
driver.get("https://www.google.com");		//enter url
driver.manage().window().maximize();         //maximize chrome
String title = driver.getTitle();              //get title
System.out.println(title);		
//validation point		
if(title.equals("Google")) {
	System.out.println("correct title");
}
else {
	System.out.println("in-correct title");
}
System.out.println(	driver.getCurrentUrl());
//System.out.println(driver.getPageSource());
driver.close();	
	}

}
