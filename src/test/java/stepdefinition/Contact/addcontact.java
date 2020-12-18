package stepdefinition.Contact;

import Pages.lead.addleadPage;
import Pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepdefinition.Base.Basetest;
import webdriver.helper.GenerateData;
import Pages.contact.addcontactPage;

import static org.junit.Assert.assertThat;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;

public class addcontact extends Basetest {
    LoginPage loginPg;
    addcontactPage addcontPg;

    // Check thêm liên hệ khi bỏ trống all trường  bắt buộc
    @Test
    public void TC_addaccount_1() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact("","","",Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-item-popup .error")));
        assertThat(driver.findElement(By.cssSelector(".error-item-popup .error")).getText(), is("Dữ liệu không được để trống"));
    }
    //Thêm Liên hệ khi bỏ trống trường tên Liên hệ
    @Test
    public void TC_addaccount_2() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact("",Phone,Mail,Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".error-item-popup .error")));
        assertThat(driver.findElement(By.cssSelector(".error-item-popup .error")).getText(), is("Dữ liệu không được để trống"));
    }
    // Check thêm liên hệ khi bỏ trống trường SĐT & Email
    @Test
    public void TC_addaccount_3() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,"","",Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".detail-field > .group-item-popup > .content-item-popup:nth-child(3) div:nth-child(4) > .error")));
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup > .content-item-popup:nth-child(3) div:nth-child(4) > .error")).getText(), is("Dữ liệu không được để trống"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".detail-field > .group-item-popup div:nth-child(3) > .error")));
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup div:nth-child(3) > .error")).getText(), is("Dữ liệu không được để trống"));
    }

    // Check thêm liên hệ khi nhập sai định dạng SĐT
    @Test
    public void TC_addaccount_4() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,"abhw","",Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".detail-field > .group-item-popup .error:nth-child(3)")));
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup .error:nth-child(3)")).getText(), is("Vui lòng nhập đúng định dạng số điện thoại"));
    }
    // Check thêm liên hệ khi nhập sai định dạng email
    @Test
    public void TC_addaccount_5() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,"34744@gmail.",Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".detail-field > .group-item-popup > .content-item-popup:nth-child(4) .multiline-wrap-new > .error")));
        assertThat(driver.findElement(By.cssSelector(".detail-field > .group-item-popup > .content-item-popup:nth-child(4) .multiline-wrap-new > .error")).getText(), is("Vui lòng nhập đúng định dạng email"));
    }
    // Check thêm liên hệ khi nhập sai định dạng Web
    @Test
    public void TC_addaccount_6() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,Mail,"hanni@@@", Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='add-lead-email']/li/div[2]")));
        assertThat(driver.findElement(By.xpath(".//*[@id='add-lead-email']/li/div[2]")).getText(), is("Vui lòng nhập đúng định dạng website"));
    }
    // Check thêm liên hệ khi nhập sai định dạng Fan
    @Test
    public void TC_addaccount_7() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,Mail,Web, "hanni@@@");
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='add-contact-fanpage']/li/div[2]")));
        assertThat(driver.findElement(By.xpath("//*[@id='add-contact-fanpage']/li/div[2]")).getText(), is("Vui lòng nhập đúng định dạng fanpage"));
    }
    // Check thêm liên hệ khi nhập trùng SĐT do mình quản lý
    @Test
    public void TC_addaccount_8() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,"79756725539",Mail,Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("..bootbox .modal-title")));
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
    }
    // Check thêm liên hệ khi nhập trùng email do mình quản lý
    @Test
    public void TC_addaccount_9() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,"vtphuong@gmail.com",Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootbox .modal-title")));
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
    }
    // Check thêm liên hệ khi nhập trùng web do mình quản lý
    @Test
    public void TC_addaccount_10() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,Mail,"phuongvu.vn", Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootbox .modal-title")));
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
    }
    // Check thêm liên hệ khi nhập trùng fan do mình quản lý
    @Test
    public void TC_addaccount_11() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,Mail,Web, "phuongvu.vn");
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootbox .modal-title")));
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
    }
    // Check lấy quyền chi sẻ DL khi nhập trùng DL do mình quản lý
    @Test
    public void TC_addaccount_12() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,"79756725539",Mail,Web, Web);
        addcontPg.savecontact();
        addcontPg.share.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//*[@id='contact']/div[3]/section/div/div/div[1]/div/div[2]/div/div[1]")));
        assertThat(driver.findElement(By.cssSelector("//*[@id='contact']/div[3]/section/div/div/div[1]/div/div[2]/div/div[1]")).getText(), is("Thông tin chi tiết"));
    }
    // Check thêm liên hệ khi nhập trùng SĐT do người khác quản lý
    @Test
    public void TC_addaccount_13() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(User, Pass);
        addcontPg.addcontact(Name,"45766687",Mail,Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootbox .modal-title")));
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
    }
    // Check thêm liên hệ khi nhập trùng email do người khác quản lý
    @Test
    public void TC_addaccount_14() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,"hanna@gmail.com",Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootbox .modal-title")));
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
    }
    // Check thêm liên hệ khi nhập trùng Web do người khác quản lý
    @Test
    public void TC_addaccount_16() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,Mail,"nanaha.vn", Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootbox .modal-title")));
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
    }
    // Check thêm liên hệ khi nhập trùng fan do người khác quản lý
    @Test
    public void TC_addaccount_17() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,Mail,Web, "nanaha.vn");
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".bootbox .modal-title")));
        assertThat(driver.findElement(By.cssSelector(".bootbox .modal-title")).getText(), is("Thông báo trùng"));
    }
    // Check thêm liên hệ không thành công khi click button Huy
    @Test
    public void TC_addaccount_18() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,Mail,Web, Web);
        addcontPg.btnClose.click();

    }
    // Check thêm mới thành công liên hệ cá nhân
    @Test
    public void TC_addaccount_19() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,Mail,Web, Web);
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ember-view > .crm-font-semibold")));
        assertThat(driver.findElement(By.cssSelector(".ember-view > .crm-font-semibold")).getText(), is("Thông tin chi tiết"));
    }
    // Check thêm mới thành công liên hệ đầu mối
    @Test
    public void TC_addaccount_20() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addcontPg = new addcontactPage(driver);
        loginPg.login1(UserBD, Pass);
        addcontPg.addcontact(Name,Phone,Mail,Web, Web);
        addcontPg.contactclue();
        addcontPg.savecontact();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ember-view > .crm-font-semibold")));
            assertThat(driver.findElement(By.cssSelector(".ember-view > .crm-font-semibold")).getText(), is("Thông tin chi tiết"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mySlides:nth-child(1) > .col-md-6:nth-child(4) > .col-md-7 > .text-ellipsis")));
            assertThat(driver.findElement(By.cssSelector(".mySlides:nth-child(1) > .col-md-6:nth-child(4) > .col-md-7 > .text-ellipsis")).getText(),is("Đầu mối liên hệ"));
        }
    }

