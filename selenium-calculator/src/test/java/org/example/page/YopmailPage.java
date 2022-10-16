package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopmailPage extends AbstractYopMailPage {
    private final String PAGE_URL = "https://yopmail.com";

    @Override
    protected YopmailPage openPage() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public YopmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void switchToIfMailFrame() {
        driver.switchTo().frame("ifmail");
    }

    @Override
    protected void leaveFrame() {
        driver.switchTo().defaultContent();
    }

    @FindBy(xpath = "//*[text()='Случайный адрес электронной почты']")
    private WebElement emailGeneratorField;
    @FindBy(xpath = "//div[@id='egen']")
    private WebElement emailAddress;
    @FindBy(xpath = "//span[text()='Проверить почту']")
    private WebElement checkEmailButton;
    @FindBy(xpath = "//*[contains(text(),'Estimated Monthly Cost:')]")
    private WebElement estimateFromLetter;
    @FindBy(xpath = "//button[@id='refresh']")
    private WebElement refreshButton;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    public String generateEmail() {
        emailGeneratorField.click();
        return emailAddress.getText();
    }

    public String getEstimateFromLetter() {
        checkEmailButton.click();
        refreshButton.click();
        switchToIfMailFrame();
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//*[contains(text(),'Estimated Monthly Cost:')]")));
        String result = estimateFromLetter.getText().split(":")[1].trim() + " per 1 month";
        leaveFrame();
        return result;
    }
}
