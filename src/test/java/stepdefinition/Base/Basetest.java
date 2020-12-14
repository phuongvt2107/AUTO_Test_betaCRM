package stepdefinition.Base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webdriver.helper.GenerateData;
import webdriver.helper.Link;

public class Basetest {
    protected WebDriver driver;
    //public static final String URL_login = "https://betacrm.novaon.asia/";
    //public static final String URL_dashboard = "https://betacrm.novaon.asia/Dashboard";
    GenerateData gen;
    Link links;
    public String UserBD, User ,Useradmin, Pass, Name, Phone, Mail, Web;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/browserDrivers/chromedriver2.exe");
        driver = new ChromeDriver();
        driver.get(links.Domain);
        driver.manage().window().setSize(new Dimension(1366, 768));
        gen = new GenerateData();
        User = "hangqt";
        UserBD = "phuongptt";
        Useradmin = "adminerp";
        Pass = "x3bestseller";
        Name = gen.Name();
        Phone = gen.Phone();
        Mail = gen.Email();
        Web = gen.web();

        //  Maximize the browser
        //driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
