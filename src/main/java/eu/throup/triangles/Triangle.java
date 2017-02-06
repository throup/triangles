package eu.throup.triangles;

public class Triangle {
    private final int side1;
    private final int side2;
    private final int side3;

    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Type classify() {
        if (side2 != side3) {
            return Type.SCALENE;
        } else {
            return Type.ISOSCELES;
        }
    }

    public enum Type {ISOSCELES, SCALENE}
}
