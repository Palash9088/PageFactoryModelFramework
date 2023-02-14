package actions;//import java.util.*;

import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Actions extends BaseClass {

    public static void clickOnElement(WebElement element, boolean isWaitRequired) {
        if (isWaitRequired)
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        else
            element.click();
    }

    public static void enterText(WebElement element, String textToBe, boolean isWaitRequired) {
        if (isWaitRequired)
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(textToBe);
        else
            element.sendKeys(textToBe);
    }

    public static String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public static List<WebElement> getListOfWebElement(List<WebElement> elementList) {
        List<WebElement> webElementList = wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return webElementList;
    }

    public static List<String> getElementListInString(List<WebElement> elementList) {
        List<WebElement> elements = getListOfWebElement(elementList);
        List<String> elementListInString = new ArrayList<>();
        for (WebElement element : elements) {
            elementListInString.add(element.getAttribute("href"));
        }
        return elementListInString;
    }

    public static void checkBrokenLinks(List<WebElement> elementList) throws IOException {
        List<WebElement> webElementList = wait.until(ExpectedConditions.visibilityOfAllElements(elementList));

        for (int i = 0; i < webElementList.size(); i++) {
            String elementURL = webElementList.get(i).getAttribute("href");

            if (elementURL.equals("") || elementURL == null) {
                System.out.println("Missing Link : " + webElementList.get(i).getText());
            } else {
                URL url = new URL(elementURL);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                /* TakesScreenshot ts = (TakesScreenshot) driver; */

                int statusCode = connection.getResponseCode();
                if (statusCode == 200) {
                    System.out.println("Valid URL : " + elementURL);
                } else {
                    System.out.println("In valid URL : " + elementURL);
                }
            }

        }
    }
}
