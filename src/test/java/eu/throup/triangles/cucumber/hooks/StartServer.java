package eu.throup.triangles.cucumber.hooks;

import cucumber.api.Scenario;
import cucumber.api.java8.En;
import eu.throup.triangles.cucumber.TestHelper;
import eu.throup.triangles.cucumber.TestServer;

public class StartServer implements En {
    public StartServer(TestHelper helper) {
        Before((Scenario scenario) -> {
            try {
                helper.server = new TestServer(9988);
                helper.server.start();
                System.out.println("Server started on " + helper.server.getURI());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}

