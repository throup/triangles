package eu.throup.triangles.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

public class ThereShouldBeAnError implements En {
    public ThereShouldBeAnError(TestHelper helper) {
        Then("^there should be an error$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
