package sauce_demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "sauce_demo",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestRunner {
}
