package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static com.thoughtworks.selenium.SeleneseTestBase.assertTrue;
import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;

public class Properties {

    public void scrollPageUp(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, -250);");
    }

    public void waitForVisibilityByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public void waitForClickableByXpath(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public void screen(WebDriver driver, String name) {
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Random rn = new Random();
        int randInt = rn.nextInt();
        try {
            FileUtils.copyFile(screen, new File("D:/Hillel/lab_hillel/LR_10/UITestingJira/" + name + randInt + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public WebDriver Grid(){
        URL hostURL = null;
        try {
            hostURL = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);

        WebDriver driver = new org.openqa.selenium.remote.RemoteWebDriver(hostURL, capability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        // разворачивает окно браузера
        driver.manage().window().maximize();
        return driver;

    }

    public static void  assertByTitle(WebDriver driver, String title) {
        String currentTitle = driver.getTitle();
        assertEquals(currentTitle, title);

    }
    public void assertTextByXpath(WebDriver driver, String XPath, String text){
        driver.navigate().refresh();
        waitForVisibilityByXpath(driver, XPath);
        String aIssueTitle = driver.findElement(By.xpath(XPath)).getText();
        assertTrue(aIssueTitle.contains(text));
    }
}
