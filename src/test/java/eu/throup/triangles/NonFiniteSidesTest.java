package eu.throup.triangles;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static java.lang.Double.NEGATIVE_INFINITY;
import static java.lang.Double.NaN;
import static java.lang.Double.POSITIVE_INFINITY;

@RunWith(Parameterized.class)
public class NonFiniteSidesTest extends InvalidTriangleTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {                1,                 1,               NaN},
                {                1,               NaN,                 1},
                {              NaN,                 1,                 1},
                {              NaN,               NaN,               NaN},
                {POSITIVE_INFINITY, POSITIVE_INFINITY, POSITIVE_INFINITY},
                {NEGATIVE_INFINITY, NEGATIVE_INFINITY, NEGATIVE_INFINITY},
                {              NaN, POSITIVE_INFINITY, NEGATIVE_INFINITY},
        });
    }

    protected Class<NonFiniteSideException> expectedException() {
        return NonFiniteSideException.class;
    }
}
