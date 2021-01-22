package com.achieve3000.pages;

import com.achieve3000.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class PartnersPage extends BasePage {

    public static By allPartners = By.xpath("//div[@class='row h-100 ']");
    public static By logo = By.xpath(".//img");
    public static By header = By.xpath(".//h3");
    public static By description = By.xpath(".//p");

    public static List<WebElement> getAllPartners() {
        return Driver.getDriver().findElements(allPartners);
    }

}
