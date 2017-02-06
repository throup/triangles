package eu.throup.triangles;

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
        });
    }

    protected Triangle.Type getExpected() {
        return Triangle.Type.ISOSCELES;
    }
}
