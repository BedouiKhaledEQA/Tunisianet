package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",glue = "steps",
        plugin = {"pretty","html:target/report.html","json:target/report.json"},
        stepNotifications = true,tags = "")

public class TestRunner {
}
