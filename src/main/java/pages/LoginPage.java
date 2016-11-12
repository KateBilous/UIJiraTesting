package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import utils.AssertionsAndWaits;
import utils.RemoteDriverManager;

public class LoginPage {
    private WebDriver driver;
    AssertionsAndWaits assertionsAndWaits = new AssertionsAndWaits();

    public LoginPage() {
        this.driver = RemoteDriverManager.getDriver();

    }

    @Step("enter username")
    public void enterUsername() {
        String newTitle = "[VRC-";
        String title = "Log in - JIRA";

        driver.get("http://soft.it-hillel.com.ua:8080/login.jsp");
        AssertionsAndWaits.assertByTitle(driver, title);
        driver.findElement(By.id("login-form-username")).sendKeys("katherinebilous");
    }

    @Step("enter password")
    public void enterPassword() {
        driver.findElement(By.id("login-form-password")).sendKeys("Polis484)");
    }

    @Step("click login")
    public void clickLogin() {
        driver.findElement(By.id("login-form-submit")).click();
        assertionsAndWaits.waitForClickableByXpath(driver, "//*[@id='logo']/a/img");
    }

}
