package Pages.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.helper.GenerateData;
import webdriver.helper.Link;

public class addcontactPage {
    @FindBy(id = "btn-add-data")
    public WebElement btnadd1;

    @FindBy(id = "add-button-Contact")
    public WebElement btnaddcontact;

    @FindBy(id = "btn-add-contact-popup")
    public WebElement Savecontact;

    @FindBy(xpath = "//*[@id='add-Contacts']/div[1]/div[2]/div[3]/button[1]")
    public WebElement btnClose;

    @FindBy(id = "contact-inputFullName")
    public WebElement namecontact;

    @FindBy(id = "contact-inputPhone_0")
    public WebElement phonecontact;

    @FindBy(id = "contact-inputEmail_0")
    public WebElement emailcontact;

    @FindBy(xpath = "//*[@id='add-lead-email']/li/div[1]/div/input[2]")
    public WebElement webcontact1;

    @FindBy(xpath = "//*[@id='add-contact-fanpage']/li/div[1]/div/input[2]")
    public WebElement fancontact;

    @FindBy(xpath = "/html/body/div[11]/div/div/div[3]/button[2]")
    public WebElement share;

    @FindBy(xpath = "")
    public WebElement contacttype;

    @FindBy(xpath = "/html/body/div[1]/form/div[1]/div[2]/div[2]/div[1]/div[1]/div[8]/div/div/span/span")
    public WebElement inputvalue;

    @FindBy(xpath = ".//*[@id='ContactType_listbox']//li[2]")
    public WebElement inputclue;

    @FindBy(xpath = "#select2-Enterprise0-container > .select2-selection__placeholder")
    public WebElement dropacc;

    @FindBy(xpath = ".//*[@id='select2-Enterprise0-results']//li[3]")
    public WebElement valueacc;

    WebDriver driver;
    WebDriverWait wait;
    Link links;

    public addcontactPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 200);
        PageFactory.initElements(driver, this);
    }

    public void addcontact(String name, String Phone, String Mail, String Web, String Fan) {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.elementToBeClickable(btnadd1));
        btnadd1.click();
        btnaddcontact.click();
        wait.until(ExpectedConditions.elementToBeClickable(namecontact));
        namecontact.sendKeys(name);
        phonecontact.sendKeys(Phone);
        emailcontact.sendKeys(Mail);
        wait.until(ExpectedConditions.elementToBeClickable(webcontact1));
        webcontact1.sendKeys(Web);
        wait.until(ExpectedConditions.elementToBeClickable(fancontact));
        fancontact.sendKeys(Fan);
    }
    public void contactclue(){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.elementToBeClickable(contacttype));
        contacttype.click();
        inputclue.click();
        dropacc.click();
        valueacc.click();
    }
    public  void savecontact(){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.elementToBeClickable(Savecontact));
        Savecontact.click();
    }

}