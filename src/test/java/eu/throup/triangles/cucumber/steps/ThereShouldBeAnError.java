package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

import static org.junit.Assert.assertEquals;

public class ThereShouldBeAnError implements En {
    public ThereShouldBeAnError(TestHelper helper) {
        Then("^there should be an error: \"?([^\"]*)\"?$", (String errorMessage) -> {
            assertEquals(errorMessage, helper.exception.getMessage());
        });
    }
}
