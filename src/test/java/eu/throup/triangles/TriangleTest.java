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
}