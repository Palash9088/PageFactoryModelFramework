package testscripts;//import java.util.*;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesobjects.LoginPageReact;

import java.time.Duration;

public class ZeComBrokenLinksTest extends BaseClass {
    @BeforeMethod()
    public void openBrowser(){
        BaseClass.initializeBrowser();
    }
    @Test
    public void m1()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
