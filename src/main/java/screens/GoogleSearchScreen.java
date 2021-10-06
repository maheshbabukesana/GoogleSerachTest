package screens;

import com.google.inject.Inject;
import contracts.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static Locators.GoogleSearchLocators.*;

public class GoogleSearchScreen implements Search {

     private WebDriver driver = new ChromeDriver();
     private  static WebElement AcceptCookies, DisplaySearch, SearchKeyword,PredictiveItems;

     public GoogleSearchScreen(){}

     @Inject
     public GoogleSearchScreen(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isPredictiveItemViewDisplayed() {
        PredictiveItems = driver.findElement(By.className(predictionItemsClassId));
        return PredictiveItems.isDisplayed();
    }

    public void viewPredictiveLinks() {
        List<WebElement> SearchKeywordLinks = driver.findElements(By.tagName(SearchKeywordLinkTagName));
        for(WebElement el : SearchKeywordLinks) {
            System.out.println(el.getText());
        }
    }

    public void navigateGooglePage() {
       driver.get(Url);
    }

    public void enterSearchField() {
        SearchKeyword.sendKeys(Keys.ENTER);
    }

    public void enterInvalidSearch() {
        SearchKeyword = driver.findElement(By.name(SearchBarByName));
        SearchKeyword.sendKeys("dfrydbvrjkvjkjvnv");
        SearchKeyword.sendKeys(Keys.ENTER);
    }

    public boolean isSearchValid() {

        return false;
    }

    public boolean isSearchDisplayed() {
        DisplaySearch = driver.findElement(By.name(SearchBarByName));
        return DisplaySearch.isDisplayed();
    }

    public void acceptCookies() {
        AcceptCookies = driver.findElement(By.id(AcceptCookiesId));
        AcceptCookies.click();
    }

    public void searchByKeyword() {
        SearchKeyword = driver.findElement(By.name(SearchBarByName));
        SearchKeyword.sendKeys("selenium");
        SearchKeyword.click();
    }
}
