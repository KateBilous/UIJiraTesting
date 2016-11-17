package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertionsAndWaits {



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
