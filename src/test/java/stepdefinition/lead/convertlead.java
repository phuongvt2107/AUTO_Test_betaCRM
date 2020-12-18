package stepdefinition.lead;

import Pages.lead.addleadPage;
import Pages.lead.convertleadPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepdefinition.Base.Basetest;
import Pages.login.LoginPage;
import webdriver.helper.GenerateData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import webdriver.helper.Link;

import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class convertlead extends Basetest{
    LoginPage loginPg;
    addleadPage addleadPg;
    convertleadPage cvleadPg;
    Link links;

    // Check chuyển đổi thành công
    @Test
    public void TC_convert_01 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        cvleadPg = new convertleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        cvleadPg.ConvertLead(Name,Phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='contact']/div[3]/section/div/div/div[1]/div/div[2]/div/div[1]")));
        assertThat(driver.findElement(By.xpath("//*[@id='contact']/div[3]/section/div/div/div[1]/div/div[2]/div/div[1]")).getText(), is("Thông tin chi tiết"));
    }
    // Check chuyển đổi khi bỏ trống Tên Deal
    @Test
    public void TC_convert_02 () throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg = new addleadPage(driver);
        cvleadPg = new convertleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        cvleadPg.ConvertLead("", Phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".content-item-popup:nth-child(12) .error")));
        assertThat(driver.findElement(By.cssSelector(".content-item-popup:nth-child(12) .error")).getText(), is("Dữ liệu không được để trống"));
    }
    // Check chuyển đổi khi bỏ trống all Tên Liên hệ, SĐT, Email
    @Test
    public void TC_convert_03 () throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg = new addleadPage(driver);
        cvleadPg = new convertleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        cvleadPg.ConvertLeadfail("", "","", Name, Phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[3]/div/div")));
        assertThat(driver.findElement(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[3]/div/div")).getText(), is("Dữ liệu không được để trống"));
    }
    // Check chuyển đổi khi bỏ trống all Tên Liên hệ
    @Test
    public void TC_convert_04 () throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg = new addleadPage(driver);
        cvleadPg = new convertleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        cvleadPg.ConvertLeadfail("", Phone,Mail, Name, Phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[3]/div/div")));
        assertThat(driver.findElement(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[3]/div/div")).getText(), is("Dữ liệu không được để trống"));
    }
    // Check chuyển đổi khi bỏ trống all Tên SĐT, Email
    @Test
    public void TC_convert_05 () throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg = new addleadPage(driver);
        cvleadPg = new convertleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        cvleadPg.ConvertLeadfail(Name, "","", Name, Phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[5]/div/div/div[1]/li/div[4]/div")));
        assertThat(driver.findElement(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[5]/div/div/div[1]/li/div[4]/div")).getText(), is("Dữ liệu không được để trống"));
    }
    // Check chuyển đổi khi sai định dạng SĐT
    @Test
    public void TC_convert_06 () throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg = new addleadPage(driver);
        cvleadPg = new convertleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        cvleadPg.ConvertLeadfail(Name, "cfgf","", Name, Phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[5]/div/div/div[1]/li/div[3]")));
        assertThat(driver.findElement(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[5]/div/div/div[1]/li/div[3]")).getText(), is("Vui lòng nhập đúng định dạng số điện thoại"));
    }
    // Check chuyển đổi khi sai định dạng Mail
    @Test
    public void TC_convert_07 () throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg = new addleadPage(driver);
        cvleadPg = new convertleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        cvleadPg.ConvertLeadfail(Name, Phone,"234hđ", Name, Phone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[6]/div/div/div[1]/li/div[2]")));
        assertThat(driver.findElement(By.xpath("//*[@id='ConvertLead']/div[1]/div/div[2]/div[2]/div/div[6]/div/div/div[1]/li/div[2]")).getText(), is("Vui lòng nhập đúng định dạng email"));
    }
}

