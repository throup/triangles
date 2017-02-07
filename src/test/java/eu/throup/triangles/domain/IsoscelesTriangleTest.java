package eu.throup.triangles.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IsoscelesTriangleTest extends TriangleTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 1   , 2   , 2   },
                { 2   , 1   , 2   },
                { 2   , 2   , 1   },
                { 0   , 1   , 1   }, // Degenerate, but still technically isosceles.
                { 2   , 1   , 1   }, // Degenerate, but still technically isosceles.
        });
    }

    protected Triangle.Type getExpected() {
        return Triangle.Type.ISOSCELES;
    }
}
