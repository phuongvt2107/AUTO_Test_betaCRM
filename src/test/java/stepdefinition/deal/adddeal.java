package stepdefinition.deal;

import Pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import stepdefinition.Base.Basetest;
import webdriver.helper.GenerateData;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class adddeal extends Basetest {
    LoginPage loginPg;
    GenerateData gen = new GenerateData();

    public void Login1(String User, String Pass) throws Throwable{
        //Mở web
        loginPg = new LoginPage(driver);
        loginPg.login1(User, Pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // Check thêm Deal thất bại khi bỏ trống trường bắt buộc
    @Test
    public void TC_Deal_1() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Deal")).click();
        Thread.sleep(10000);
        driver.findElement(By.cssSelector(".modal-content:nth-child(3) #btn-add-deal-popup > span")).click();
    }
    // Check thêm Deal thất bại khi bỏ trống Liên hệ
    @Test
    public void TC_Deal_2() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Deal")).click();
        driver.findElement(By.id("txtDealName")).sendKeys(gen.Name());
        driver.findElement(By.id("deal-value-currency")).sendKeys(gen.Phone());
        Thread.sleep(10000);
        driver.findElement(By.cssSelector(".modal-content:nth-child(3) #btn-add-deal-popup > span")).click();
    }

    // Check thêm Deal thành công
    @Test
    public void TC_Deal_3() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Deal")).click();
        driver.findElement(By.id("txtDealName")).sendKeys(gen.Name());
        Thread.sleep(3000);
        driver.findElement(By.id("deal-value-currency")).sendKeys(gen.Phone());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='get-value-contact']/div/div")).click();
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.xpath("//ul[@id='ListContact_listbox']//li"));
        // Lấy giá trị của dropdown
        for (WebElement ele : list) {
            System.out.println("Values " + ele.getAttribute("innerHTML"));
            if (ele.getAttribute("innerHTML").contains("JavaScript"))
            {
                ele.click();
                break;
            }
            ele.click();
            break;
        }
        driver.findElement(By.cssSelector(".modal-content:nth-child(3) #btn-add-deal-popup > span")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".info-lead-state-title")).getText(), is("Trạng thái deal"));
        assertThat(driver.getTitle(), is("CRM | Chi tiết Deal"));
    }
}
