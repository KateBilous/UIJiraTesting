package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Properties;

import java.util.concurrent.TimeUnit;

public class NewIssuePage {
    String issueKey = "";
    private WebDriver driver;
    Properties properties = new Properties();


    public NewIssuePage(WebDriver driver) {
        this.driver = driver;
    }

    public void createBug() {
        properties.waitForVisibilityByXpath(driver, "//*[@id='create_link']");
        properties.waitForClickableByXpath(driver, "//*[@id='create_link']");
        WebElement createButton = driver.findElement(By.xpath("//*[@id='create_link']"));
        createButton.click();

        WebElement issueType = driver.findElement(By.xpath("//*[@id='issuetype-field']"));

        issueType.clear();
        issueType.sendKeys("Bug");

        issueType.sendKeys(Keys.ENTER);

    }
    public void enterProject(){
        String projectFieldXpath = "//*[@id=\"project-field\"]";

        properties.waitForVisibilityByXpath(driver, projectFieldXpath);
        properties.waitForClickableByXpath(driver, projectFieldXpath);

        driver.findElement(By.xpath(projectFieldXpath)).click();
        driver.findElement(By.xpath(projectFieldXpath)).clear();
        driver.findElement(By.xpath(projectFieldXpath)).sendKeys("QAAUT", Keys.ENTER);
    }

    public void createSummary() {
        properties.waitForVisibilityByXpath(driver,"//*[@id='summary']" );
        properties.waitForClickableByXpath(driver,"//*[@id='summary']" );


        WebElement summary = driver.findElement(By.xpath("//*[@id='summary']"));
        summary.clear();
        summary.sendKeys(" This summary was created via WebDriver");

    }

    public void createAssignee() {
        WebElement assignee = driver.findElement(By.xpath("//*[@id='assignee-field']"));
        assignee.clear();
        assignee.sendKeys("katherinebilous", Keys.ENTER);

    }

    public void getIssueKey() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        issueKey = driver
                .findElement(By.xpath("//*[@id='aui-flag-container']/div/div/a"))
                .getAttribute("data-issue-key");
        System.out.println(issueKey);
    }

    public void deleteIssue() {
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        driver.findElement(By.xpath("//*[@id='opsbar-operations_more']/span[1]")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue']/span")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue-submit']")).click();
    }


}
