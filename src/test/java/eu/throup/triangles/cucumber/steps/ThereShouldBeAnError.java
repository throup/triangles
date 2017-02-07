package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;
import org.junit.Assert;

public class ThereShouldBeAnError implements En {
    public ThereShouldBeAnError(TestHelper helper) {
        Then("^there should be an error$", () -> {
            Assert.assertNotNull(helper.exception);
        });
    }
}
