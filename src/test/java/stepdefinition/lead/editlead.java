package stepdefinition.lead;

import Pages.lead.addleadPage;
import Pages.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepdefinition.Base.Basetest;
import webdriver.helper.Link;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class editlead extends Basetest {
    LoginPage loginPg;
    addleadPage addleadPg;
    Link links;
    // Check edit thành công
    @Test
    public void TC_editlead_001 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editleadneed(Name, Phone,Mail, Web,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-message")));
        assertThat(driver.findElement(By.cssSelector(".toast-message")).getText(), is("Cập nhật thành công"));
    }
    // Check edit không thành công khi bỏ trống all trường bắt buộc
    @Test
    public void TC_editlead_002 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editlead("", "","", Web,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errornamelead));
        Assert.assertEquals(addleadPg.errornamelead.getText(), "Dữ liệu không được để trống");
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errorphonelead));
        Assert.assertEquals(addleadPg.errorphonelead.getText(), "Dữ liệu không được để trống");
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errormaillead));
        Assert.assertEquals(addleadPg.errormaillead.getText(), "Dữ liệu không được để trống");
    }
    // Check edit không thành công khi bỏ trống trường tên Lead
    @Test
    public void TC_editlead_003 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editlead("", Phone,Mail, Web,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errornamelead));
        Assert.assertEquals(addleadPg.errornamelead.getText(), "Dữ liệu không được để trống");
    }
    // Check edit không thành công khi bỏ trống SĐT và mail
    @Test
    public void TC_editlead_004 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editlead(Name, "","", Web,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errorphonelead));
        Assert.assertEquals(addleadPg.errorphonelead.getText(), "Dữ liệu không được để trống");
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errormaillead));
        Assert.assertEquals(addleadPg.errormaillead.getText(), "Dữ liệu không được để trống");
    }
    // Check edit không thành công khi nhập sai định dạng SĐT
    @Test
    public void TC_editlead_005 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editlead(Name, Name,Mail, Web,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errorphonelead1));
        Assert.assertEquals(addleadPg.errorphonelead1.getText(), "Vui lòng nhập đúng định dạng số điện thoại");
    }
    // Check edit không thành công khi nhập sai định dạng Email
    @Test
    public void TC_editlead_006 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editlead(Name, Phone,Web, Web,Web );
        addleadPg.btsavelead();
        Thread.sleep(1000);
        Assert.assertEquals(addleadPg.errormaillead1.getText(),"Vui lòng nhập đúng định dạng email");
    }
    // Check edit không thành công khi nhập sai định dạng Website
    @Test
    public void TC_editlead_007 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        addleadPg.editleadweb(Name,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errorweblead));
        Assert.assertEquals(addleadPg.errorweblead.getText(),"Vui lòng nhập đúng định dạng website");
    }
    // Check edit không thành công khi nhập sai định dạng Website
    @Test
    public void TC_editlead_008 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        addleadPg.editleadweb(Web,Name );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errorfanlead));
        Assert.assertEquals(addleadPg.errorfanlead.getText(),"Vui lòng nhập đúng định dạng fanpage");
    }
    // Check edit không thành công khi nhập trùng SĐT + Nhu cầu
    @Test
    public void TC_editlead_09 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editleadneed(Name, "889364212",  Mail, Web, Web);
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.pupopcoincide));
        Assert.assertEquals(addleadPg.pupopcoincide.getText(), "Trùng dữ liệu khách hàng, thêm mới lead không thành công!");
    }
    // Check edit không thành công khi nhập trùng SĐT + Nhu cầu
    @Test
    public void TC_editlead_10 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editleadneed(Name, Phone,"vtphuong2107@gmail.com", Web,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.pupopcoincide));
        Assert.assertEquals(addleadPg.pupopcoincide.getText(), "Trùng dữ liệu khách hàng, thêm mới lead không thành công!");
    }
    // Check edit không thành công khi nhập trùng Web + Nhu cầu
    @Test
    public void TC_editlead_11 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editleadneed(Name, Phone,Mail, "vtphuong.com.vn",Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.pupopcoincide));
        Assert.assertEquals(addleadPg.pupopcoincide.getText(), "Trùng dữ liệu khách hàng, thêm mới lead không thành công!");
    }
    // Check edit không thành công khi nhập trùng Fan + Nhu cầu
    @Test
    public void TC_editlead_12 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        addleadPg.editleadneed(Name, Phone,Mail, Web,"vtphuong.com.vn" );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.pupopcoincide));
        Assert.assertEquals(addleadPg.pupopcoincide.getText(), "Trùng dữ liệu khách hàng, thêm mới lead không thành công!");
    }
    // Check edit không thành công khi click button Hủy
    @Test
    public void TC_editlead_13 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(UserBD, Pass);
        Thread.sleep(1000);
        driver.get(links.URL_getalllead);
        addleadPg.btneditlead();
        Thread.sleep(3000);
        addleadPg.editleadneed(Name, Phone,Mail, Web,Web );
        addleadPg.btcancel();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".info-detail-lead-title")));
        assertEquals(driver.findElement(By.cssSelector(".info-detail-lead-title")).getText(), "Thông tin chi tiết");
    }
}
