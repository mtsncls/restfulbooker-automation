package core.config.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.config.driver.DriverManager;
import io.qameta.allure.Attachment;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
    
}
