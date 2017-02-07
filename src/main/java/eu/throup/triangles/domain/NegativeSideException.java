package eu.throup.triangles.domain;

public class NegativeSideException extends IllegalArgumentException {
    public NegativeSideException() {
        super("Side lengths must be positive.");
    }
}
