package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;
import eu.throup.triangles.domain.Triangle;

public class ResultShouldBe implements En {

    private Triangle.Type expected;

    public ResultShouldBe(TestHelper helper) {
        Then("^the result should be \"([^\"]*)\"$", (String expectedString) -> {
            helper.appDriver.confirmResult(expectedString);
        });
    }
}
