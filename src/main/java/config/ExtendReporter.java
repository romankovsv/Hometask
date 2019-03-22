package config;



import io.qameta.allure.Step;
import org.testng.Reporter;
import utils.DateTimeUtil;


public class ExtendReporter extends Reporter {

    @Step("{log}")
    public static void logToAllure(String log) {
        String date = DateTimeUtil.getCurrentDateTimeInUTC();
        Reporter.log("[" + date + "]" + log, true);
    }


}
