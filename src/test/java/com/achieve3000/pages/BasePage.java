package com.achieve3000.pages;

import com.achieve3000.utilities.BrowserUtils;
import com.achieve3000.utilities.Driver;
import org.openqa.selenium.By;

public class BasePage {

    public static By menuIcon = By.cssSelector("button.navbar-toggler.collapsed");
    public static By spinner = By.className("loader");

    public static void clickMenuIcon(){
        BrowserUtils.waitForVisibility(Driver.getDriver().findElement(menuIcon),5);
        Driver.getDriver().findElement(menuIcon).click();
    }

    public static void clickByLinkText(String linkText){
        Driver.getDriver().findElement(By.linkText(linkText)).click();
    }

    public static void waitSpinnerDisappear(){
        BrowserUtils.waitForInvisibility(Driver.getDriver().findElement(spinner),5);
    }

}
