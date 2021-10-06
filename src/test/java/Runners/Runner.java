package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/",
        glue = {"stepDefinations"},
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class Runner extends AbstractTestNGCucumberTests {

}
