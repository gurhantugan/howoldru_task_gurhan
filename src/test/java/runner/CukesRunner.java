package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target\\cucumber-reports.html",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                       },

        features = "src/test/resources/features",
        glue = "stepDefinitions",
         tags = "@bbb",
        dryRun = false
)

public class CukesRunner {
}
