package JiraUITests;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.LogoutPage;
import pages.NewIssuePage;
import pages.LoginPage;
import pages.UpdateIssuePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import utils.MyClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class JiraUI {
    String issueKey = "";
    WebDriver driver = maxWinTimeout();



    //@BeforeTest
    public void setUp(WebDriver driver) {

        LoginPage loginPage = new LoginPage(driver);
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        loginPage.enterUsername();
        loginPage.enterPassword();
        loginPage.clickLogin();


    }
    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test
    public void createIssue() {

        WebDriver driver = Grid();

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

    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test( groups ={"CreateIssueFunctions"})
    public void updateIssueAddComment() {
        WebDriver driver = Grid();

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


    }
    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test( groups ={"CreateIssueFunctions"})
    public void updateReporter() {

        WebDriver driver = Grid();
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



    }
    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test( groups ={"CreateIssueFunctions"})
    public void updatePriority() {
        WebDriver driver = Grid();

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



    }



    @TestCaseId("Functions")
    @Features("CreateIssue")
    @Stories({"SomeStory"})
    @Test( groups ={"CreateIssueFunctions"})
    public void updateIssueTitle() {
        WebDriver driver = Grid();
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

    }
    public WebDriver maxWinTimeout(){
         WebDriver driver;

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );

        driver.manage().window().maximize();
        return driver;
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

        WebDriver driver = new RemoteWebDriver(hostURL, capability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        // разворачивает окно браузера
        driver.manage().window().maximize();
        return driver;

    }
    @AfterMethod

    public void afterMethod(ITestResult result){
        MyClass myClass = new MyClass();
        try{
            if(result.getStatus() == ITestResult.SUCCESS){
                //Do something here
            }
            else if(result.getStatus() == ITestResult.FAILURE){
                //Do something here
                myClass.screen(driver, "_FAILED_"+result.getName());
            }
            else if(result.getStatus() == ITestResult.SKIP ){
                //Do something here
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }




    //Test(priority =2)
    public void Logout() {
        WebDriver driver = maxWinTimeout();
        LogoutPage logout = new LogoutPage(driver);
       logout.Logout();

    }

}


