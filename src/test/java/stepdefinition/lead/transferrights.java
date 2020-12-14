package stepdefinition.lead;

import Pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import stepdefinition.Base.Basetest;
import webdriver.helper.GenerateData;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class transferrights extends Basetest {
    LoginPage loginPg;
    GenerateData gen = new GenerateData();

    public void Login1(String User, String Pass) throws Throwable{
        //Mở web
        loginPg = new LoginPage(driver);
        loginPg.login1(User,Pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    //Check chuyển quyền 1 lead
    @Test
    public void TC_transferrights_01 () throws Throwable{
        Login1("hangqt", "x3bestseller");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-users")).click();
        driver.findElement(By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(1) > div:nth-child(1) > label:nth-child(2)")).click();
        //Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div/div[3]/div[1]/div[1]/button[1]")).click();
        driver.findElement(By.cssSelector("#select2-GetReceiver-container")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@id='select2-GetReceiver-results']//li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".footer-pipeline > button:nth-child(2)")).click();
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Chuyển quyền thành công."));
    }
    //Check chuyển quyền 1 lead thất bại do trùng người sở hữu
    @Test
    public void TC_transferrights_02 () throws Throwable{
        Login1("hangqt", "x3bestseller");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-users")).click();
        driver.findElement(By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(1) > div:nth-child(1) > label:nth-child(2)")).click();
        //Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div/div[3]/div[1]/div[1]/button[1]")).click();
        driver.findElement(By.cssSelector("#select2-GetReceiver-container")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@id='select2-GetReceiver-results']//li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".footer-pipeline > button:nth-child(2)")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.cssSelector(".row:nth-child(1) > .col-md-12 > .crm-font-12")).getText(), is("Trùng nhân viên nhận quyền quản lý dưới đây:"));
    }
    //Check chuyển quyền nhiều lead (all lead/ 1 trang)
    @Test
    public void TC_transferrights_03 () throws Throwable{
        Login1("hangqt", "x3bestseller");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-users")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#filter-column-select span")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".btn-delete-filter")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]/div/div/div[3]/div/div/ul/li[9]/label")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]/div/div/div[3]/div/div/ul/li[9]/div[1]/div/tags-input/div/div/input")).sendKeys("Admin");
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]/div/div/div[3]/div/div/ul/li[9]/div[1]/div/tags-input/div/div/input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("apply-filter-btn")).click();
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-users")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector(".checkall > label:nth-child(2)")).click();
        //Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div/div[3]/div[1]/div[1]/button[1]")).click();
        driver.findElement(By.cssSelector("#select2-GetReceiver-container")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@id='select2-GetReceiver-results']//li[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".footer-pipeline > button:nth-child(2)")).click();
        Thread.sleep(1000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Chuyển quyền thành công."));
    }
}
