package Pages.lead;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.helper.Link;

import java.security.Key;
import java.util.List;

public class FilterPage {
    @FindBy(xpath = "//*[@id='filter-column-select']/button")
    public WebElement btnfilter;

    @FindBy(css = ".isNotActive:nth-child(1)")
    public WebElement cboxName;

    @FindBy(css = ".isActive > label")
    public WebElement discboxName;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div[1]/div[1]/div/div/div[3]/div/div/ul/li[1]/div[1]/div/tags-input/div/div/input")
    public WebElement senName;

    @FindBy(id = "apply-filter-btn")
    public WebElement apply;

    @FindBy(xpath = "//td[2]/div/a")
    public WebElement LeadDetail;

    WebDriver driver;
    WebDriverWait wait;
    Link links;

    public FilterPage(WebDriver driver)
    {
        this.driver =driver;
        wait = new WebDriverWait(driver, 200);
        PageFactory.initElements(driver, this);
    }

    public void filterNameLead(String keyword) throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.elementToBeClickable(btnfilter));
        btnfilter.click();
        wait.until(ExpectedConditions.elementToBeClickable(cboxName));
        cboxName.click();
        wait.until(ExpectedConditions.elementToBeClickable(senName));
        senName.sendKeys(keyword);
        senName.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(apply));
        apply.click();
    }

    public void filterall(String keyword) throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        wait.until(ExpectedConditions.elementToBeClickable(btnfilter));
        btnfilter.click();
        wait.until(ExpectedConditions.elementToBeClickable(discboxName));
        discboxName.click();
        wait.until(ExpectedConditions.elementToBeClickable(apply));
        apply.click();
    }

    public boolean bodyHasKeyword(String keyword) {
        List<WebElement> paragraphs = driver.findElements(By.xpath("//*[@id='gridCustomer']/div[2]/table/tbody"));
        for (int i = 0; i < paragraphs.size(); i++) {
            String p = paragraphs.get(i).getText().toLowerCase();
            if (!(p.contains(keyword.toLowerCase()))) {
                return false;
            }
        }
        return true;
    }
}
