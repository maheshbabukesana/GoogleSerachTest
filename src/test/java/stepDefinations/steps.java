package stepDefinations;

import com.google.inject.Inject;
import contracts.Search;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



import static Locators.GoogleSearchLocators.SearchBarByName;


public class steps implements En {
    @Inject
    public Search search;



    WebDriver driver = new ChromeDriver();
    private  static WebElement AcceptCookies, DisplaySearch, SearchKeyword,PredictiveItems;

    @Given("User navigate to the Google page")
    public void user_navigate_the_google_page() {
        search.navigateGooglePage();
    }

    @Then("Accept the cookies")
    public void accept_the_cookies()
    {
        search.acceptCookies();
    }

    @Given("The search field should be displayed")
    public void the_search_field_should_be_displayed() {
        Assert.assertTrue(search.isSearchDisplayed(),"unable to find search field ");
    }

    @When("I type \\{search} on search")
    public void i_type_on_search() {
        search.searchByKeyword();
    }
    @Then("I see predictive categories")
    public void i_see_predictive_categories() {

        Assert.assertTrue(search.isPredictiveItemViewDisplayed(),"predictive search items not showed");
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
        SearchKeyword = driver.findElement(By.name(SearchBarByName));
        SearchKeyword.sendKeys("dfrydbvrjkvjkjvnv");
        SearchKeyword.click();
        SearchKeyword.sendKeys(Keys.ENTER);
    }

    @Then("I see  page not found message")
    public void i_see_page_not_found_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
