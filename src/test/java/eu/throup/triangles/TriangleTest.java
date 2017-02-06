package eu.throup.triangles;

import org.junit.Assert;
import org.junit.Test;

public class TriangleTest {
    @Test
    public void instantiate() {
        new Triangle(1, 1, 1);
    }

    @Test
    public void classify_returnsSomeType() {
        Triangle triangle = new Triangle(1, 1, 1);
        Triangle.Type type = triangle.classify();
    }

    @Test
    public void givenScaleneTriangle_classify_returnsScaleneType() {
        Triangle triangle = new Triangle(1, 2, 3);
        Assert.assertEquals(Triangle.Type.SCALENE, triangle.classify());
    }

    @Test
    public void givenScaleneTriangleWithDoubleValues_classify_returnsScaleneType() {
        Triangle triangle = new Triangle(1.23, 2.34, 3.45);
        Assert.assertEquals(Triangle.Type.SCALENE, triangle.classify());
    }

    @Test
    public void givenIsoscelesTriangle_classify_returnsIsoscelesType() {
        Triangle triangle = new Triangle(1, 2, 2);
        Assert.assertEquals(Triangle.Type.ISOSCELES, triangle.classify());
    }

    @Test
    public void givenEquilateralTriangle_classify_returnsEquilateralType() {
        Triangle triangle = new Triangle(1, 1, 1);
        Assert.assertEquals(Triangle.Type.EQUILATERAL, triangle.classify());
    }
}