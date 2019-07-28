package datainput;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGFramework {
	
	
@BeforeSuite
public void setUp() {
	System.out.println("setUp");
}
	
@BeforeClass
public void launchBrowser() {
System.out.println("launchBrowser");
}

@BeforeTest
public void login() {
System.out.println("login to app");
}
	

@BeforeMethod
public void enterURL() {
System.out.println("enter");
}

@Test
public void searchTest() {
System.out.println("searchTest");
}
	
	
	
	
	
	
	
	
	

}
