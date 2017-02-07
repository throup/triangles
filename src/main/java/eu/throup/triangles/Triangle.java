package eu.throup.triangles;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.ulp;

public class Triangle {
    private final double side1;
    private final double side2;
    private final double side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
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
