import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebDriverTest {
    public WebDriver driver;
    public String chromedriverpath = "C:\\sachin\\chromedriver_win32\\chromedriver.exe";
    public String chromedriverkey = "webdriver.chrome.driver";
    public String URL = "https://opensource-demo.orangehrmlive.com/";
    public String dashboardURL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
    public LocatorsInfo locator;
    public Logger logger;


    @BeforeSuite
    public void logger() {
        logger = Logger.getLogger("WebDriverTest");
        DOMConfigurator.configure("log.xml");
    }

    @BeforeTest
    public void setup() {
        System.setProperty(chromedriverkey, chromedriverpath);
        driver = new ChromeDriver();

        new LocatorsInfo(driver);
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @Test(priority =2)
    public  void loginTest() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LocatorsInfo.setUsername("Admin");
        LocatorsInfo.setPassword("admin123");
        LocatorsInfo.submit();

        String expURL = dashboardURL;
        String actURL = driver.getCurrentUrl();
        Assert.assertEquals(expURL, actURL);

    }

    @Test(priority = 1)
    public void titleTest() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String expTitle = "OrangeHRM";
        String actTitle = driver.getTitle();
        Assert.assertEquals(expTitle, actTitle);

    }

    @Test(priority = 0)
    public void logoTest() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        boolean logostatus =LocatorsInfo.checkLogo();
        Assert.assertEquals(logostatus, true);

    }

    @Test(priority=3)
    public void adminTest()
    {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LocatorsInfo.clickOnAdmin();
    }


}
