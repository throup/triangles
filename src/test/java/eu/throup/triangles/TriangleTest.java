package eu.throup.triangles;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
abstract public class TriangleTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
        });
    }

    @Parameterized.Parameter(0)
    public double side1;
    @Parameterized.Parameter(1)
    public double side2;
    @Parameterized.Parameter(2)
    public double side3;

    @Test
    public void test() {
        Triangle triangle = new Triangle(side1, side2, side3);
        Assert.assertEquals(getExpected(), triangle.classify());
    }

    protected abstract Triangle.Type getExpected();
}
