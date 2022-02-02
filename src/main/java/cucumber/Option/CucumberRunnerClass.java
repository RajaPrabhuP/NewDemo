package cucumber.Option;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features="src/main/java/features",
		glue = {"stepdefinitions"}
		//monochrome=false,dryRun=false,
		//plugin = "json:target/jsonReports/cucumber-reports.json"
	//	tags = "@Regression"
		
		)
public class CucumberRunnerClass extends AbstractTestNGCucumberTests { 

}
