package Vytrack.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "resources\\Vytrack\\features",
		glue= "Vytrack\\step_definition",
		dryRun = false,
		tags = "@test3"
		)


public class CukesRunner {

}
