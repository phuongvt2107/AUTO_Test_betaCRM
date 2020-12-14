package stepdefinition.account;

import Pages.login.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import stepdefinition.Base.Basetest;
import webdriver.helper.GenerateData;

import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class addaccount extends Basetest {
    LoginPage loginPg;
    GenerateData gen = new GenerateData();

    public void Login1(String User, String Pass) throws Throwable{
        //Mở web
        loginPg = new LoginPage(driver);
        loginPg.login1(User, Pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    // Check thêm liên hệ khi bỏ trống all trường  bắt buộc
    @Test
    public void TC_addaccount_1() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Contact")).click();
        driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".error-item-popup .error")).getText(), is("Dữ liệu không được để trống"));
    }

    // Check thêm liên hệ khi bỏ trống trường SĐT & Email
    @Test
    public void TC_addaccount_2() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Contact")).click();
        driver.findElement(By.id("contact-inputFullName")).sendKeys(gen.Name());
        driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup > .content-item-popup:nth-child(3) div:nth-child(4) > .error")).getText(), is("Dữ liệu không được để trống"));
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup div:nth-child(3) > .error")).getText(), is("Dữ liệu không được để trống"));
    }

    // Check thêm liên hệ khi nhập sai định dạng SĐT
    @Test
    public void TC_addaccount_3() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Contact")).click();
        driver.findElement(By.id("contact-inputFullName")).sendKeys(gen.Name());
        driver.findElement(By.id("contact-inputPhone_0")).sendKeys("sgfgh234235");
        driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup .error:nth-child(3)")).getText(), is("Vui lòng nhập đúng định dạng số điện thoại"));
        driver.findElement(By.id("contact-inputPhone_0")).clear();
        driver.findElement(By.id("contact-inputPhone_0")).sendKeys("vtphuong2107@gmail.com");
        driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup .error:nth-child(3)")).getText(), is("Vui lòng nhập đúng định dạng số điện thoại"));
    }
    // Check thêm liên hệ khi nhập sai định dạng email
    @Test
    public void TC_addaccount_4() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Contact")).click();
        driver.findElement(By.id("contact-inputFullName")).sendKeys(gen.Name());
        driver.findElement(By.id("contact-inputEmail_0")).sendKeys("sgfgh234235");
        driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup > .content-item-popup:nth-child(4) .multiline-wrap-new > .error")).getText(), is("Vui lòng nhập đúng định dạng email"));
        driver.findElement(By.id("contact-inputEmail_0")).clear();
        driver.findElement(By.id("contact-inputEmail_0")).sendKeys("vtphuong2107@gmail");
        driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup > .content-item-popup:nth-child(4) .multiline-wrap-new > .error")).getText(), is("Vui lòng nhập đúng định dạng email"));
    }
    // Check thêm liên hệ khi nhập trùng SĐT do mình quản lý
    @Test
    public void TC_addaccount_5() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Contact")).click();
        driver.findElement(By.id("contact-inputFullName")).sendKeys(gen.Name());
        driver.findElement(By.id("contact-inputPhone_0")).sendKeys("79756725539");
        driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
        Thread.sleep(10000);
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
        driver.findElement(By.cssSelector(".bootbox .rectangle-color-btn")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".title-add-contact")).getText(), is("Thêm mới liên hệ"));
    }
    // Check thêm liên hệ khi nhập trùng email do mình quản lý
    @Test
    public void TC_addaccount_6() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Contact")).click();
        driver.findElement(By.id("contact-inputFullName")).sendKeys(gen.Name());
        driver.findElement(By.id("contact-inputEmail_0")).sendKeys("vtphuong2107@gmail.com");
        driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
        Thread.sleep(10000);
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
        driver.findElement(By.cssSelector(".bootbox .rectangle-color-btn")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".title-add-contact")).getText(), is("Thêm mới liên hệ"));
    }
    // Check thêm liên hệ khi nhập trùng SĐT do người khác quản lý
    // Check thêm liên hệ khi nhập trùng email do người khác mình quản lý
    // Check thêm mới thành công liên hệ cá nhân
    @Test
    public void TC_addaccount_9() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Contact")).click();
        driver.findElement(By.id("contact-inputFullName")).sendKeys(gen.Name());
        driver.findElement(By.id("contact-inputPhone_0")).sendKeys(gen.Phone());
        driver.findElement(By.id("contact-inputEmail_0")).sendKeys(gen.Email());
        driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".ember-view > .crm-font-semibold")).getText(), is("Thông tin chi tiết"));
    }
    // Check thêm mới thành công liên hệ đầu mối
    @Test
    public void TC_addaccount_10() throws Throwable {
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Contact")).click();
        driver.findElement(By.id("contact-inputFullName")).sendKeys(gen.Name());
        driver.findElement(By.id("contact-inputPhone_0")).sendKeys(gen.Phone());
        driver.findElement(By.id("contact-inputEmail_0")).sendKeys(gen.Email());
        driver.findElement(By.xpath("/html/body/div[1]/form/div[1]/div[2]/div[2]/div[1]/div[1]/div[8]/div/div/span/span")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='ContactType_listbox']//li[2]")).click();
        driver.findElement(By.cssSelector("#select2-Enterprise0-container > .select2-selection__placeholder")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@id='select2-Enterprise0-results']//li[3]")).click();
            Thread.sleep(3000);
            driver.findElement(By.cssSelector("#btn-add-contact-popup > .btn-label")).click();
            Thread.sleep(3000);
            assertThat(driver.findElement(By.cssSelector(".ember-view > .crm-font-semibold")).getText(), is("Thông tin chi tiết"));
            Thread.sleep(10000);
            assertThat(driver.findElement(By.cssSelector(".mySlides:nth-child(1) > .col-md-6:nth-child(4) > .col-md-7 > .text-ellipsis")).getText(),is("Đầu mối liên hệ"));
        }
    }
//}
