package stepdefinition.login;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.login.LoginPage;
import Pages.dashboard.dashboardPage;
import stepdefinition.Base.Basetest;
import webdriver.helper.Link;

import java.util.concurrent.TimeUnit;

public class login extends Basetest {
    LoginPage loginPg;
    Link links;
    dashboardPage dashboardPg;

    // Check login khi bỏ trống PASS
    @Test
    public void TC_Login_01() throws Throwable{
        loginPg = new LoginPage(driver);
        loginPg.login1("", "");
        Assert.assertEquals(loginPg.login_error.getText(),"Vui lòng nhập mật khẩu");
        Assert.assertTrue(loginPg.isDisplayed());
        driver.quit();
    }
    // Check login khi bỏ trống PASS
    @Test
    public void TC_Login_02() throws Throwable{
        loginPg = new LoginPage(driver);
        loginPg.login1(User, "");
        Assert.assertEquals(loginPg.login_error.getText(),"Vui lòng nhập mật khẩu");
        Assert.assertTrue(loginPg.isDisplayed());
        driver.quit();
    }

    // Check login khi bỏ trống User
    @Test
    public void TC_Login_03() throws Throwable{
        loginPg = new LoginPage(driver);
        loginPg.login1("", Pass);
        Assert.assertEquals(loginPg.login_error.getText(), "Vui lòng nhập mật khẩu");
        Assert.assertTrue(loginPg.isDisplayed());
        driver.quit();
    }

    // Check login khi nhập sai PASS
    @Test
    public void TC_Login_04() throws Throwable{
        loginPg = new LoginPage(driver);
        loginPg.login1(User, "3656879343");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(loginPg.login_error.getText(), "Tên đăng nhập hoặc mật khẩu không đúng");
        Assert.assertTrue(loginPg.isDisplayed());
        driver.quit();
    }

    // Check login khi nhập sai User
    @Test
    public void TC_Login_05() throws Throwable{
        loginPg = new LoginPage(driver);
        loginPg.login1("hahaha", Pass);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(loginPg.login_error.getText(),"Tên đăng nhập hoặc mật khẩu không đúng");
        Assert.assertTrue(loginPg.isDisplayed());
        driver.quit();
    }

    // Check login thành công
    @Test
    public void TC_Login_06() throws Throwable{
        loginPg = new LoginPage(driver);
        dashboardPg = new dashboardPage(driver);
        loginPg.login1(User, Pass);
        Assert.assertTrue(dashboardPg.isDisplayed());
        driver.quit();
    }
}
