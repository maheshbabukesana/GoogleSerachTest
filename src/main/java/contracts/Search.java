package contracts;

public interface Search {
    void acceptCookies();
    boolean isSearchDisplayed();
    void searchByKeyword();
    boolean isPredictiveItemViewDisplayed();
    void viewPredictiveLinks();
    void navigateGooglePage();
    void enterSearchField();
    void enterInvalidSearch();
    boolean isSearchValid();
}
