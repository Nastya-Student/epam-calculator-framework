package org.example.page;

import org.example.model.Instances;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CloudGooglePage extends AbstractPage{

    private final String BASE_URL = "https://cloud.google.com";
    private Instances testInstances;
    @Override
    public CloudGooglePage openPage() {
        driver.navigate().to(BASE_URL);
//        logger.info("Login page opened");
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
        searchField.click();
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
        return new CloudGoogleResultsPage(driver, testInstances);
    }

}