package Pages.contact;

import org.openqa.selenium.WebDriver;
import webdriver.helper.GenerateData;

public class addcontactPage {
    GenerateData gen = new GenerateData();
    String btnadd = "btn-add-data";
    String btnaddcontact = "add-button-Account";
    String NameLeadID ="lead-inputFullName";
    public String nameLead = gen.Name();
    String PhoneLeadID ="lead-inputPhone_0";
    public String PhoneLead = gen.Phone();
    String MailLeadID ="lead-inputEmail_0";
    public String Maillead = gen.Email();
    String WebLeadID = "website_0";
    public String WebLead = gen.web();
    String FanLeadID = "fanpage_0";
    public String FanLead = gen.web();
    String SaveLead= "#btn-add-popup > span";
    WebDriver driver;
}
