package eu.throup.triangles;

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
        if (side2 != side3) {
            return Type.SCALENE;
        } else if (side1 != side2) {
            return Type.ISOSCELES;
        } else {
            return Type.EQUILATERAL;
        }
    }

    public enum Type {ISOSCELES, EQUILATERAL, SCALENE}
}
