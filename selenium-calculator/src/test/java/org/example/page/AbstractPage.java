package org.example.page;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class AbstractPage {
    protected WebDriver driver;
     protected static Logger logger = LogManager.getRootLogger();

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract AbstractPage openPage();
}
