package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceOrderPage extends BasePage{
    private final By name = By.id("name");
    private final By country = By.id("country");
    private final By city = By.id("city");
    private final By card = By.id("card");
    private final By month = By.id("month");
    private final By year = By.id("year");
    private final By closeBtn = By.xpath("//div[@id='orderModal']//button[@type='button'][normalize-space()='Close']");
    private final By purchaseBtn = By.xpath("//button[normalize-space()='Purchase']");

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }

    public void enterCountry(String country) {
        driver.findElement(this.country).sendKeys(country);
    }

    public void enterCity(String city) {
        driver.findElement(this.city).sendKeys(city);
    }

    public void enterCard(String card) {
        driver.findElement(this.card).sendKeys(card);
    }

    public void enterMonth(String month) {
        driver.findElement(this.month).sendKeys(month);
    }

    public void enterYear(String year) {
        driver.findElement(this.year).sendKeys(year);
    }
    public void clickOnCloseButton() {
        driver.findElement(this.closeBtn).click();
    }

    public void clickOnPurchaseButton() {
        driver.findElement(this.purchaseBtn).click();
    }


    public void fillPurchaseInformation(String name,String country,String city,String numberCard,String month,String year){
        enterName(name);
        enterCountry(country);
        enterCity(city);
        enterCard(numberCard);
        enterMonth(month);
        enterYear(year);
        clickOnPurchaseButton();
    }

}
