package steps;


import base.BaseStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.BeyogluPage;
import page.PharmacyPage;

public class BeyogluSteps extends BaseStep {

    BeyogluPage beyogluPage = new BeyogluPage();

    @Given("the user navigates to the Beyoglu Municipality Land Market Values Search page")
    public void userNavigatesToBeyogluPage() {
        beyogluPage.goToBeyogluPage();
    }


    @When("the user enters the following details: {string}, {string}, {string} and clicks the search button")
    public void theUserEntersTheFollowingDetailsNeighborhoodStreetYearAndClicksTheSearchButton(String neighborhood, String street, String year) {
        beyogluPage.fillInputs(neighborhood, street, year);
    }

    @Then("the user should see the results {string}, {string}, {string}")
    public void theUserShouldSeeTheResults(String neighborhood, String street, String year) {
        beyogluPage.checkResultTable(neighborhood, street, year);
    }


}
