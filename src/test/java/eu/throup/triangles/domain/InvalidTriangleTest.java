package eu.throup.triangles.domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public abstract class InvalidTriangleTest {
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
        });
    }

    @Test
    public void test() {
        thrown.expect(expectedException());
        new Triangle(side1, side2, side3);
    }

    abstract protected Class<? extends IllegalArgumentException> expectedException();
}