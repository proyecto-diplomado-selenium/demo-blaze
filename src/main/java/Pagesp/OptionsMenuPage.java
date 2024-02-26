package Pagesp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OptionsMenuPage extends MainPage{

    public OptionsMenuPage(WebDriver driver) {
        super(driver);
    }

    private  String optionName = "//cu-dropdown-list-item//button[contains(.,'%s')]";
    private  String spaceSettignName = "//div[contains(@class, 'nav-menu-item') and normalize-space()='%s']";

    public void selectOption(final String value) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionName,value)))).click();
    }

    public void settingOption(final String value) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(spaceSettignName,value)))).click();
    }
}
