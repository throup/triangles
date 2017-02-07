package eu.throup.triangles;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class EquilateralTriangleTest extends TriangleTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1   , 1   , 1   },
                { 0   , 0   , 0   }, // Degenerate, but still technically equilateral.
                { Double.MAX_VALUE,  Double.MAX_VALUE,  Double.MAX_VALUE},
                { Double.MIN_VALUE,  Double.MIN_VALUE,  Double.MIN_VALUE},
                { Double.MIN_NORMAL, Double.MIN_NORMAL, Double.MIN_NORMAL},
                { 0.1 + 0.2        , 0.15 + 0.15      , 1.0/10 + 2.0/10  }, // Demonstrates floating point precision.
        });
    }

    protected Triangle.Type getExpected() {
        return Triangle.Type.EQUILATERAL;
    }
}
