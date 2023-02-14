package pagesobjects;


import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPageReact extends BaseClass {

    public LoginPageReact()
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[type='text']")
    WebElement emailElement;

    @FindBy(css = "input[type='password']")
    WebElement passwordElement;
    public void login(String email, String password)
    {
        emailElement.sendKeys(email);
        passwordElement.sendKeys(password);
    }
    public String getAttributeEmail()
    {
        return emailElement.getAttribute("value");
    }
}


