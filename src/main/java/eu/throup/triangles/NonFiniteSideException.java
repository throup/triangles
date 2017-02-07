package eu.throup.triangles;

public class NonFiniteSideException extends IllegalArgumentException {
    public NonFiniteSideException() {
        super("Side lengths must be finite numbers.");
    }
}
