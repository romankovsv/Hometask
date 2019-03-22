package yahoo.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import config.ExtendReporter;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HomePage {

    @FindBy(css = "#mega-bottombar li a")
    private ElementsCollection sites;

    public HomePage verifyThatSitesCouldBeLoadedInLessThan(int seconds) {
        ExtendReporter.logToAllure(String.format("Verify that sites could be loaded in less than %d seconds", seconds));

        List<String> links = sites.stream()
                .map(e -> e.getAttribute("href"))
                .collect(Collectors.toList());

        WebDriverRunner.getWebDriver().manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
        for (String link : links) {
           try {
                ExtendReporter.logToAllure("Open " + link);
                WebDriverRunner.getWebDriver().get(link);
            } catch (TimeoutException e) {
                ExtendReporter.logToAllure(String.format("Loading site %s took more than %d seconds", link, seconds));
                Assert.fail();
            }
        }

        return this;
    }
}
