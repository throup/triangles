package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

import static java.lang.Double.*;

public class HaveATriangleWithNonFiniteSideLengths implements En {
    public HaveATriangleWithNonFiniteSideLengths(TestHelper helper) {
        Given("^I have a triangle with non-finite side lengths$", () -> {
            helper.appDriver.enterSides(NaN, POSITIVE_INFINITY, NEGATIVE_INFINITY);
        });
    }
}
