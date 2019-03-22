import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import config.TestSessionListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static config.TestPlatform.openYahooHomePage;

@Listeners({TestSessionListener.class,TextReport.class})
@Report
public class YahooSuite {


    @Test
    public void verifyYahooSites(){

        openYahooHomePage()
                .verifyThatSitesCouldBeLoadedInLessThan(7);

    }
}
