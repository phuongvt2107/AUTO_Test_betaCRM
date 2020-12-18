package stepdefinition.Accout;

import Pages.login.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import stepdefinition.Base.Basetest;
import webdriver.helper.GenerateData;
import static org.junit.Assert.assertThat;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;

public class addaccount extends Basetest{
    LoginPage loginPg;
    GenerateData gen = new GenerateData();

    public void Login1(String User, String Pass) throws Throwable {
        //Mở web
        loginPg = new LoginPage(driver);
        loginPg.login1(User,Pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    // Check thêm Doanh nghiệp thất bại khi bỏ trống all trường  bắt buộc
    @Test
    public void Add_Contact_01() throws Throwable{
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Account")).click();
        driver.findElement(By.id("btn-add-deal-popup")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".error-item-popup .error")).getText(), is("Dữ liệu không được để trống"));
    }
    // Check thêm mới thành công Doanh nghiệp khi bỏ trống trường SĐT & Email
    @Test
    public void Add_Contact_02() throws Throwable{
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Account")).click();
        driver.findElement(By.id("account-inputBrandName")).sendKeys(gen.Name());
        driver.findElement(By.id("btn-add-deal-popup")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector(".ember-view > .crm-font-bold:nth-child(1)")).getText(), is("Thông tin chi tiết"));
    }
    // Check thêm Doanh nghiệp thất bại khi nhập sai định dạng SĐT
    @Test
    public void Add_Contact_03() throws Throwable{
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Account")).click();
        driver.findElement(By.id("account-inputBrandName")).sendKeys(gen.Name());
        driver.findElement(By.id("account-inputPhone-0")).sendKeys("dfhfg345");
        driver.findElement(By.id("btn-add-deal-popup")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".add-account-sum > #add-lead-phone .error:nth-child(3)")).getText(), is("Vui lòng nhập đúng định dạng số điện thoại"));
    }
    // Check thêm Doanh nghiệp thất bại khi nhập sai định dạng email
    @Test
    public void Add_Contact_04() throws Throwable{
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Account")).click();
        driver.findElement(By.id("account-inputBrandName")).sendKeys(gen.Name());
        //Thread.sleep(20000);
        driver.findElement(By.cssSelector(".content-item-popup:nth-child(5) > .input-field-popup > #add-lead-email .form-control")).sendKeys("dfhfg345");
        driver.findElement(By.id("btn-add-deal-popup")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".content-item-popup:nth-child(5) > .input-field-popup > #add-lead-email > .multiline-wrap-new > .error")).getText(), is("Vui lòng nhập đúng định dạng email"));
    }
    // Check thêm Doanh nghiệp thất bại khi nhập trùng Mã số thuế do mình quản lý
    @Test
    public void Add_Contact_05() throws Throwable{
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Account")).click();
        driver.findElement(By.id("account-inputBrandName")).sendKeys(gen.Name());
        driver.findElement(By.id("account-inputPhone-0")).sendKeys(gen.Phone());
        driver.findElement(By.cssSelector(".group-item-popup:nth-child(1) > .content-item-popup:nth-child(6) > .input-field-popup > .ng-empty")).sendKeys("111");
        driver.findElement(By.id("btn-add-deal-popup")).click();
        Thread.sleep(5000);
        assertThat(driver.findElement(By.cssSelector(".bootbox-body > .crm-font-12")).getText(), is("Trùng dữ liệu khách hàng. Bạn không thể tạo mới Doanh nghiệp nếu mã số thuế bị trùng."));
    }
    // Check thêm Doanh nghiệp thất bại khi nhập trùng Mã số thuế do do người khác quản lý
    @Test
    public void Add_Contact_06() throws Throwable{
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Account")).click();
        driver.findElement(By.id("account-inputBrandName")).sendKeys(gen.Name());
        driver.findElement(By.id("account-inputPhone-0")).sendKeys(gen.Phone());
        driver.findElement(By.cssSelector(".group-item-popup:nth-child(1) > .content-item-popup:nth-child(6) > .input-field-popup > .ng-empty")).sendKeys("7899");
        driver.findElement(By.id("btn-add-deal-popup")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".bootbox-body > .crm-font-12")).getText(), is("Trùng dữ liệu khách hàng. Bạn không thể tạo mới Doanh nghiệp nếu mã số thuế bị trùng."));
    }
    // Check thêm mới thành công Doanh nghiệp
    @Test
    public void Add_Contact_07() throws Throwable{
        Login1("vtphuong2107@gmail.com", "123456789");
        driver.findElement(By.id("btn-add-data")).click();
        driver.findElement(By.id("add-button-Account")).click();
        driver.findElement(By.id("account-inputBrandName")).sendKeys(gen.Name());
        driver.findElement(By.id("account-inputPhone-0")).sendKeys(gen.Phone());
        driver.findElement(By.cssSelector(".content-item-popup:nth-child(5) > .input-field-popup > #add-lead-email .form-control")).sendKeys(gen.Email());
        driver.findElement(By.cssSelector(".group-item-popup:nth-child(1) > .content-item-popup:nth-child(6) > .input-field-popup > .ng-empty")).sendKeys(gen.Phone());
        driver.findElement(By.id("btn-add-deal-popup")).click();
        Thread.sleep(3000);
        assertThat(driver.findElement(By.cssSelector(".ember-view > .crm-font-bold:nth-child(1)")).getText(), is("Thông tin chi tiết"));
    }
}
