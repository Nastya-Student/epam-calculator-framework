package org.example.page;

import org.example.model.Instances;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CloudGoogleResultsPage extends AbstractPage {

    private final String PAGE_URL = "https://cloud.google.com/s/results?q=Google%20Cloud%20Platform%20Pricing%20Calculator";

    @Override
    protected CloudGoogleResultsPage openPage() {
        driver.navigate().to(PAGE_URL);
//        logger.info("Login page opened");
        return this;
    }

    private Instances testInstances;

    public CloudGoogleResultsPage(WebDriver driver, Instances testInstances) {
        super(driver);
        this.testInstances = testInstances;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='gsc-thumbnail-inside']//b[text()='Google Cloud Platform Pricing Calculator']/..")
    private WebElement resultLink;

    public CalculatorPage clickLinkToCalculator() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='gsc-thumbnail-inside']//b[text()='Google Cloud Platform Pricing Calculator']/..")));
        resultLink.click();
        return new CalculatorPage(driver, testInstances);
    }
}
