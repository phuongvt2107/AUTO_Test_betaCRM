package stepdefinition.lead;

import Pages.lead.FilterPage;
import Pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepdefinition.Base.Basetest;
import webdriver.helper.Link;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FilterLead extends Basetest {
    LoginPage loginPg;
    FilterPage filterPg;
    Link links;
    // Lọc có kết quả Lead với trường tên Lead
    @Test
    public void TC_filterlead_01() throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        filterPg =new FilterPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        Thread.sleep(15000);
        filterPg.filterNameLead("Lead");
        Thread.sleep(20000);
        //wait.until(ExpectedConditions.elementToBeClickable(filterPg.LeadDetail));
        Assert.assertTrue(filterPg.bodyHasKeyword("Lead"));
    }
    // Lọc có tất cả kết quả
    @Test
    public void TC_filterlead_02() throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        filterPg =new FilterPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        Thread.sleep(15000);
        filterPg.filterall("Lead");
        Thread.sleep(10000);
        //wait.until(ExpectedConditions.elementToBeClickable(filterPg.LeadDetail));
        //Assert.assertTrue(filterPg.bodyHasKeyword("Lead"));
    }
}
