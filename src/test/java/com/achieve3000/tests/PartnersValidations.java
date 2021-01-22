package com.achieve3000.tests;

import com.achieve3000.enums.UIElements;
import com.achieve3000.pages.BasePage;
import com.achieve3000.pages.PartnersPage;
import com.achieve3000.utilities.BrowserUtils;
import com.achieve3000.utilities.ConfigurationReader;
import com.achieve3000.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class PartnersValidations {

    @BeforeClass
    public void setUp() {
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }


    @Test
    public void test_Logo_Headers_Description() {

        // Open the url of the page
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BasePage.waitSpinnerDisappear();

        // Click hamburger menu( left corner) in top right corner
        BasePage.clickMenuIcon();

        // Open "Our Partners" from the list
        BasePage.clickByLinkText(UIElements.OurPartners.getValue());

        // List all partners webElements
        List<WebElement> allPartners = PartnersPage.getAllPartners();

        // List all partners logo
        List<String> logoAddresses = allPartners.stream().map(partner -> partner.findElement(PartnersPage.logo).
                getAttribute("src")).collect(Collectors.toList());


        // Check all presented partners has logo
        Assert.assertTrue(allPartners.stream().
                allMatch(partner -> {
                    BrowserUtils.scrollIntoMiddleView(partner);
                    return partner.findElement(PartnersPage.logo).isDisplayed();
                }));

        // Check all presented partners has header
        Assert.assertTrue(allPartners.stream().
                allMatch(partner -> {
                    BrowserUtils.scrollIntoMiddleView(partner);
                    return !partner.findElement(PartnersPage.header).getText().isEmpty();
                }));

        // Check all presented partners text description
        Assert.assertTrue(allPartners.stream().
                allMatch(partner -> {
                    BrowserUtils.scrollIntoMiddleView(partner);
                    return !partner.findElement(PartnersPage.description).getText().isEmpty();
                }));
    }

    @AfterClass
    public void closeDriver() {
        Driver.getDriver().close();
    }

}
