package eu.throup.triangles;

public class NegativeSideException extends IllegalArgumentException {
    public NegativeSideException() {
        super("Side lengths must be positive.");
    }
}
