package eu.throup.triangles.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

public class HaveATriangleWhichDoesNotSatisfyTheTriangleEqualibrium implements En {
    public HaveATriangleWhichDoesNotSatisfyTheTriangleEqualibrium(TestHelper helper) {
        Given("^I have a triangle which does not satisfy the triangle equalibrium$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
