package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.Triangle;
import eu.throup.triangles.cucumber.TestHelper;

public class HaveATriangleWithTwoEqualSides implements En {
    public HaveATriangleWithTwoEqualSides(TestHelper helper) {
        Given("^I have a triangle with two equal sides$", () -> {
            helper.triangle = new Triangle(1, 2, 2);
        });
    }
}
