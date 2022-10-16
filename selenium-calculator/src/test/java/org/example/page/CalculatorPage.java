package org.example.page;

import org.example.model.Instances;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage extends AbstractCalculatorPage {

    private final String PAGE_URL = "https://cloud.google.com/products/calculator";
    private Instances testInstances;

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    JavascriptExecutor executor = (JavascriptExecutor) driver;

    //    private Instances testInstances = InstancesCreater.createInstances();
    public CalculatorPage(WebDriver driver, Instances testInstances) {
        super(driver);
        this.testInstances = testInstances;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//md-pagination-wrapper//div[@class='name ng-binding' and text()='Compute Engine']")
    private WebElement computeEngine;
    @FindBy(xpath = "//label[contains (text(), 'Number of instances')]/../input")
    private WebElement numberOfInstances;
    @FindBy(xpath = "//label[contains (text(), 'Operating System / Software')]/..//span[@class='md-select-icon']")
    private WebElement operatingSystem;
    @FindBy(xpath = "//label[contains (text(), 'Provisioning model')]/..//span[@class='md-select-icon']")
    private WebElement provisioningModel;
    @FindBy(xpath = "//label[contains (text(), 'Series')]/..//span[@class='md-select-icon']")
    private WebElement series;
    @FindBy(xpath = "//label[contains (text(), 'Machine type')]/..//span[@class='md-select-icon']")
    private WebElement machineType;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[@placeholder='Datacenter location']//span[@class='md-select-icon']")
    private WebElement datacenterLocation;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//*[@aria-label='Add GPUs']//div[@class='md-container md-ink-ripple']")
    private WebElement addGPUs;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement gpuType;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUs;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Local SSD']")
    private WebElement localSSD;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//md-select[@placeholder='Committed usage']")
    private WebElement committedUsage;
    @FindBy(xpath = "//form[@name='ComputeEngineForm']//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement addToEstimate;

    @Override
    protected CalculatorPage openPage() {
        driver.navigate().to(PAGE_URL);
//        logger.info("Login page opened");
        return this;
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

    public void selectNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances.sendKeys(numberOfInstances);
    }

    public void selectOperatingSystem(WebDriver driver) {
        By operatingSystemItem = By
                .xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'"
                        + testInstances.getOperatingSystem() + "')]");
        operatingSystem.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(operatingSystemItem));
        driver.findElement(operatingSystemItem).click();
    }

    public void selectProvisioningModel(WebDriver driver) {
        By provisioningModelItem = By
                .xpath("//*[@class='md-ink-ripple']/div[contains(text(),'"
                        + testInstances.getProvisioningModel() + "')]");
        provisioningModel.click();
        executor.executeScript("arguments[0].click();", driver.findElement(provisioningModelItem));
    }

    public void selectSeries(WebDriver driver) {
        By seriesItem = By
                .xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'"
                        + testInstances.getSeries() + "')]");
        series.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(seriesItem));
        executor.executeScript("arguments[0].click();", driver.findElement(seriesItem));
    }

    public void selectMachineType(WebDriver driver) {
        By machineTypeItem = By
                .xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'"
                        + testInstances.getMachineType() + "')]");
        machineType.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(machineTypeItem));
        executor.executeScript("arguments[0].click();", driver
                .findElement(machineTypeItem));
    }

    public void selectDataCenterLocation(WebDriver driver) {
        By dataCenterLocationItem = By
                .xpath("//div[@class='md-select-menu-container cpc-region-select md-active md-clickable']//md-optgroup//div[contains(text(),'"
                        + testInstances.getDatacenterLocation() + "')]");
        datacenterLocation.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(dataCenterLocationItem));
        executor.executeScript("arguments[0].click();", driver.findElement(dataCenterLocationItem));
    }

    public void fillGPUsValues(WebDriver driver) {
        addGPUs.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-select[@placeholder='GPU type']")));
        gpuType.click();
        By gpuTypeItem = By
                .xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'"
                        + testInstances.getGpuType() + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(gpuTypeItem));
        executor.executeScript("arguments[0].click();", driver.findElement(gpuTypeItem));

        numberOfGPUs.click();
        By numberOfGPUsItem = By
                .xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'"
                        + testInstances.getNumberOfGPUs() + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(numberOfGPUsItem));
        executor.executeScript("arguments[0].click();", driver.findElement(numberOfGPUsItem));
    }

    public void selectLocalSSD(WebDriver driver) {
        localSSD.click();
        By localSSDItem = By
                .xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'"
                        + testInstances.getLocalSSD() + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(localSSDItem));
        executor.executeScript("arguments[0].click();", driver.findElement(localSSDItem));
    }

    public void selectCommittedUsage(WebDriver driver) {
        committedUsage.click();
        By committedUsageItem = By
                .xpath("//div[@class='md-select-menu-container md-active md-clickable']//div[contains(text(),'"
                        + testInstances.getCommittedUsage() + "')]");
        wait.until(ExpectedConditions.presenceOfElementLocated(committedUsageItem));
        executor.executeScript("arguments[0].click();", driver.findElement(committedUsageItem));
    }

    public CalculatorPage activateComputeEngine() {
        switchToMyFrame();
        computeEngine.click();
        leaveFrame();
        return this;
    }

    public ResultInCalculatorPage fillForm(WebDriver driver) {
        switchToMyFrame();
        selectNumberOfInstances(testInstances.getNumberOfInstances());
        selectOperatingSystem(driver);
        selectProvisioningModel(driver);
        selectSeries(driver);
        selectMachineType(driver);
        selectDataCenterLocation(driver);
        fillGPUsValues(driver);
        selectLocalSSD(driver);
        selectCommittedUsage(driver);
        addToEstimate.click();
        leaveFrame();
        return new ResultInCalculatorPage(driver);
    }
}
