package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.Triangle;
import eu.throup.triangles.cucumber.TestHelper;

public class HaveATriangleWithNegativeSideLengths implements En {
    public HaveATriangleWithNegativeSideLengths(TestHelper helper) {
        Given("^I have a triangle with negative side lengths$", () -> {
            try {
                helper.triangle = new Triangle(-1, -1, -1);
            } catch (Exception e) {
                helper.exception = e;
            }
        });
    }
}
