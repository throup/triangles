package eu.throup.triangles.domain;

public class ImpossibleTriangleException extends IllegalArgumentException {
    public ImpossibleTriangleException() {
        super("Side lengths do not make a real triangle.");
    }
}
