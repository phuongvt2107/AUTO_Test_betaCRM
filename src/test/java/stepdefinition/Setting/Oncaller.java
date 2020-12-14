package stepdefinition.Setting;

import Pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import stepdefinition.Base.Basetest;
import webdriver.helper.GenerateData;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Oncaller extends Basetest {
    LoginPage loginPg;
    GenerateData gen = new GenerateData();

    public void Login1(String User, String Pass) throws Throwable{
        //Mở web
        loginPg = new LoginPage(driver);
        loginPg.login1(User, Pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Check thêm mới liên kết BS thành công
    @Test
    public void TC_addBS_01() throws Throwable {
        Login1("adminerp", "x3bestseller");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='ember142']/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='view-setting-caller-left']/div/button")).click();
        driver.findElement(By.xpath("//*[@id='justAnotherInputBoxList']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div/div[1]/div/div[2]/ul/li/span[2]")).click();
        driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]")).click();
        Thread.sleep(10000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Tạo tài khoản liên kết thành công."));
        //assertThat(driver.findElement(By.cssSelector(".bootbox-body")).getText(), is("Hệ thống đang tiến hành kết nối Onsales Caller.\\\\nVui lòng chờ hoàn tất quá trình để có thể tiếp tục\\\\nthiết lập."));
    }

    //Check thêm mới đã tồn tại
    @Test
    public void TC_addBS_02() throws Throwable {
        Login1("adminerp", "x3bestseller");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#ember145 > span:nth-child(1)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#view-setting-caller-left > div:nth-child(1) > button:nth-child(3)")).click();
        driver.findElement(By.xpath("//*[@id='justAnotherInputBoxList']")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[2]/div/div/div[1]/div/div[2]/ul/li/ul/li[2]/span[2]")).click();
        driver.findElement(By.cssSelector(".modal-lg > div:nth-child(1) > div:nth-child(3) > button:nth-child(2)")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Tài khoản liên kết đã tồn tại"));
    }

    //Check xóa BS thành công
    @Test
    public void TC_addBS_03() throws Throwable {
        Login1("adminerp", "x3bestseller");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#ember145 > span:nth-child(1)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#view-setting-caller-right > div:nth-child(1) > button:nth-child(3)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("#table-onsales-caller > tbody:nth-child(1) > tr:nth-child(2)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div/div[5]/table/tbody/tr[2]/td[5]/div/i")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[3]/button[2]")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Xóa tài khoản liên kết thành công"));
    }
    //Check add user thành công
    @Test
    public void TC_addUser_01() throws Throwable {
        Login1("adminerp", "x3bestseller");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#ember145 > span:nth-child(1)")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#view-setting-caller-right > div:nth-child(1) > button:nth-child(3)")).click();
        {
            WebElement element = driver.findElement(By.cssSelector("#table-onsales-caller > tbody:nth-child(1) > tr:nth-child(2)"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div/div[5]/table/tbody/tr[2]/td[5]/div/i")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div/div/div[3]/button[2]")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Xóa tài khoản liên kết thành công"));
    }
}
