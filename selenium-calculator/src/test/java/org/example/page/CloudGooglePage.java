package org.example.page;

import org.example.model.Instances;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CloudGooglePage extends AbstractPage{

    private final String BASE_URL = "https://cloud.google.com";
    private Instances testInstances;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    @Override
    public CloudGooglePage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("CloudGooglePage opened");
        return this;
    }

    public CloudGooglePage(WebDriver driver, Instances testInstances){
        super(driver);
        this.testInstances = testInstances;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@aria-autocomplete='list']")
    private WebElement searchField;

    public CloudGoogleResultsPage searchCalculator(String text){
         wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-autocomplete='list']")));
        searchField.click();
        logger.info("searchField clicked");
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
        return new CloudGoogleResultsPage(driver, testInstances);
    }

}
