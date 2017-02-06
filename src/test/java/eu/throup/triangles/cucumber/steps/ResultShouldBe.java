package eu.throup.triangles.cucumber.steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

public class ResultShouldBe implements En {
    public ResultShouldBe() {
        Then("^the result should be \"([^\"]*)\"$", (String arg1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
