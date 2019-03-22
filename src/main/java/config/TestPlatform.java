package config;


import static com.codeborne.selenide.Selenide.open;
import static config.Settings.NASCAR_URL;
import static config.Settings.YAHOO_URL;

public class TestPlatform {

    public static nascar.pages.HomePage openNascarHomePage() {
        ExtendReporter.logToAllure("Open Nascar Home Page");
        ExtendReporter.logToAllure(NASCAR_URL);

        return open(NASCAR_URL, nascar.pages.HomePage.class);
    }

    public static yahoo.pages.HomePage openYahooHomePage() {
        ExtendReporter.logToAllure("Open Yahoo Home Page");

        return open(YAHOO_URL, yahoo.pages.HomePage.class);
    }
}
