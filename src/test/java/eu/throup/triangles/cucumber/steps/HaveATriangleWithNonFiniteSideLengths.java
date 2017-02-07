package eu.throup.triangles.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

public class HaveATriangleWithNonFiniteSideLengths implements En {
    public HaveATriangleWithNonFiniteSideLengths(TestHelper helper) {
        Given("^I have a triangle with non-finite side lengths$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
