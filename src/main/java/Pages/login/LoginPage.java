package Pages.login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.helper.Link;
import Pages.dashboard.dashboardPage;

public class LoginPage {
    @FindBy (id = "crm-login-account")
    @CacheLookup
    WebElement crm_login_account;

    @FindBy (id = "crm-login-password")
    @CacheLookup
    WebElement crm_login_password;

    @FindBy (css = ".crm-button-login")
    @CacheLookup
    WebElement crm_button_login;

    @FindBy (css = ".login-error")
    @CacheLookup
    public WebElement login_error;

    WebDriver driver;
    Link links;

    public LoginPage(WebDriver driver)
    {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }
    public dashboardPage login1(String User, String Pass)throws Throwable{
        Thread.sleep(1000);
        crm_login_account.sendKeys(User);
        crm_login_password.sendKeys(Pass);
        crm_button_login.click();
        return new dashboardPage(driver);
    }
    public boolean isDisplayed() {
        if (links.URL_getalllead.equals(driver.getCurrentUrl())) {
            return true;
        } else {
            return false;
        }
    }
}