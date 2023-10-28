package conf;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.ITestResult;
import utils.Log;
import utils.ReportHelper;
import utils.ScreenShotHelper;
import org.testng.annotations.Parameters;
import webdriver.factory.WebDriverFactory;


import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public static void setUpSuite() throws Exception {
        ReportHelper.init("resource", "demo-blaze-report");
    }

    @BeforeMethod
    @Parameters({"url", "browser"})
    public void setup(String url, String browser, Method method) throws Exception {

        Log.info("Tests is starting!");
        ReportHelper.getInstance().startTest(method.getName());
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        Log.info("Tests are ending!");
        try {
            switch (iTestResult.getStatus()){
                case ITestResult.FAILURE:
                    ReportHelper.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    ReportHelper.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    ReportHelper.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    ReportHelper.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if(iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null){
                ReportHelper.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(driver, Status.FAIL, "Failure Image");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(driver != null)
                driver.quit();
        }
    }

    @AfterSuite
    public static void tearDownSuite(){
        ReportHelper.getInstance().flush();
    }
}
