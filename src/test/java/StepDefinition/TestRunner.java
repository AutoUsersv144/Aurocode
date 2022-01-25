package StepDefinition;


import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
	glue = {"StepDefinition"},
	//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	plugin = "html:target/cucumber-report.html",
	dryRun=false

)
public class TestRunner {
	
	
	
}
