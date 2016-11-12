package JiraUITests;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LogoutPage;
import pages.NewIssuePage;
import pages.LoginPage;
import pages.UpdateIssuePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import utils.AssertionsAndWaits;
import utils.TestListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


@Listeners(TestListener.class)
public class JiraUI {

    @Test
    public void Login() {

        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();


    }

    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test
    public void createIssue() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
        NewIssuePage newIssuePage = new NewIssuePage();
        newIssuePage.createBug();
        newIssuePage.enterProject();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        newIssuePage.getIssueKey();
        newIssuePage.deleteIssue();
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.Logout();


    }

    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test(groups = {"CreateIssueFunctions"})
    public void updateIssueAddComment() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
        NewIssuePage newIssuePage = new NewIssuePage();
        UpdateIssuePage updateIssuePage = new UpdateIssuePage();
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();
        updateIssuePage.addComment();
        updateIssuePage.deleteIssue();
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.Logout();


    }

    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test(groups = {"CreateIssueFunctions"})
    public void updateReporter() {

        // WebDriver driver = Grid();
        // setUp(driver);
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
        NewIssuePage newIssuePage = new NewIssuePage();
        UpdateIssuePage updateIssuePage = new UpdateIssuePage();
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();
        updateIssuePage.updateReporter();
        updateIssuePage.deleteIssue();
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.Logout();


    }

    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test(groups = {"CreateIssueFunctions"})
    public void updatePriority() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
        NewIssuePage newIssuePage = new NewIssuePage();
        UpdateIssuePage updateIssuePage = new UpdateIssuePage();
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();
        updateIssuePage.updatePriority();
        updateIssuePage.deleteIssue();
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.Logout();


    }


    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test(groups = {"CreateIssueFunctions"})
    public void updateIssueTitle() {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();
        NewIssuePage newIssuePage = new NewIssuePage();
        UpdateIssuePage updateIssuePage = new UpdateIssuePage();
        newIssuePage.createBug();
        newIssuePage.createSummary();
        newIssuePage.createAssignee();
        updateIssuePage.getIssueKey();
        updateIssuePage.updateIssueTitle();
        updateIssuePage.deleteIssue();
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.Logout();


    }


}


