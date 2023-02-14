package pagesobjects;//import java.util.*;

import actions.Actions;
import base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.stylesheets.LinkStyle;

import java.io.IOException;
import java.util.List;

public class HomepageZeCom extends BaseClass {

    public HomepageZeCom()
    {
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "a")
    List<WebElement> elements;

    public void getLinkList() throws IOException {
        Actions.checkBrokenLinks(elements);
    }

}
