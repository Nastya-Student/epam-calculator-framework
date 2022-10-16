package org.example.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class ResultInCalculatorPage extends AbstractCalculatorPage {

    public ResultInCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    JavascriptExecutor executor = (JavascriptExecutor) driver;

    @Override
    protected ResultInCalculatorPage openPage() {
        return null;
    }

    @Override
    protected void switchToMyFrame() {
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
    }

    @Override
    protected void leaveFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().defaultContent();
    }

    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//div[contains(text(),'Provisioning model')]")
    private WebElement provisioningModel;
    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//div[contains(text(),'Instance type:')]")
    private WebElement instanceType;
    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//div[contains(text(),'Region:')]")
    private WebElement region;
    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//div[contains(text(),'Local SSD:')]")
    private WebElement localSSD;
    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//div[contains(text(),'Commitment term:')]")
    private WebElement commitmentTerm;
    @FindBy(xpath = "//md-list[@class='cartitem ng-scope']//*[contains(text(),'Estimated Component Cost:')]")
    private WebElement estimatedComponentCost;
    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple' and contains(text(),'Email')]")
    private WebElement emailButton;
    @FindBy(xpath = "//form[@name='emailForm']//label[contains(text(),'Email')]/../input")
    private WebElement emailField;
    @FindBy(xpath = "//form[@name='emailForm']//button[contains(text(),'Send Email')]")
    private WebElement sendEmailButton;

    public String getProvisioningModel() {
        switchToMyFrame();
        String provisioningModelText = provisioningModel.getText().split(":")[1].trim();
        leaveFrame();
        return provisioningModelText;
    }

    public String getInstanceType() {
        switchToMyFrame();
        String instanceTypeText = instanceType.getText().split(":")[1].split("\n")[0].trim();
        leaveFrame();
        return instanceTypeText;
    }

    public String getRegion() {
        switchToMyFrame();
        String regionText = region.getText().split(":")[1].trim();
        leaveFrame();
        return regionText;
    }

    public String getLocalSSD() {
        switchToMyFrame();
        String localSSDText = localSSD.getText().split(":")[1].trim().split(" ")[0] + " GB";
        leaveFrame();
        return localSSDText;
    }

    public String getCommitmentTerm() {
        switchToMyFrame();
        String commitmentTermText = commitmentTerm.getText().split(":")[1].trim();
        leaveFrame();
        return commitmentTermText;
    }

    public String getEstimatedComponentCostFromCalculatorPage() {
        switchToMyFrame();
        String costText = estimatedComponentCost.getText().split(":")[1].trim();
        leaveFrame();
        return costText;
    }

    public String getEstimatedCostFromLetter(WebDriver driver) {
        switchToMyFrame();
        emailButton.click();
        executor.executeScript("window.open()");
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs.get(1));
        YopmailPage yopmailPage = new YopmailPage(driver);
        yopmailPage.openPage();
        String email = yopmailPage.generateEmail();
        driver.switchTo().window((String) tabs.get(0));
        switchToMyFrame();
        emailField.sendKeys(email);
        sendEmailButton.click();
        leaveFrame();
        driver.switchTo().window((String) tabs.get(1));
        return yopmailPage.getEstimateFromLetter();
    }

}
