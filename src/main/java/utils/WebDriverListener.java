package utils;

public class WebDriverListener // implements IInvokedMethodListener
{

//    @Override
//    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
//        if (method.isTestMethod()) {
//            String browserName = method.getTestMethod().getXmlTest().getLocalParameters().get("browserName");
//            WebDriver driver = RemoteWebDriverFactory.createInstance(browserName);
//            RemoteDriverManager.setWebDriver(driver);
//        }
//    }
//
//    @Override
//    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
//        if (method.isTestMethod()) {
//            WebDriver driver = RemoteDriverManager.getDriver();
//            if (driver != null) {
//                driver.quit();
//            }
//        }
//    }
}
