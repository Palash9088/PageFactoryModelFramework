package base;//import java.util.*;

import constantpaths.ConstantPaths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    private static Properties prop;
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @BeforeSuite
    public void propReading() {
        try {
            File file = new File(ConstantPaths.PROP_PATH);
            FileInputStream fileInputStream = new FileInputStream(file);
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (
                IOException e) {
            System.out.println("Properties file not found");
        }
    }


    public static void initializeBrowser() //Selenium 4.6.0 after that
    {
        switch (prop.getProperty("browserName").toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("kiosk-printing");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                driver = new EdgeDriver();
            default:
                System.out.println("Illegal Browser Name");
                break;
        }
        driver.manage().window().maximize();
        driver.get(prop.getProperty("urlName"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void closeBrowser() {
        driver.close();
    }

}
