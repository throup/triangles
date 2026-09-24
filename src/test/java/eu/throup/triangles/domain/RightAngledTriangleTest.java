package eu.throup.triangles.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static eu.throup.triangles.domain.Triangle.Type.EQUILATERAL;
import static eu.throup.triangles.domain.Triangle.Type.ISOSCELES;
import static eu.throup.triangles.domain.Triangle.Type.SCALENE;
import static java.lang.Math.nextDown;
import static java.lang.Math.nextUp;
import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class RightAngledTriangleTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 3, 4, 5, SCALENE, true },
                { 3, 5, 4, SCALENE, true },
                { 4, 3, 5, SCALENE, true },
                { 4, 5, 3, SCALENE, true },
                { 5, 3, 4, SCALENE, true },
                { 5, 4, 3, SCALENE, true },
                { 3e300, 4e300, 5e300, SCALENE, true }, // Squaring these sides would overflow.
                { 1, 1, sqrt(2), ISOSCELES, true },
                { sqrt(2), 1, 1, ISOSCELES, true },
                { 3, 4, 6, SCALENE, false },
                { 2, 2, 2, EQUILATERAL, false },
                // Within the tolerance used to compare sides.
                { 3, 4, nextUp(5.0), SCALENE, true },
                { 3, 4, nextDown(5.0), SCALENE, true },
                // Close to, but outside, that tolerance.
                { 3, 4, nextUp(nextUp(5.0)), SCALENE, false },
                { 3, 4, nextDown(nextDown(5.0)), SCALENE, false },
                { 1, 1, 1.41421356, ISOSCELES, false },
                // Degenerate: no area, so no right angle.
                { 1, 2, 3, SCALENE, false },
                { 0, 1, 1, ISOSCELES, false },
                { 0, 0, 0, EQUILATERAL, false },
        });
    }

    @Parameterized.Parameter(0)
    public double side1;
    @Parameterized.Parameter(1)
    public double side2;
    @Parameterized.Parameter(2)
    public double side3;
    @Parameterized.Parameter(3)
    public Triangle.Type expectedType;
    @Parameterized.Parameter(4)
    public boolean expectedRightAngled;

    @Test
    public void reportsWhetherRightAngled() {
        assertEquals(expectedRightAngled, new Triangle(side1, side2, side3).isRightAngled());
    }

    @Test
    public void classificationIsUnaffected() {
        assertEquals(expectedType, new Triangle(side1, side2, side3).classify());
    }
}
