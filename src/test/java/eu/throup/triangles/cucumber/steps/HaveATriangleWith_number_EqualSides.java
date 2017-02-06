package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.Triangle;
import eu.throup.triangles.cucumber.TestHelper;

public class HaveATriangleWithNoEqualSides implements En {
    public HaveATriangleWithNoEqualSides(TestHelper helper) {
        Given("^I have a triangle with no equal sides$", () -> {
            helper.triangle = new Triangle(1, 2, 3);
        });
    }
}
