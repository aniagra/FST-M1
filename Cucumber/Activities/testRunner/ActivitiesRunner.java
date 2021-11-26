package testRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinitions"},
    tags = "@SmokeTest",
    //plugin = {"html:reports/HTML_Reports/report.html"},
    plugin = {"json: reports/json-report.json"},
    monochrome = true
    //publish = true
)

public class ActivitiesRunner {
	
	

}
