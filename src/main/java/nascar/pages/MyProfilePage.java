package nascar.pages;

import com.codeborne.selenide.SelenideElement;
import config.ExtendReporter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;

public class MyProfilePage {

    @FindBy(css = "#gigya-modal-plugin-container-showScreenSet_content a[data-switch-screen='gigya-register-screen']")
    private SelenideElement clickHereLink;

    @FindBy(name = "email")
    private SelenideElement emailField;

    @FindBy(name = "password")
    private SelenideElement passwordField;

    @FindBy(name = "zip")
    private SelenideElement zipField;

    @FindBy(name = "data.terms")
    private SelenideElement terms;

    @FindBy(css = "input[value='SUBMIT']")
    private SelenideElement submitButton;

    @FindBy(css = "#myProfile input[class$='logout']")
    private SelenideElement logoutButton;

    public HomePage logout() {
        ExtendReporter.logToAllure("Logout");
        logoutButton.waitUntil(visible, 10000).click();
        return page(HomePage.class);
    }


    public MyProfilePage clickHereLink() {
        ExtendReporter.logToAllure("Click here link");
        clickHereLink.waitUntil(visible, 10000).click();
        return this;
    }

    public MyProfilePage registerUserWith(String email, String password, String zip) {
        ExtendReporter.logToAllure(String.format("Register User with email %s and password %s", email, password));

        emailField.setValue(email);
        passwordField.setValue(password);
        zipField.setValue(zip);
        terms.setSelected(true);
        submitButton.click();

        return this;
    }
}
