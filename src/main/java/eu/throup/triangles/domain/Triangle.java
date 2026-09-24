package eu.throup.triangles.domain;

import java.util.Arrays;

import static java.lang.Double.isFinite;
import static java.lang.Math.*;

public class Triangle {
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        validateSides();
    }

    private void validateSides() throws IllegalArgumentException {
        if (!allSidesAreFinite()) {
            throw new NonFiniteSideException();
        }

        if (!allSidesAreNonNegative()) {
            throw new NegativeSideException();
        }

        if (!satisfiesTriangleInequality()) {
            throw new ImpossibleTriangleException();
        }
    }

    private boolean allSidesAreFinite() {
        return isFinite(side1)
            && isFinite(side2)
            && isFinite(side3);
    }

    private boolean allSidesAreNonNegative() {
        return side1 >= 0
            && side2 >= 0
            && side3 >= 0;
    }

    private boolean satisfiesTriangleInequality() {
        return (side1 + side2 >= side3)
            && (side1 + side3 >= side2)
            && (side2 + side3 >= side1);
    }

    public Type classify() {
        if (isScalene()) {
            return Type.SCALENE;
        } else if (isEquilateral()) {
            return Type.EQUILATERAL;
        } else {
            return Type.ISOSCELES;
        }
    }

    /**
     * Whether one angle of the triangle is a right angle. The constructor has already
     * rejected any other input, so this only sees finite, non-negative sides that
     * satisfy the triangle inequality.
     * <p>
     * A triangle with a side of zero length is never right-angled. The two corners at
     * the ends of that side coincide, and the side lengths do not fix the angles there.
     * Joining (0, 0) to (1, 0) and to a point at distance e in direction t gives a
     * triangle with an angle t whose sides tend to 0, 1 and 1 as e shrinks, whatever t
     * is. The isosceles triangles e, 1, 1, whose base angles tend to 90°, are one route
     * to 0, 1, 1 among many.
     */
    public boolean isRightAngled() {
        double[] sides = {side1, side2, side3};
        Arrays.sort(sides);
        double shortest = sides[0];
        double middle = sides[1];
        double longest = sides[2];
        if (shortest == 0) {
            return false;
        }
        // hypot avoids the overflow and rounding of squaring the sides directly.
        return sidesEqual(hypot(shortest, middle), longest);
    }

    private boolean isEquilateral() {
        return sidesEqual(side1, side2) && sidesEqual(side1, side3) && sidesEqual(side2, side3);
    }

    private boolean isScalene() {
        return !sidesEqual(side1, side2) && !sidesEqual(side1, side3) && !sidesEqual(side2, side3);
    }

    private static boolean sidesEqual(double firstSide, double secondSide) {
        double epsilon = max(ulp(firstSide), ulp(secondSide)) * 2;
        return abs(firstSide - secondSide) < epsilon;
    }

    public enum Type {ISOSCELES, EQUILATERAL, SCALENE}
}
