package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FeedPage {

    //locators
    private SelenideElement navigationMenu = $("#navMenu");
    private SelenideElement newestButton = $(By.xpath("//div[@class='mb-5']/div/div/ul/li/a[text()='Newest']"));
    private SelenideElement recentRepliesButton = $(By.xpath("//div[@class='mb-5']/div/div/ul/li/a[text()='Recent replies ']"));
    private SelenideElement findOutMoreButton = $(By.linkText(" Find out more "));
    private SelenideElement logoutButton = $(".button.is-outlined.is-ligdht");



    //corpuscular methods

    public SelenideElement getNavigationMenu() {
        return navigationMenu;
    }

    public SelenideElement getNewestButton() {
        return newestButton;
    }

    public SelenideElement getRecentRepliesButton() {
        return recentRepliesButton;
    }

    public SelenideElement getFindOutMoreButton() {
        return findOutMoreButton;
    }


    //complex methods
    public LoginPage logout(){
        logoutButton.click();
        return new LoginPage();
    }

}
