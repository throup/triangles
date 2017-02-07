package eu.throup.triangles;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ImpossibleTriangleTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test() {
        thrown.expect(Exception.class);

        new Triangle(1, 1, 3);
    }
}
