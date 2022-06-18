package pages;

import com.codeborne.selenide.SelenideElement;
import configuration.ReadProperties;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {


    //locators
    private SelenideElement email = $("[type='text']");

    private SelenideElement psw = $("[type='password']");
    private SelenideElement button = $(".button.is-vcentered");

    private SelenideElement incorrectEmail=$(".notification.is-danger.is-small");

    private SelenideElement incorrectPSW=$(".notification.is-danger");




//corpuscular methods

    public SelenideElement getEmail() {
        return email;
    }

    public SelenideElement getPsw() {
        return psw;
    }

    public SelenideElement getButton() {
        return button;
    }






    //complex methods
    public FeedPage successLogin(String email, String psw) {
        login(email, psw);
        return new FeedPage();
    }

    public SelenideElement getIncorrectEmail() {
        return incorrectEmail;
    }

    public SelenideElement getIncorrectPSW() {
        return incorrectPSW;
    }

    public LoginPage inCorrectLogin(String incorrectEmail, String psw){
        login(incorrectEmail,psw);
        return this;
    }





    public void login(String email, String psw){
        open(ReadProperties.getUrl());
        getEmail().setValue(email);
        getPsw().setValue(psw);
        button.click();
    }

}
