package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.Triangle;
import eu.throup.triangles.cucumber.TestHelper;
import org.junit.Assert;

public class ResultShouldBe implements En {
    public ResultShouldBe(TestHelper helper) {
        Then("^the result should be \"([^\"]*)\"$", (String arg1) -> {
            Assert.assertEquals(Triangle.Type.SCALENE, helper.classification);
        });
    }
}
