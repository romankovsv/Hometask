package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static config.Settings.CHROME_DRIVER;
import static config.Settings.CHROME_DRIVER_PATH;


public class TestSessionListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Settings.getProperties();
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.fastSetValue = true;
        Configuration.startMaximized = true;
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        Configuration.browser = "chrome";
        Configuration.savePageSource = false;
    }


    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        WebDriverRunner.getSelenideDriver().close();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot(WebDriverRunner.getWebDriver());
        WebDriverRunner.getSelenideDriver().close();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        WebDriverRunner.getSelenideDriver().close();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
