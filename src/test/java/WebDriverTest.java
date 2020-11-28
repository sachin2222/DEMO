import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriverTest {
    public WebDriver driver;
    public String path="C:\\sachin\\chromedriver_win32\\chromedriver.exe";
    public String chromedriverkey="webdriver.chrome.driver";
    public String URL="https://opensource-demo.orangehrmlive.com/";


    @BeforeSuite
    public void setup()
    {
        System.setProperty(chromedriverkey,path);
        driver=new ChromeDriver();

    }
    @Test
    public void launchBrowserTest()
    {
        driver.get(URL);
    }
    @Test
    public void loginTest()
    {
        driver.findElement(By.name("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.name("Submit")).click()


    }




}
