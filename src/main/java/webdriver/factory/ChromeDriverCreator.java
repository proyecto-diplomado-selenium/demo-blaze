package webdriver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverCreator extends WebDriverCreator{
    @Override
    public WebDriver createWebDriver ()
    {
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
