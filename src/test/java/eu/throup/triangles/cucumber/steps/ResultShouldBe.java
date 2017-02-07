package eu.throup.triangles.cucumber.steps;

import cucumber.api.java8.En;
import eu.throup.triangles.domain.Triangle;
import eu.throup.triangles.cucumber.TestHelper;
import org.junit.Assert;

public class ResultShouldBe implements En {

    private Triangle.Type expected;

    public ResultShouldBe(TestHelper helper) {
        Then("^the result should be \"([^\"]*)\"$", (String expectedString) -> {
            switch (expectedString) {
                case "scalene":
                    expected = Triangle.Type.SCALENE;
                    break;

                case "isosceles":
                    expected = Triangle.Type.ISOSCELES;
                    break;

                case "equilateral":
                    expected = Triangle.Type.EQUILATERAL;
                    break;
            }
            Assert.assertEquals(expected, helper.triangle.classify());
        });
    }
}
