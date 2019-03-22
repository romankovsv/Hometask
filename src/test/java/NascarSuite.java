import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import config.TestSessionListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static config.TestPlatform.openNascarHomePage;
import static utils.Generator.*;

@Listeners({TestSessionListener.class,TextReport.class})
@Report
public class NascarSuite {

    @Test
    public void verifyRegistrationFunctionality(){

        openNascarHomePage()
            .openSideMenu()
            .openMyProfilePage()
            .clickHereLink()
            .registerUserWith(getEmail(), getPassword(), getZipCode())
            .logout();
    }


}
