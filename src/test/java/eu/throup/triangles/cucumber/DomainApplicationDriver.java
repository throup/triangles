package eu.throup.triangles.cucumber;

import eu.throup.triangles.domain.Triangle;

import static org.junit.Assert.assertEquals;

public class DomainApplicationDriver implements ApplicationDriver {
    private Triangle triangle;
    private Exception exception;

    @Override
    public void enterSides(double side1, double side2, double side3) {
        try {
            triangle = new Triangle(side1, side2, side3);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Override
    public void classify() {
        // No action required.
    }

    @Override
    public void confirmResult(String expectedString) {
        Triangle.Type expected = null;

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

        assertEquals(expected, triangle.classify());
    }

    @Override
    public void close() {
        // No action required.
    }

    @Override
    public void confirmError(String errorMessage) {
        assertEquals(exception.getMessage(), errorMessage);
    }
}
