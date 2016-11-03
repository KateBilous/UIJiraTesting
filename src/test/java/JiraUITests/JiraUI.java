package JiraUITests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LogoutPage;
import pages.NewIssuePage;
import pages.LoginPage;
import pages.UpdateIssuePage;

import java.util.concurrent.TimeUnit;

public class JiraUI {
    String issueKey = "";




    //@BeforeTest
    public void setUp(WebDriver driver) {
        //WebDriver driver = tyt();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();


    }

    @Test
    public void createIssue() {
        WebDriver driver = tyt();
        setUp(driver);
        NewIssuePage newIssuePage = new NewIssuePage(driver);

        newIssuePage.createBug();
        newIssuePage.enterProject();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        newIssuePage.getIssueKey();
        newIssuePage.deleteIssue();
        driver.quit();


    }


    @Test
    public void updateIssueAddComment() {
        WebDriver driver = tyt();
        setUp(driver);
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        UpdateIssuePage updateIssuePage = new UpdateIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();




        updateIssuePage.addComment();

        updateIssuePage.deleteIssue();
        driver.quit();


        // TODO assert
    }

    @Test
    public void updateReporter() {
        WebDriver driver = tyt();
        setUp(driver);
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        UpdateIssuePage updateIssuePage = new UpdateIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();




        updateIssuePage.updateReporter();

        updateIssuePage.deleteIssue();
        driver.quit();


        // TODO assert
    }

    @Test
    public void updatePriority() {
        WebDriver driver = tyt();
        setUp(driver);
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        UpdateIssuePage updateIssuePage = new UpdateIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();




        updateIssuePage.updatePriority();

        updateIssuePage.deleteIssue();
        driver.quit();


        // TODO assert
    }

    @Test
    public void updateIssueTitle() {
        WebDriver driver = tyt();
        setUp(driver);
        NewIssuePage newIssuePage = new NewIssuePage(driver);
        UpdateIssuePage updateIssuePage = new UpdateIssuePage(driver);
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();



        updateIssuePage.updateIssueTitle();

        updateIssuePage.deleteIssue();
        driver.quit();


        // TODO assert
    }
    public WebDriver tyt(){
         WebDriver driver;

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        driver.manage().window().maximize();
        return driver;
    }


   // @AfterTest
    public void tearDown() {
        WebDriver driver = tyt();


        driver.close(); // TODO investigate why browser is not closed
        driver.quit();

    }


    //Test(priority =2)
    public void Logout() {
        WebDriver driver = tyt();
        LogoutPage logout = new LogoutPage(driver);
       logout.Logout();

    }

}


