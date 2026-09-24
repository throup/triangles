package eu.throup.triangles.cucumber.hooks;

import io.cucumber.java8.Scenario;
import io.cucumber.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

public class StopServer implements En {
    public StopServer(TestHelper helper) {
        After((Scenario scenario) -> {
            try {
                System.out.println("Server stopping on " + helper.server.getURI());
                helper.server.stop();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}

