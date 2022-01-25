package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.BaseClass;
import io.cucumber.datatable.*;
import static org.junit.Assert.*;
import java.lang.Thread;


public class Employee extends BaseClass{

	//Driver initialization 
	WebDriver driver;

	@Given("I access employees.html")
	public void i_access_employees_html() {
		
		int linksCount  = 0;

		//Driver system property setup 
		System.setProperty("webdriver.chrome.driver", "D:/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Access application
		driver.get("E:/ui-test-assessment-master/ui-test-assessment-master/employees.html");
		
		List<WebElement> linksize  =driver.findElements(By.xpath("//span[@class='jqx-tree-grid-collapse-button jqx-grid-group-collapse jqx-icon-arrow-right']"));
		
		linksCount=linksize.size();
		for(int i=0;i<linksCount;i++)
		{
			driver.findElement(By.xpath("//span[@class='jqx-tree-grid-collapse-button jqx-grid-group-collapse jqx-icon-arrow-right']")).click();
		}

	}


	@When("I Selected Employee {string}")
	public void i_selected_employee(String string) {
	
		// Code to select employee with Employee Fist name 
		String strEmpName= driver.findElement(By.xpath("//span[text()='"+ string +"']")).getText();

		if(strEmpName.equals(string)){

			driver.findElement(By.xpath("//span[text()='"+ string +"']//preceding-sibling::span[1]")).click();

			driver.findElement(By.xpath("//button[text()=\"View selected data\"]")).click();

			System.out.println(string+" Employee selected");

		} else {
			assertEquals(strEmpName,string );
			System.out.println("Employee selection Fail ");
		} 

	}
	
	@When("I Selected Employee {string} and {string}")
	public void i_selected_employee_and(String stringempFirstName, String stringempLastName) {
		
		
		// Code to select employee with Employee first and last name 
		String strEmpName= driver.findElement(By.xpath("//span[text()='"+ stringempFirstName +"']")).getText();
		String strEmplstName= driver.findElement(By.xpath("//span[text()='"+ stringempFirstName +"']/following::td")).getText();
			if(strEmpName.equals(stringempFirstName) && strEmplstName.equals(stringempLastName) ){

				driver.findElement(By.xpath("//span[text()='"+ stringempFirstName +"']//preceding-sibling::span[1]")).click();

				driver.findElement(By.xpath("//button[text()=\"View selected data\"]")).click();

				System.out.println(stringempFirstName+ " " +stringempLastName + " Employee selected");

			} else {
				assertEquals(stringempFirstName,strEmpName );
				assertEquals(stringempLastName,strEmplstName );
				System.out.println("Employee selection Fail");
			} 

	}


	@Then("Validate {string} employee city of origin is {string}")
	public void validate_employee_city_of_origin_is(String empname, String empcity) throws InterruptedException {
		
		Thread.sleep(20000);
		
		// Code to validate employee city of origin
		String strcityoforigin=driver.findElement(By.xpath("//div[@id='listitem0listBoxSelected']//child::span")).getText();

		boolean statuscityoforigin = strcityoforigin.equals(empname +" is from "+empcity);

		if(statuscityoforigin){
			System.out.println(empname +" Employee city of origin is "+ empcity + " and city validation Pass");

		} else {
			assertTrue(statuscityoforigin);
			System.out.println(strcityoforigin + " and Employee city of origin should be " +empcity+ ",validation Fail ");
		} 

			driver.quit();
	}

	@When("I Selected Employee")
	public void i_selected_employee(DataTable empdeatils) throws Throwable {

		 
		  List<Map<String, String>> rows = empdeatils.asMaps(String.class, String.class);
		  for (Map<String, String> columns : rows) {
			  
			  String strEmpName= driver.findElement(By.xpath("//span[text()='"+ columns.get("empFirstName") +"']")).getText();
			  String strEmplstName= driver.findElement(By.xpath("//span[text()='"+ columns.get("empFirstName") +"']/following::td")).getText();
			  
				if(strEmpName.equals(columns.get("empFirstName")) && strEmplstName.equals(columns.get("empLastName")) ){

					driver.findElement(By.xpath("//span[text()='"+ columns.get("empFirstName") +"']//preceding-sibling::span[1]")).click();

					driver.findElement(By.xpath("//button[text()=\"View selected data\"]")).click();

					System.out.println(columns.get("empFirstName")+ " " + columns.get("empLastName") + " Employee selected");

				} else {
					System.out.println("Employee selection Fail");
					assertEquals(columns.get("empFirstName"),strEmpName );
					assertEquals(columns.get("empLastName"),strEmplstName );
				
				} 
		  }
		    
		   
		
	
		
		
	}
	
	@Then("Validate employee city of origin")
	public void validate_employee_city_of_origin(DataTable empdeatils) throws InterruptedException {

		Thread.sleep(10000);
		String strcity=null;
		
		  List<Map<String, String>> rows = empdeatils.asMaps(String.class, String.class);
	
			  for (Map<String, String> columns : rows) {
				  
				  boolean statuscityoforigin=false;
				  
				  for (int i=0;i<rows.size();i++) {
					  
					  String  strcityoforigin=driver.findElement(By.xpath("//div[@id='listitem"+ i +"listBoxSelected']//child::span")).getText();
						
				  
					   statuscityoforigin = strcityoforigin.equals(columns.get("empFirstName") +" is from "+ columns.get("cityName"));
					   if(statuscityoforigin) {
						   break;
					   }
					    
			
				  }
				  
				  if(statuscityoforigin)	
					  
				  {
					  System.out.println(columns.get("empFirstName") +" Employee city of origin is "+ columns.get("cityName") + " and city validation PASS");
				  } else {
					  
					  System.out.println(columns.get("empFirstName") +" Employee city of origin is "+ columns.get("cityName") + " and city validation Fail");
					  driver.quit();  
					  assertTrue(statuscityoforigin);
				  }
					  
		  }  
			  
		  driver.quit();  

	}

}
