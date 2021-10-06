package stepDefinations;

import contracts.Search;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.testng.Assert;
import screens.GoogleSearchScreen;


public class steps implements En {


    Search search = new GoogleSearchScreen();

        @Given("User navigate to the Google page")
    public void user_navigate_the_google_page() {
        search.navigateGooglePage();
    }

    @Then("Accept the cookies")
    public void accept_the_cookies() {
        search.acceptCookies();
    }

    @Given("The search field should be displayed")
    public void the_search_field_should_be_displayed() {
        Assert.assertTrue(search.isSearchDisplayed(), "unable to find search field ");
    }

    @When("I type \\{search} on search")
    public void i_type_on_search() {

        search.searchByKeyword();
    }

    @Then("I see predictive categories")
    public void i_see_predictive_categories() {

        Assert.assertTrue(search.isPredictiveItemViewDisplayed(), "predictive search items not showed");
    }

    @And("I press enter")
    public void i_press_enter() {
        search.enterSearchField();
    }

    @Given("I can see all the related links to search keyword")
    public void i_see_all_links_related_to_search_keyword() {
        search.viewPredictiveLinks();

    }

    @When("I type \\{invalid search} on search")
    public void i_type_invalid_search() {
        search.enterInvalidSearch();
    }

    @Then("I see  invalid message")
    public void i_see_page_not_found_message() {
          search.isSearchValid();
    }

}
