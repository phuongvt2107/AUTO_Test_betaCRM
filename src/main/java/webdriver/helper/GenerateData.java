package webdriver.helper;

import java.util.Random;
import java.time.ZonedDateTime;
public class GenerateData {

    String[] Phones = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String[] _first = {"Nguyễn", "Phạm", "Trần", "Vũ", "Ma", "Đỗ", "Võ", "Phan", "Lê", "Đinh", "Mai", "Cù", "Quách"};
    String[] _middle = {"Thị", "", "Văn", "Thu", "Xuân"};
    String[] _last = {"Dũng", "Tuấn", "Hoàng", "Hà", "Trang", "Trung", "Nguyên", "Thủy", "Nam", "Thu", "Nhung", "Lâm", "Lam", "Lan", "Ngọc", "Hân", "Loan", "Thu", "La", "An", "Anh", "Ánh"};
    String[] _mailid = {"z", "x", "c", "v", "b", "n", "m", "a", "s", "d", "f", "g", "h", "j", "k", "l", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p"};
    String[] _domain = {"@gmail.com", "@gmail.com.vn"};
    String[] _domainweb = {".com.vn", ".com", ".vn"};
    Random random = new Random();

    public int getTime() {
        return (int) ZonedDateTime.now().toInstant().toEpochMilli();
    }

    public String Name() {

        int first_point = random.nextInt(_first.length);

        int middle_point = random.nextInt(_middle.length);

        int last_point = random.nextInt(_last.length);

        return String.format("%s %s %s", _first[first_point], _middle[middle_point], _last[last_point]);

    }

    public int creatrandumPhone() {
        int Phone_point = random.nextInt(Phones.length);
        return Phone_point;
    }

    public String Phone() {
        String randomString = Phones[creatrandumPhone()] + Phones[creatrandumPhone()] + Phones[creatrandumPhone()] + Phones[creatrandumPhone()]
                + Phones[creatrandumPhone()]
                + Phones[creatrandumPhone()]
                + Phones[creatrandumPhone()]
                + Phones[creatrandumPhone()]
                + Phones[creatrandumPhone()];
        return randomString;
    }

    public String Email() {
        int mailid_point = random.nextInt(26);
        int domain_point = random.nextInt(_domain.length);
        return String.format("%s%s%s%s%s%s%s%s", _mailid[mailid_point], _mailid[mailid_point], _mailid[mailid_point], _mailid[mailid_point], _mailid[mailid_point], _mailid[mailid_point], Phones[creatrandumPhone()], _domain[domain_point]);
    }

    public String web() {
        int webid_point = random.nextInt(26);
        int domain_p= random.nextInt(_domainweb.length);
        return String.format("%s%s%s%s%s%s%s%s",_mailid[webid_point], _mailid[webid_point], _mailid[webid_point], _mailid[webid_point], _mailid[webid_point], _mailid[webid_point], Phones[creatrandumPhone()], _domainweb[domain_p]);
    }
}

