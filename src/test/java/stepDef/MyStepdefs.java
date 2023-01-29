package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MyStepdefs {

    @Given("launch the URL")
    public void launchTheURL() {
    }

    @Then("validate the title of the page")
    public void validateTheTitleOfThePage() {

    }

    @Then("search for keyword in google {string}")
    public void search_for_keyword_in_google(String string) {
        // Write code here that turns the phrase above into concrete actions
    }
}
