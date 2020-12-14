package stepdefinition.Setting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import stepdefinition.Base.Basetest;
import Pages.login.LoginPage;
import webdriver.helper.GenerateData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Pipeline extends Basetest {
    LoginPage loginPg;
    GenerateData gen = new GenerateData();

    public void Login1(String User, String Pass) throws Throwable{
        //Mở web
        loginPg = new LoginPage(driver);
        loginPg.login1(User, Pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Check addmin có quyền thiết lập Pipeline
    @Test
    public void TC_Pipeline_01() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        driver.findElement(By.xpath("//*[@id='ember18']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[3]/a/i")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.xpath("//*[@id='add-protection-policy']/div[1]/div[1]/span")).getText(), is("Thêm pipeline lead mới"));
        driver.findElement(By.xpath("//*[@id='txtPipelineName']")).sendKeys(" Lead test 1");
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[4]/div[5]/a")).click();
        driver.findElement(By.cssSelector("#pipeline-editdata-4 > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")).sendKeys("L1.1");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div/div[4]/div[2]/div/div[1]/div[2]/div[1]/input[2]")).sendKeys(" Gọi điện hẹn KH");
        driver.findElement(By.cssSelector("div.form-control > div:nth-child(1) > input:nth-child(2)")).click();
        driver.findElement(By.xpath(".//*[@id='send-pipeline-4_listbox']/li[1]")).click();
        driver.findElement(By.cssSelector("#pipeline-editdata-4 > div:nth-child(3) > div:nth-child(1) > i:nth-child(1)")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/button[2]")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Lưu dữ liệu thành công!"));
    }
    //Check addmin có quyền xóa Pipeline chưa phát sinh DL
    @Test
    public void TC_Pipeline_02() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        driver.findElement(By.xpath("//*[@id='ember18']")).click();
        Thread.sleep(3000);
        {
            WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[3]/div/div[1]/h5"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[3]/div/ul/li[2]/a/i")).click();
        driver.findElement(By.xpath("/html/body/div[10]/div/div/div[3]/button[2]")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Xóa bộ pipeline thành công!"));
    }
    //Check quyền xóa Pipeline đã phát sinh DL
    @Test
    public void TC_Pipeline_03() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        driver.findElement(By.xpath("//*[@id='ember18']")).click();
        Thread.sleep(3000);
        {
            WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[1]/div"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[1]/div/ul/li[2]/a/i")).click();
        driver.findElement(By.xpath("/html/body/div[10]/div/div/div[3]/button[2]")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Dữ liệu phát sinh không thể xóa bộ pipeline"));
    }
    //Check quyền xóa Pipeline mặc định
    @Test
    public void TC_Pipeline_04() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        driver.findElement(By.xpath("//*[@id='ember18']")).click();
        Thread.sleep(3000);
        {
            WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[2]/div"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[2]/div[1]/div[2]/div[1]/div[2]/ul/li[2]/div/ul/li[2]/a/i")).click();
        driver.findElement(By.xpath("/html/body/div[10]/div/div/div[3]/button[2]")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Pipeline mặc định không được xóa"));
    }
}
