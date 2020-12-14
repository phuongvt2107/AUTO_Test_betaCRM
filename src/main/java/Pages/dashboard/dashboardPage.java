package Pages.dashboard;

import org.openqa.selenium.WebDriver;
import webdriver.helper.Link;

public class dashboardPage {
    WebDriver driver;
    Link links;

    public dashboardPage (WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed() {
        if (links.URL_dashboard.equals(driver.getCurrentUrl())) {
            return true;
        } else {
            return false;
        }
    }
}
