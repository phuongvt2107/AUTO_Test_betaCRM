package stepdefinition.Setting;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.FindsByLinkText;
import stepdefinition.Base.Basetest;
import Pages.login.LoginPage;
import webdriver.helper.GenerateData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Hanmuc extends Basetest {
    LoginPage loginPg;
    GenerateData gen = new GenerateData();

    public void Login1(String User, String Pass) throws Throwable{
        //Mở web
        loginPg = new LoginPage(driver);
        loginPg.login1(User, Pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Check addmin quyền thiết lập Hạn mức bảo hộ
    @Test
    public void TC_Han_muc_01() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        driver.findElement(By.cssSelector("#ember15 > span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='settingMaxDeal']/div[2]/div/div/div[4]/div/a[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='settingMaxDeal']/div[2]/div/div/div[3]/div/div[4]/div[1]/div/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='MaxDealOrganizationUnit4_listbox']//li[2]")).click();
        driver.findElement(By.xpath("//*[@id='DealValue0']")).clear();
        driver.findElement(By.xpath("//*[@id='DealValue0']")).sendKeys("500");
        driver.findElement(By.xpath("//*[@id='TimeLead0']")).clear();
        driver.findElement(By.xpath("//*[@id='TimeLead0']")).sendKeys("30");
        driver.findElement(By.xpath("//*[@id='TimeDeal0']")).clear();
        driver.findElement(By.xpath("//*[@id='TimeDeal0']")).sendKeys("30");
        driver.findElement(By.xpath("//*[@id='settingMaxDeal']/div[2]/div/div/div[3]/div/div[4]/div[5]/div/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='UserIdMaxDeal4_listbox']//li[1]")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[1]/div[2]/div/div/div[3]/div/div[4]/div[7]/div/div[1]/i")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Thiết lập hạn mức bảo hộ thành công."));
    }
    //Check addmin sửa Hạn mức bảo hộ vừa thêm
    @Test
    public void TC_Han_muc_02() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        driver.findElement(By.cssSelector("#ember15 > span")).click();
        {
            WebElement element = driver.findElement(By.xpath("//*[@id='settingMaxDeal']/div[2]/div/div/div[3]/div/div[4]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.border-b-max-deal:nth-child(4) > div:nth-child(7) > div:nth-child(1) > i:nth-child(1)")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[1]/div[2]/div/div/div[3]/div/div[4]/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[1]/div[2]/div/div/div[3]/div/div[4]/div[2]/input")).sendKeys("600");
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[1]/div[2]/div/div/div[3]/div/div[4]/div[3]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[1]/div[2]/div/div/div[3]/div/div[4]/div[3]/input")).sendKeys("50");
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[1]/div[2]/div/div/div[3]/div/div[4]/div[4]/input")).clear();
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[1]/div[2]/div/div/div[3]/div/div[4]/div[4]/input")).sendKeys("50");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[4]/div[1]/div[2]/div/div/div[3]/div/div[4]/div[7]/div/div[1]")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Thiết lập hạn mức bảo hộ thành công."));
    }
    //Check addmin xóa Hạn mức bảo hộ vừa thêm (Chưa phát sinh DL)
    @Test
    public void TC_Han_muc_03() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        driver.findElement(By.cssSelector("#ember15 > span")).click();
        {
            WebElement element = driver.findElement(By.xpath("//*[@id='settingMaxDeal']/div[2]/div/div/div[3]/div/div[4]"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("div.border-b-max-deal:nth-child(4) > div:nth-child(7) > div:nth-child(1) > i:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".modal-lg .rectangle-color-btn")).click();
        Thread.sleep(4000);
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Xóa dữ liệu thành công"));
    }
        //Check addmin xóa Hạn mức bảo hộ đã phát sinh DL
        @Test
        public void TC_Han_muc_04() throws Throwable{
            Login1("vtphuong2107@gmail.com", "123456789");
            driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
            driver.findElement(By.cssSelector("#ember15 > span")).click();
            {
                WebElement element = driver.findElement(By.cssSelector("div.border-b-max-deal:nth-child(1)"));
                Actions builder = new Actions(driver);
                builder.moveToElement(element).perform();
            }
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("i.tooltipstered:nth-child(2)")).click();
            driver.findElement(By.cssSelector(".modal-lg .rectangle-color-btn")).click();
            Thread.sleep(3000);
            assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Đã phát sinh dữ liệu liên quan, không được phép xóa"));
    }
    //Check Useer không có quyền thiết lập Hạn mức
    @Test
    public void TC_Han_muc_05() throws Throwable{
        Login1("nguyenmanhcuong120894@gmail.com", "123456789");
        driver.findElement(By.cssSelector(".navbar-primary-item-link > .fa-cog")).click();
        driver.findElement(By.cssSelector("#ember15 > span")).click();
        List<WebElement> elements = ((FindsByLinkText)driver).findElementsByLinkText("+ Thêm hạn mức bảo hộ");
        Assert.assertNotEquals(1, elements.size());
    }
}
