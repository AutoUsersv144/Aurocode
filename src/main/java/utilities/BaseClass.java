package utilities;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class BaseClass {
	
	protected WebDriver driver;
	
	@Before
	public void setupApplication()
	{
		
		Reporter.log("=====Browser Session Started=====", true);
		//WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}
	
	
	@After
	public void closeApplication()
	{

		Reporter.log("=====Browser Session End=====", true);
		driver.quit();
	}

}
