package testscripts;//import java.util.*;

import base.BaseClass;

import constantpaths.ConstantPaths;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesobjects.LoginPage;
import utils.ExcelFileReading;


public class VerifyLoginPositiveTest extends BaseClass {

    @BeforeMethod
    public void startBrowser() {
        BaseClass.initializeBrowser();
    }

    @Test(dataProvider = "loginData")
    public void verifyLoginTest(String email,String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.clickOnLoginWithEmail();
        loginPage.doLogin(email,password);
        loginPage.clickOnLoginBtn();
    }

    @DataProvider(name = "loginData")
    public Object[][] loginDataProvider() {
        return ExcelFileReading.getAllRows(ConstantPaths.EXCEL_DATA_PATH + "loginData.xlsx", "Sheet1");
    }

}
