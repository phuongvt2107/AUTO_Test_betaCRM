package Pages.lead;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.helper.Link;

public class DeleteLeadPage {
    @FindBy(css = ".navbar-primary-item-link > .fa-users")
    public WebElement menulead;

    @FindBy(css = "tr.ng-scope:nth-child(1) > td:nth-child(1) > div:nth-child(1) > label:nth-child(2)")
    public WebElement checkbox1;

    @FindBy(css = ".checkall > label:nth-child(2)")
    public WebElement checkboxall;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[4]/div/div[3]/div[1]/div[1]/button[3]")
    public WebElement btnDelete;

    @FindBy(xpath = "/html/body/div[10]/div/div/div[3]/button[2]")
    public WebElement btnok;

    @FindBy(xpath = "/html/body/div[10]/div/div/div[3]/button[1]")
            public WebElement btnabort;

    WebDriver driver;
    WebDriverWait wait;
    Link links;

    public DeleteLeadPage(WebDriver driver)
    {
        this.driver =driver;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void Deletelead (){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.elementToBeClickable(menulead));
        menulead.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkbox1));
        checkbox1.click();
        wait.until(ExpectedConditions.elementToBeClickable(btnDelete));
        btnDelete.click();
    }
    public void Deleteleadall () {
        wait.until(ExpectedConditions.elementToBeClickable(menulead));
        menulead.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkboxall));
        checkboxall.click();
        btnDelete.click();
    }
    public void confirm () throws Throwable{
        wait.until(ExpectedConditions.elementToBeClickable(btnok));
        btnok.click();
    }
    public void Abort () throws Throwable{
        wait.until(ExpectedConditions.elementToBeClickable(btnabort));
        btnabort.click();
    }
}
