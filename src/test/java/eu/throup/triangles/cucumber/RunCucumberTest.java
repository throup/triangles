package eu.throup.triangles.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:out.html"}, glue = "eu.throup.triangles.cucumber", features = "src/test/resources/features")
public class RunCucumberTest {
}
