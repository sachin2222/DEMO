import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LocatorsInfo {

    public WebDriver driver;

    @FindBy(name="txtUsername")
    public static WebElement username;

    @FindBy(name="txtPassword")
    public  static WebElement password;

    @FindBy(name="Submit")
    public static WebElement submit;

    @FindBy(xpath="//*[@id=\"divLogo\"]/img")
    public static WebElement logo;

    @FindBy(xpath="//*[@id=\"menu_admin_viewAdminModule\"]/b")
    public static WebElement admin;


    public LocatorsInfo(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public static void setUsername(String email)
    {

        username.sendKeys(email);
    }

    public static void setPassword(String pass)
    {

        password.sendKeys(pass);
    }
    public static void submit()
    {

        submit.click();
    }

    public static boolean checkLogo()
    {
       boolean status= logo.isDisplayed();
       return status;
    }

    public static void clickOnAdmin()
    {
        admin.click();
    }
}
