package eu.throup.triangles.cucumber;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:out.html"}, glue = "eu.throup.triangles.cucumber", features = "src/test/resources/features")
public class RunCucumberTest {
}
