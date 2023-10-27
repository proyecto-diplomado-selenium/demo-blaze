package conf;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import webdriver.factory.WebDriverFactory;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters({"url", "browser"})
    public void setup(String url, String browser) throws Exception {
        driver = WebDriverFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
