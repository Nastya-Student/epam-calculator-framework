package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {
    private static WebDriver driver;


    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    //options.addArguments("--headless");
                    driver = new FirefoxDriver(options);
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    //options.addArguments("start-maximized"); // open Browser in maximized mode
                    //options.addArguments("disable-infobars"); // disabling infobars
                    //options.addArguments("--disable-extensions"); // disabling extensions
                    //options.addArguments("--disable-gpu"); // applicable to windows os only
                    //options.addArguments("--no-sandbox"); // Bypass OS security model
                    //options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
                    
                    
                    //options.addArguments("--ignore-certificate-errors");
                    //options.addArguments("--disable-popup-blocking");
                    //options.addArguments("--incognito");
                    
                    
                    options.addArguments("--remote-debugging-port=9222");
                    options.addArguments("--headless"); 
                    options.addArguments("--no-sandbox"); 
                    options.addArguments("--disable-gpu"); 
                    options.addArguments("--disable-dev-shm-usage"); 
                    
                    //options.setExperimentalOption("useAutomationExtension", false);
                    
                    
                    driver = new ChromeDriver(options);
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
