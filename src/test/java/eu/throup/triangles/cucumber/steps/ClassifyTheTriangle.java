package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

public class ClassifyTheTriangle implements En {
    public ClassifyTheTriangle(TestHelper helper) {
        When("^I classify the triangle$", () -> {
            helper.classification = helper.triangle.classify();
        });
    }
}
