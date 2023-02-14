package testscripts;//import java.util.*;

import base.BaseClass;
import constantpaths.ConstantPaths;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesobjects.LoginPage;
import utils.ExcelFileReading;


public class VerifyLoginNegativeTest extends BaseClass {

    @BeforeMethod
    public void startBrowser() {
        BaseClass.initializeBrowser();
    }

    @Test(dataProvider = "loginDataNegative")
    public void verifyLoginTest(String email,String password,String expectedMsg) {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnLoginWithEmail();
        loginPage.doLogin(email,password);
        loginPage.clickOnLoginBtn();
        Assert.assertEquals(loginPage.getErrorMsg(),expectedMsg);
    }

    @DataProvider(name = "loginDataNegative")
    public Object[][] loginDataProvider() {
        return ExcelFileReading.getAllRows(ConstantPaths.EXCEL_DATA_PATH + "loginData.xlsx", "Sheet2");
    }

}
