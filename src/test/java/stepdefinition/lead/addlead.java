package stepdefinition.lead;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepdefinition.Base.Basetest;
import Pages.login.LoginPage;
import Pages.lead.addleadPage;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import webdriver.helper.Link;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class addlead extends Basetest {
    LoginPage loginPg;
    addleadPage addleadPg;
    Link links;
    //GenerateData gen = new GenerateData();
    //Check thêm Lead khi bỏ trống all trường bắt buộc
    @Test
    public void TC_AddLead_SDT_Validate_01 () throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        addleadPg.addlead();
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errornamelead));
        Assert.assertEquals(addleadPg.errornamelead.getText(), "Dữ liệu không được để trống");
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errorphonelead));
        Assert.assertEquals(addleadPg.errorphonelead.getText(), "Dữ liệu không được để trống");
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.errormaillead));
        Assert.assertEquals(addleadPg.errormaillead.getText(), "Dữ liệu không được để trống");
    }
    //Check thêm Lead khi bỏ trống trường Tên lead
    @Test
    public void TC_AddLead_SDT_Validate_02 () throws Throwable{
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        //Thread.sleep(1000);
        addleadPg.addlead1("",Phone,Mail,Web,Web);
        //Thread.sleep(1000);
        addleadPg.btsavelead();
        //Thread.sleep(1000);
        Assert.assertEquals(addleadPg.errornamelead.getText(), "Dữ liệu không được để trống");
    }
    //Check thêm Lead khi bỏ trống SĐT và Email
    @Test
    public void TC_AddLead_SDT_Validate_03 () throws Throwable{
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        //Thread.sleep(1000);
        addleadPg.addlead1(Name,"","","","");
        addleadPg.btsavelead();
        Assert.assertEquals(addleadPg.errorphonelead.getText(), "Dữ liệu không được để trống");
        Assert.assertEquals(addleadPg.errormaillead.getText(), "Dữ liệu không được để trống");
    }
    // Check thêm Lead thất bại khi bỏ trống trường nhu cầu
    @Test
    public void TC_AddLead_SDT_Validate_4() throws Throwable{
        loginPg = new LoginPage(driver);
        //Thread.sleep(1000);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        addleadPg.addlead1(Name, Phone,Mail, Web,Web );
        addleadPg.btsavelead();
        Thread.sleep(8000);
        Assert.assertEquals(addleadPg.errorneedlead.getText(), "Nhu cầu không được để trống");
    }
    //Check thêm Lead nhập SĐT sai định dạng
    @Test
    public void TC_AddLead_SDT_Validate_05 () throws Throwable {
        loginPg = new LoginPage(driver);
        addleadPg = new addleadPage(driver);
        loginPg.login1(User, Pass);
        //Thread.sleep(1000);
        addleadPg.addlead1(Name, "65475fhfgsss", Mail, Web, Web);
        addleadPg.btsavelead();
        Assert.assertEquals(addleadPg.errorphonelead1.getText(), "Vui lòng nhập đúng định dạng số điện thoại");
    }
    //Check thêm Lead nhập sai định dạng email
    @Test
    public void TC_AddLead_SDT_Validate_06() throws Throwable{
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        //Thread.sleep(1000);
        addleadPg.addlead1(Name, Phone, "vtphuong2107",Web,Web);
        addleadPg.btsavelead();
        Thread.sleep(1000);
        Assert.assertEquals(addleadPg.errormaillead1.getText(),"Vui lòng nhập đúng định dạng email");
    }
    //Check thêm Lead nhập sai định dạng Web
    @Test
    public void TC_AddLead_SDT_Validate_07() throws Throwable{
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        //Thread.sleep(1000);
        addleadPg.addlead1(Name, Phone,Mail, "sgdsss", Web);
        addleadPg.btsavelead();
        Thread.sleep(3000);
        Assert.assertEquals(addleadPg.errorweblead.getText(),"Vui lòng nhập đúng định dạng website");
    }
    //Check thêm Lead nhập sai định dạng Fan
    @Test
    public void TC_AddLead_SDT_Validate_08() throws Throwable{
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        //Thread.sleep(1000);
        addleadPg.addlead1(Name, Phone, Mail, Web,"36675568" );
        addleadPg.btsavelead();
        Thread.sleep(3000);
        Assert.assertEquals(addleadPg.errorfanlead.getText(),"Vui lòng nhập đúng định dạng fanpage");
    }
    // Check Lead trùng SĐT
    @Test
    public void TC_AddLead_SDT_Validate_09(){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        //Thread.sleep(1000);
        addleadPg.addlead2(Name, "889364212",  Mail, Web,Web );
        addleadPg.btsavelead();
        //Thread.sleep(7000);
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.pupopcoincide));
        Assert.assertEquals(addleadPg.pupopcoincide.getText(), "Trùng dữ liệu khách hàng, thêm mới lead không thành công!");
        driver.quit();
    }
    // Check Lead trùng Email
    @Test
    public void TC_AddLead_SDT_Validate_10() {
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        addleadPg.addlead2(Name, Phone,"vtphuong2107@gmail.com", Web,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.pupopcoincide));
        Assert.assertEquals(addleadPg.pupopcoincide.getText(), "Trùng dữ liệu khách hàng, thêm mới lead không thành công!");
        driver.quit();
    }
    // Check Lead trùng Web
    @Test
    public void TC_AddLead_SDT_Validate_11(){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);

        addleadPg.addlead2(Name, Phone,Mail, "vtphuong.com.vn",Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.pupopcoincide));
        Assert.assertEquals(addleadPg.pupopcoincide.getText(), "Trùng dữ liệu khách hàng, thêm mới lead không thành công!");
        driver.quit();
    }
    // Check Lead trùng Fan
    @Test
    public void TC_AddLead_SDT_Validate_12(){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        addleadPg.addlead2(Name, Phone,Mail, Web,"vtphuong.com.vn" );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.elementToBeClickable(addleadPg.pupopcoincide));
        Assert.assertEquals(addleadPg.pupopcoincide.getText(), "Trùng dữ liệu khách hàng, thêm mới lead không thành công!");
        driver.quit();
    }
    // Check thêm Lead thành công chỉ nhập SĐT
    @Test
    public void TC_AddLead_SDT_Validate_13(){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        //Thread.sleep(1000);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        addleadPg.addlead2(Name, Phone,"", Web,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-title")));
        assertThat(driver.findElement(By.cssSelector(".toast-title")).getText(), is("Thành công"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".info-detail-lead-title")));
        assertThat(driver.findElement(By.cssSelector(".info-detail-lead-title")).getText(), is("Thông tin chi tiết"));
    }
    // Check thêm Lead thành công chỉ nhập email
    @Test
    public void TC_AddLead_SDT_Validate_14(){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        //Thread.sleep(1000);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        addleadPg.addlead2(Name, "",Mail, Web,Web);
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".info-detail-lead-title")));
        //assertThat(driver.findElement(By.cssSelector(".toast-title")).getText(), is("Thành công"));
        assertThat(driver.findElement(By.cssSelector(".info-detail-lead-title")).getText(), is("Thông tin chi tiết"));
    }
    // Check thêm Lead thành công chỉ nhập đủ SĐT & email
    @Test
    public void TC_AddLead_SDT_Validate_15(){
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        //Thread.sleep(1000);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        addleadPg.addlead2(Name, Phone,Mail, Web,Web );
        addleadPg.btsavelead();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-title")));
        assertThat(driver.findElement(By.cssSelector(".toast-title")).getText(), is("Thành công"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".info-detail-lead-title")));
        assertThat(driver.findElement(By.cssSelector(".info-detail-lead-title")).getText(), is("Thông tin chi tiết"));
    }
    // Check thêm Lead không thành công khi click button Hủy
    @Test
    public void TC_AddLead_SDT_Validate_16() throws Throwable{
        WebDriverWait wait = new WebDriverWait(driver, 30000);
        loginPg = new LoginPage(driver);
        //Thread.sleep(1000);
        addleadPg =new addleadPage(driver);
        loginPg.login1(User, Pass);
        //Thread.sleep(1000);
        addleadPg.addlead2(Name, Phone,Mail, Web,Web );
        addleadPg.btcancel();
        Thread.sleep(8000);
        Assert.assertTrue(addleadPg.isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
