package org.example.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractCalculatorPage extends AbstractPage {

    protected AbstractCalculatorPage(WebDriver driver) {
        super(driver);
    }

    protected abstract void switchToMyFrame();

    protected abstract void leaveFrame();
}
