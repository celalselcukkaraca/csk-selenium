package steps;


import base.BaseStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import page.PharmacyPage;

public class PharmacySteps extends BaseStep {
    PharmacyPage pharmacyPage = new PharmacyPage();

    @Given("the user navigates to the OnDuty Pharmacy Search page")
    public void theUserNavigatesToTheOnDutyPharmacySearchPage() {
        pharmacyPage.goToPharmacyPage();
    }

    @When("the user enters the following details: {string}, {string} and clicks the search button")
    public void theUserEntersTheFollowingDetailsCityDateAndClicksTheSearchButton(String city, String date) {
        pharmacyPage.fillInputs(city, date);
    }

    @When("the user selects district: {string}")
    public void theUserSelectsDistrictDistrict(String district) {
        pharmacyPage.selectDistrict(district);
    }

    @Then("the table should be filtered by {string}")
    public void theTableShouldBeFilteredByDistrict(String district) {
        pharmacyPage.checkTableIsFiltered(district);
    }

    @When("the user clicks show on the map button")
    public void theUserClicksShowOnTheMapButton() {
        pharmacyPage.clickShowOnTheMapButton();
    }

    @Then("the map should be displayed")
    public void theMapShouldBeDisplayed() {
        pharmacyPage.checkMapIsDisplayed();
    }
}
