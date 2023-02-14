package testscripts;//import java.util.*;

import base.BaseClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesobjects.HomepageZeCom;
import pagesobjects.LoginPageReact;

import java.io.IOException;
import java.time.Duration;

public class ZeComBrokenLinksTest extends BaseClass {
    @BeforeMethod()
    public void openBrowser(){
        BaseClass.initializeBrowser();
    }
    @Test
    public void linkTest() throws IOException {
        HomepageZeCom homepageZeCom = new HomepageZeCom();
        homepageZeCom.getLinkList();
    }
}
