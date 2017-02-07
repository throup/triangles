package eu.throup.triangles;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class NegativeSidesTest extends InvalidTriangleTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { 1,  1, -1},
                { 1, -1,  1},
                {-1,  1,  1},
                {-1, -1, -1},
        });
    }

    protected Class<NegativeSideException> expectedException() {
        return NegativeSideException.class;
    }
}
