package webdriver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeDriverCreator extends WebDriverCreator{
        @Override
        public WebDriver createWebDriver() {
            //System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();

    }
}
