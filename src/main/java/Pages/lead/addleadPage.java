package Pages.lead;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.helper.GenerateData;
import webdriver.helper.Link;

import java.util.concurrent.TimeUnit;

public class addleadPage {

    @FindBy(id = "btn-add-data")
    @CacheLookup
    public WebElement btnadd;

    @FindBy(id = "add-button-Lead")
    @CacheLookup
    public WebElement btnaddLead;

    @FindBy(id = "lead-inputFullName")
    @CacheLookup
    public WebElement NameLeadID;

    @FindBy(id = "lead-inputPhone_0")
    @CacheLookup
    public WebElement PhoneLeadID;

    @FindBy(id = "lead-inputEmail_0")
    @CacheLookup
    public WebElement MailLeadID;

    @FindBy(name = "website_0")
    @CacheLookup
    public WebElement WebLeadID;

    @FindBy(name = "fanpage_0")
    @CacheLookup
    public WebElement FanLeadID;

    @FindBy(xpath = "//*[@id='modal-add-lead-content']/div[2]/div[1]/form/div[1]/div[6]/div/div[1]")
    @CacheLookup
    public WebElement NeedLeadID;

    @FindBy(xpath = "/html/body/div[1]/div[7]/div[1]/div/div[2]/div[2]/div[1]/form/div[1]/div[7]/div/div/div/div/span[1]")
    public WebElement clearneedlead;

    @FindBy(xpath =".//*[@id='NeedIDDrop_listbox']//li[7]")
    @CacheLookup
    public WebElement Need;

    @FindBy(css = "#btn-add-popup > span")
    @CacheLookup
    public WebElement SaveLead;

    @FindBy(xpath = "//*[@id='modal-add-lead-content']/div[3]/button[1]")
    @CacheLookup
    public WebElement btcancel;

    @FindBy(xpath = "//td[2]/div/a")
    public WebElement LeadDetail;

    @FindBy(xpath = "//div[@id='LeadDetail']/div[4]/section/div/div/div/div/div/div/div[2]/div/div/div/div/a/i")
    @CacheLookup
    public WebElement editbtlead;

    @FindBy(xpath = "//*[@id='modal-add-lead-content']/div[2]/div[1]/form/div[1]/div[2]/div/div")
    public WebElement errornamelead;

    @FindBy(css = "#add-lead-phone > .data-pipeline > div:nth-child(4) > .error")
    public WebElement errorphonelead;

    @FindBy(css = "#add-lead-phone > .data-pipeline > .error:nth-child(3)")
    public WebElement errorphonelead1;

    @FindBy(css = ".padding-r-0 > #add-lead-email div:nth-child(3) > .error")
    public WebElement errormaillead;

    @FindBy(xpath = "//*[@id='add-lead-email']/div/div[2]")
    public  WebElement errormaillead1;

    @FindBy(xpath = "//*[@id='modal-add-lead-content']/div[2]/div[1]/form/div[1]/div[6]/div/div[2]")
    public WebElement errorneedlead;

    @FindBy(css = ".content-item-popup:nth-child(5) .add-lead > #add-lead-email .error")
    public  WebElement errorweblead;

    @FindBy(css = ".content-item-popup:nth-child(6) #add-lead-email .error")
    public  WebElement errorfanlead;

    @FindBy(css = ".content-item-popup:nth-child(5) .add-lead > #add-lead-email .form-control")
    public  WebElement editweblead;

    @FindBy(css = ".content-item-popup:nth-child(6) #add-lead-email .form-control")
    public WebElement editfanlead;

    @FindBy(css = ".bootbox-body > .crm-font-12")
    public WebElement pupopcoincide;

    WebDriver driver;
    WebDriverWait wait;
    Link links;

    public addleadPage(WebDriver driver)
    {
        this.driver =driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void addlead1(String nameLead, String PhoneLead, String Maillead, String WebLead, String FanLead) throws Throwable{
        Thread.sleep(1000);
        btnadd.click();
        btnaddLead.click();
        Thread.sleep(2000);
        NameLeadID.sendKeys(nameLead);
        PhoneLeadID.sendKeys(PhoneLead);
        MailLeadID.sendKeys(Maillead);
        Thread.sleep(2000);
        WebLeadID.sendKeys(WebLead);
        Thread.sleep(2000);
        FanLeadID.sendKeys(FanLead);
    }

    public void addlead2(String nameLead, String PhoneLead, String Maillead, String WebLead, String FanLead) throws Throwable {
        Thread.sleep(1000);
        btnadd.click();
        btnaddLead.click();
        Thread.sleep(2000);
        NameLeadID.sendKeys(nameLead);
        PhoneLeadID.sendKeys(PhoneLead);
        MailLeadID.sendKeys(Maillead);
        Thread.sleep(1000);
        NeedLeadID.click();
        Thread.sleep(3000);
        Need.click();
        Thread.sleep(1000);
        WebLeadID.sendKeys(WebLead);
        Thread.sleep(1000);
        FanLeadID.sendKeys(FanLead);
    }
    public void editlead(String nameLead, String PhoneLead, String Maillead, String WebLead, String FanLead) throws Throwable{
        Thread.sleep(2000);
        NameLeadID.clear();
        NameLeadID.sendKeys(nameLead);
        PhoneLeadID.clear();
        PhoneLeadID.sendKeys(PhoneLead);
        MailLeadID.clear();
        MailLeadID.sendKeys(Maillead);
        editweblead.clear();
        editweblead.sendKeys(WebLead);
        editfanlead.clear();
        editfanlead.sendKeys(FanLead);
    }
    public void editleadweb( String WebLead, String FanLead) throws Throwable{
        Thread.sleep(4000);
        editweblead.clear();
        editweblead.sendKeys(WebLead);
        editfanlead.clear();
        editfanlead.sendKeys(FanLead);
    }
    public void editleadneed(String nameLead, String PhoneLead, String Maillead, String WebLead, String FanLead) throws Throwable{
        Thread.sleep(2000);
        NameLeadID.clear();
        NameLeadID.sendKeys(nameLead);
        Thread.sleep(500);
        PhoneLeadID.clear();
        PhoneLeadID.sendKeys(PhoneLead);
        MailLeadID.clear();
        MailLeadID.sendKeys(Maillead);
        editweblead.clear();
        editweblead.sendKeys(WebLead);
        editfanlead.clear();
        editfanlead.sendKeys(FanLead);
        {
            WebElement element = NeedLeadID;
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        //clearneedlead.click();
        NeedLeadID.click();
        Thread.sleep(4000);
        Need.click();
    }
    public void addlead() throws Throwable{
        Thread.sleep(1000);
        btnadd.click();
        btnaddLead.click();
    }
    public void btsavelead ()
    {
        SaveLead.click();
    }
    public void btcancel()
    {
        btcancel.click();
    }
    public void editlead () throws Throwable
    {
        Thread.sleep(1000);
        LeadDetail.click();
        editbtlead.click();
    }
    public boolean isDisplayed() {
        if (links.URL_dashboard.equals(driver.getCurrentUrl())) {
            return true;
        } else {
            return false;
        }
    }
}
