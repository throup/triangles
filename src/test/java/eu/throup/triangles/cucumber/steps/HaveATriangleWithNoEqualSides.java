package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.Triangle;

public class HaveATriangleWithNoEqualSides implements En {
    public HaveATriangleWithNoEqualSides() {
        Given("^I have a triangle with no equal sides$", () -> {
            new Triangle(1, 2, 3);
        });
    }
}
