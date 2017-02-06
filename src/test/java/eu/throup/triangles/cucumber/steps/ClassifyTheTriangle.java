package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.Triangle;

public class ClassifyTheTriangle implements En {
    public ClassifyTheTriangle() {
        When("^I classify the triangle$", () -> {
            Triangle triangle = new Triangle(1, 2, 3);
            triangle.classify();
        });
    }
}
