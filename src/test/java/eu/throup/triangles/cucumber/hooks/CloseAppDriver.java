package eu.throup.triangles.cucumber.hooks;

import io.cucumber.java8.Scenario;
import io.cucumber.java8.En;
import eu.throup.triangles.cucumber.TestHelper;

public class CloseAppDriver implements En {
    public CloseAppDriver(TestHelper helper) {
        After((Scenario scenario) -> {
            try {
                if (helper.appDriver != null) {
                    helper.appDriver.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
