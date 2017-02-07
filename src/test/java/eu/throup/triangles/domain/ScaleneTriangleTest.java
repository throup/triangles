package eu.throup.triangles.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScaleneTriangleTest extends TriangleTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 3   , 4   , 5   },
                { 1   , 2   , 3   }, // Degenerate, but still technically scalene.
                { 1.23, 2.34, 3.45},
        });
    }

    protected Triangle.Type getExpected() {
        return Triangle.Type.SCALENE;
    }
}

