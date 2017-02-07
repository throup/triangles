package eu.throup.triangles.cucumber;

public class TestHelper {
    public ApplicationDriver appDriver;
    public TestServer server;

    public TestHelper() {
        appDriver = new WebApplicationDriver();
    }
}

