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

public class searchLead extends Basetest {
    LoginPage loginPg;
    GenerateData gen = new GenerateData();

    public void Login1(String User, String Pass) throws Throwable{
        //Mở web
        loginPg = new LoginPage(driver);
        loginPg.login1(User,Pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // Lọc có kết quả
    @Test
    public void TC_boloc_01() throws Throwable {
        Login1("hangqt", "x3bestseller");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-users")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#filter-column-select span")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".isNotActive:nth-child(1)")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]/div/div/div[3]/div/div/ul/li[1]/div[1]/div/tags-input/div/div/input")).sendKeys("Test");
        driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]/div/div/div[3]/div/div/ul/li[1]/div[1]/div/tags-input/div/div/input")).sendKeys(Keys.ENTER);
        driver.findElement(By.id("apply-filter-btn")).click();
    }
}
