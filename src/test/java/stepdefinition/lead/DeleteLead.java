package stepdefinition.lead;

import Pages.lead.DeleteLeadPage;
import Pages.lead.addleadPage;
import Pages.login.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import stepdefinition.Base.Basetest;
import webdriver.helper.GenerateData;
import webdriver.helper.Link;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DeleteLead extends Basetest {
    LoginPage loginPg;
    DeleteLeadPage dleadPg;
    Link links;
    private Object String;
    private long seconds;

    // User có quyền xóa 1 lead
    @Test
    public void TC_deletelead_01() throws Throwable {
        loginPg = new LoginPage(driver);
        dleadPg =new DeleteLeadPage(driver);
        loginPg.login1(User, Pass);
        Thread.sleep(1000);
        dleadPg.Deletelead();
        dleadPg.confirm();
        assertThat(driver.findElement(By.cssSelector(".toast-title")).getText(), is("Thành công"));
    }
    // User có quyền xóa nhiều lead (all lead trên 1 trang)
    @Test
    public void TC_deletelead_02() throws Throwable {
        loginPg = new LoginPage(driver);
        dleadPg =new DeleteLeadPage(driver);
        loginPg.login1(User, Pass);
        Thread.sleep(1000);
        dleadPg.Deleteleadall();
        dleadPg.confirm();
        assertThat(driver.findElement(By.cssSelector(".toast-title")).getText(), is("Thành công"));
    }
    // User có không quyền xóa
    @Test
    public void TC_deletelead_03() throws Throwable {
        loginPg = new LoginPage(driver);
        dleadPg =new DeleteLeadPage(driver);
        loginPg.login1(User, Pass);
        Thread.sleep(1000);
        dleadPg.menulead.click();
        Thread.sleep(10000);
        dleadPg.checkbox1.click();
        Thread.sleep(3000);
        String icondelete = "/html/body/div[1]/div[4]/div[4]/div/div[3]/div[1]/div[1]/button[3]";
        Assert.assertNotEquals(icondelete, String);
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("")));
    }
}
