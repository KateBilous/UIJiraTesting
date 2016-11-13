package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import utils.BasePage;
import utils.RemoteDriverManager;

public class UpdateIssuePage extends BasePage {

    String issueKey = "";
    private WebDriver driver;


    public UpdateIssuePage() {
        this.driver = RemoteDriverManager.getDriver();
    }

    @Step("update reporter")
    public void updateReporter() {
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        scrollPageUp(driver);

        driver.findElement(By.xpath(".//*[@id='reporter-val']")).click();
        driver.findElement(By.xpath(".//*[@id='reporter-field']")).sendKeys("a.a.piluck2 ", Keys.ENTER);


    }

    @Step("update priority")
    public void updatePriority() {
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        scrollPageUp(driver);
        WebElement priority = driver.findElement(By.xpath("//*[@id='priority-val']"));

        priority.click();
        WebElement priorityChange = driver.findElement(By.xpath("//*[@id='priority-field']"));

        priorityChange.clear();

        priorityChange.sendKeys("Low", Keys.ENTER, Keys.ENTER);

    }

    @Step("get issue key")
    public void getIssueKey() {
        issueKey = driver
                .findElement(By.xpath("//*[@id='aui-flag-container']/div/div/a"))
                .getAttribute("data-issue-key");
        System.out.println(issueKey);
    }

    @Step("add comment")
    public void addComment() {
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        WebElement comment = driver.findElement(By.xpath("//*[@id='comment-issue']/span[1]"));
        comment.click();
        WebElement addComment = driver.findElement(By.xpath("//*[@id='comment']"));

        addComment.sendKeys("This comment was added via WebDriver", Keys.CONTROL, Keys.ENTER);


    }

    @Step("update issue title")
    public void updateIssueTitle() {
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        WebElement changeIssueTitle = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='summary-val']")));

        changeIssueTitle.click();
        WebElement changeIssueSummary = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='summary']")));
        changeIssueSummary.clear();

        changeIssueSummary.sendKeys(" This title was changed via WebDriver", Keys.ENTER);
    }

    @Step("delete issue")
    public void deleteIssue() {
        driver.get("http://soft.it-hillel.com.ua:8080/browse/" + issueKey);
        driver.findElement(By.xpath("//*[@id='opsbar-operations_more']/span[1]")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue']/span")).click();
        driver.findElement(By.xpath("//*[@id='delete-issue-submit']")).click();
    }


}
