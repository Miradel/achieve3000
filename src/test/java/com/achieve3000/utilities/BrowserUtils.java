package com.achieve3000.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForInvisibility( WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * This method will help to scroll the element to the middle of the window
     * @param pElement
     */

    public static void scrollIntoMiddleView(WebElement pElement) {
        executeJavaScriptFunctionOnPage("window.scrollTo(0,(arguments[0].getBoundingClientRect().top + window.pageYOffset) - (window.innerHeight / 2));", pElement);
    }

    public static Object executeJavaScriptFunctionOnPage(String scriptToExecute, WebElement elementToRunScriptAgainst) {
        Object res = null;
        try {
            if (Driver.getDriver() instanceof JavascriptExecutor) {
                JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
                if (elementToRunScriptAgainst != null) {
                    res = js.executeScript(scriptToExecute, new Object[]{elementToRunScriptAgainst});
                } else {
                    res = js.executeScript(scriptToExecute, new Object[0]);
                }
                if (res != null) {
                    System.out.println("-- Javascript executed successfully: " + res.toString());

                }
            } else {
                System.out.println("The driver you passed as parameter to function executeJavaScriptFunctionOnPage cannot run JavaScript, because the executor is not instanciated. Make sur that your driver allows you and is capabale of running java script.");
            }
        } catch (StaleElementReferenceException var5) {
            System.out.println("ERROR in function executeJavaScriptFunctionOnPage: StaleElementException");
        } catch (Exception var6) {
            System.out.println("ERROR in function executeJavaScriptFunctionOnPage:: " + var6.getMessage() + "\r\n" + var6.getLocalizedMessage() + "\r\n" + var6.toString());
        }
        return res;
    }




}
