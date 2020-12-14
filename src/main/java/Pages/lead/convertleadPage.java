package Pages.lead;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.helper.Link;

public class convertleadPage {

    @FindBy(xpath = "//td[2]/div/a")
    public WebElement LeadDetail;

    @FindBy(id = "btn-convert-lead")
    public WebElement btconvert;

    @FindBy(name = "NameDeal")
    public WebElement Name_deal;

    @FindBy(id = "convert-lead-value-currency")
    public WebElement valuedeal;

    @FindBy(css = "#ChangePipelineCovert > span")
    public WebElement btnconvertdeal;

    @FindBy(name = "ContactName")
    public WebElement contact;

    @FindBy(name = "mobile_0")
    public WebElement mobilelh;

    @FindBy(name = "email_0")
    public WebElement maillh;

    WebDriver driver;
    WebDriverWait wait;
    Link links;

    public convertleadPage(WebDriver driver)
    {
        this.driver =driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }
    public void ConvertLead (String Namedeal, String Valuedeal){
        LeadDetail.click();
        btconvert.click();
        Name_deal.sendKeys(Namedeal);
        valuedeal.sendKeys(Valuedeal);
        btnconvertdeal.click();
    }
    public void ConvertLeadfail (String cont, String mobi, String mail, String Namedeal, String Valuedeal) throws Throwable{
        LeadDetail.click();
        btconvert.click();
        Thread.sleep(1000);
        contact.clear();
        contact.sendKeys(cont);
        mobilelh.clear();
        mobilelh.sendKeys(mobi);
        maillh.clear();
        maillh.sendKeys(mail);
        Name_deal.sendKeys(Namedeal);
        valuedeal.sendKeys(Valuedeal);
        btnconvertdeal.click();
    }

}
