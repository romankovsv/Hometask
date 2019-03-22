package nascar.pages;

import com.codeborne.selenide.SelenideElement;
import config.ExtendReporter;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    @FindBy(id = "mobile-hamburger")
    private SelenideElement sideMenu;

    @FindBy(css = "a[href$='myprofile']")
    private SelenideElement myProfileLink;

    public HomePage openSideMenu(){
        ExtendReporter.logToAllure("Open Side menu");
        sideMenu.click();

        return this;
    }

    public MyProfilePage openMyProfilePage(){
        ExtendReporter.logToAllure("Open my profile page");
        myProfileLink.click();

        return page(MyProfilePage.class);
    }
}
