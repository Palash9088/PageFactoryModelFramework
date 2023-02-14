package pagesobjects;//import java.util.*;

import actions.Actions;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BaseClass {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[aria-label='Log in with email address']")
    WebElement loginEmailBtn;

    public void clickOnLoginWithEmail() {
        Actions.clickOnElement(loginEmailBtn, true);
    }

    @FindBy(xpath = "//input[@id='jsc_c_3']")
    WebElement loginField;
    @FindBy(xpath = "//input[@id='jsc_c_5']")
    WebElement passwordField;

    public void doLogin(String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
    }
    @FindBy(xpath = "(//div[@class='x1ldtxkg xo1l8bm x1jchvi3 x1pujyh6 x162n0lu x12429cg x6tc29j xbq7h4v x6jdkww xq9mrsl'])[1]")
    WebElement emailElement;
    public String getElementText()
    {
        return wait.until(ExpectedConditions.visibilityOf(emailElement)).getText();

    }
    @FindBy(xpath = "//div[@class='xlp1x4z x1ey2m1c xds687c x10l6tqk x17qophe xv7j57z']//span[@class='x1lliihq x193iq5w x6ikm8r x10wlt62 xlyipyv xuxw1ft'][normalize-space()='Log in']")
    WebElement loginBtn;
    public void clickOnLoginBtn()
    {
        Actions.clickOnElement(loginBtn,false);
    }
    @FindBy(xpath = "//h2[@class='x1heor9g x1qlqyl8 x1pd3egz x1a2a7pz xw7yly9 x1h5jrl4 x1yztbdb xmn8rco x10b6aqq xxbr6pl xm7lytj']")
    WebElement errorMsg;
    public String getErrorMsg()
    {
        return wait.until(ExpectedConditions.visibilityOf(errorMsg)).getText();
    }
}
