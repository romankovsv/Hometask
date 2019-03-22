import com.codeborne.selenide.testng.TextReport;
import com.codeborne.selenide.testng.annotations.Report;
import config.TestSessionListener;
import nascar.models.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static config.TestPlatform.openNascarHomePage;
import static utils.Generator.*;

@Listeners({TestSessionListener.class,TextReport.class})
@Report
public class NascarSuite {

    @Test
    public void verifyRegistrationFunctionality(){

        User user = new User(getEmail(), getPassword(), getZipCode());

        openNascarHomePage()
            .openSideMenu()
            .openMyProfilePage()
            .clickHereLink()
            .registerUserWith(user.getEmail(), user.getPassword(), user.getZip())
            .logout();
    }


}
