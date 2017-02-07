package eu.throup.triangles.cucumber;

public interface ApplicationDriver {
    void enterSides(double side1, double side2, double side3);

    void classify();

    void confirmResult(String expectedString);

    void close();

    void confirmError(String errorMessage);
}
