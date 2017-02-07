package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.domain.Triangle;
import eu.throup.triangles.cucumber.TestHelper;

import static java.lang.Double.*;

public class HaveATriangleWithNonFiniteSideLengths implements En {
    public HaveATriangleWithNonFiniteSideLengths(TestHelper helper) {
        Given("^I have a triangle with non-finite side lengths$", () -> {
            try {
                helper.triangle = new Triangle(NaN, POSITIVE_INFINITY, NEGATIVE_INFINITY);
            } catch (Exception e) {
                helper.exception = e;
            }
        });
    }
}
