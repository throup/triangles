package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.Triangle;
import eu.throup.triangles.cucumber.TestHelper;

public class HaveATriangleWith_number_EqualSides implements En {
    public HaveATriangleWith_number_EqualSides(TestHelper helper) {
        Given("^I have a triangle with (\\w+) equal sides$", (String number) -> {
            switch (number) {
                case "no":
                    helper.triangle = new Triangle(1, 2, 3);
                    break;

                case "two":
                    helper.triangle = new Triangle(1, 2, 2);
                    break;

                case "three":
                    helper.triangle = new Triangle(1, 1, 1);
                    break;
            }
        });
    }
}
