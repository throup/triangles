package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

public class HaveATriangleWith_number_EqualSides implements En {

    private double side1;
    private double side2;
    private double side3;

    public HaveATriangleWith_number_EqualSides(TestHelper helper) {
        Given("^I have a triangle with (\\w+) equal sides$", (String number) -> {
            switch (number) {
                case "no":
                    side1 = 1.23;
                    side2 = 2.34;
                    side3 = 3.45;
                    break;

                case "two":
                    side1 = 1.23;
                    side2 = 2.34;
                    side3 = 2.34;
                    break;

                case "three":
                    side1 = 1.23;
                    side2 = 1.23;
                    side3 = 1.23;
                    break;
            }

            helper.appDriver.enterSides(side1, side2, side3);
        });
    }
}
