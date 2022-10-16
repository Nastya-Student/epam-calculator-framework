package org.example.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractYopMailPage extends AbstractPage {

    protected AbstractYopMailPage(WebDriver driver) {
        super(driver);
    }

    protected abstract void switchToIfMailFrame();

    protected abstract void leaveFrame();
}
