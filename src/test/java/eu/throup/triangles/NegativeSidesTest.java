package eu.throup.triangles;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NegativeSidesTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Parameterized.Parameter(0)
    public double side1;
    @Parameterized.Parameter(1)
    public double side2;
    @Parameterized.Parameter(2)
    public double side3;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { 1,  1, -1},
                { 1, -1,  1},
                {-1,  1,  1},
                {-1, -1, -1},
        });
    }

    @Test
    public void test() {
        thrown.expect(NegativeSideException.class);
        new Triangle(side1, side2, side3);
    }
}
