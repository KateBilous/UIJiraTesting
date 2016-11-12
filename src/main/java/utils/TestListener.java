package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

    @Attachment
    public File captureScreenshot(WebDriver d) {
        File file = null;
        try {
            file = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);

        }catch (WebDriverException e){
            e.printStackTrace();
        }
        return file;
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println("Screesnshot captured for test case:" + tr.getMethod().getMethodName());
        File screen = captureScreenshot((WebDriver) RemoteDriverManager.getDriver());
        try {
            FileUtils.copyFile(screen, new File("\"C:\\Users\\Kate\\Desktop\\screenshots\\" + tr.getMethod().getMethodName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("Screesnshot captured for test case:" + tr.getMethod().getMethodName());
        File screen = captureScreenshot((WebDriver) RemoteDriverManager.getDriver());
        try {
            FileUtils.copyFile(screen, new File("\"C:\\Users\\Kate\\Desktop\\screenshots\\" + tr.getMethod().getMethodName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        String browserName = iTestContext.getCurrentXmlTest().getParameter("browserName");
        WebDriver driver = RemoteWebDriverFactory.createInstance(browserName);
        RemoteDriverManager.setWebDriver(driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        WebDriver driver = RemoteDriverManager.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}