package eu.throup.triangles.cucumber;

public class TestHelper {
    public ApplicationDriver appDriver;

    public TestHelper() {
        appDriver = new DomainApplicationDriver();
    }
}

