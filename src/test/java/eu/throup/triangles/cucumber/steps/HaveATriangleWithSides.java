package eu.throup.triangles.cucumber.steps;

import io.cucumber.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

public class HaveATriangleWithSides implements En {
    public HaveATriangleWithSides(TestHelper helper) {
        Given("^I have a triangle with sides ([^, ]+), ([^, ]+) and ([^, ]+)$", (String side1, String side2, String side3) -> {
            helper.appDriver.enterSides(Double.parseDouble(side1), Double.parseDouble(side2), Double.parseDouble(side3));
        });
    }
}
