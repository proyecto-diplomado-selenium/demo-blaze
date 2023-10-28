package webdriver.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EdgeDriverCreator extends WebDriverCreator{
        @Override
        public WebDriver createWebDriver() {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
            return new EdgeDriver();

    }
}
