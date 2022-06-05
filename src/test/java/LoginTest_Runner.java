import Pages.Login_Page;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest_Runner extends SetUp_Page {
    Login_Page objlogin;
    Utils utils;

    @Test(enabled = true, priority = 0)
    public void dologin_with_valid_num_pass() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.redgrocer.com/");
        objlogin = new Login_Page(driver);
        utils = new Utils(driver);
        utils.readJSONArray(0);
        String user1 = objlogin.dologin_with_valid_num_pass(utils.getNumber(), utils.getPassword());
        Assert.assertEquals(user1, "Dashboard");
        driver.findElement(By.xpath("//a[contains(@class,' text-reset d-inline-block opacity-60 py-2')]")).click();

    }

    @Test(enabled = true, priority = 1)
    public void dologin_with_invalid_num_valid_pass() throws IOException, ParseException, InterruptedException {
        driver.get("https://www.redgrocer.com/");
        objlogin = new Login_Page(driver);
        utils = new Utils(driver);
        utils.readJSONArray(1);
        String user2 = objlogin.dologin_with_invalid_num_valid_pass(utils.getNumber(), utils.getPassword());
        System.out.println(user2);
    }

    @Test(enabled = true, priority = 2)
    public void dologin_with_valid_num_invalid_pass() throws Exception {
        driver.get("https://www.redgrocer.com/users/login");
        objlogin = new Login_Page(driver);
        utils = new Utils(driver);
        utils.readJSONArray(2);
        String user3 = objlogin.dologin_with_valid_num_invalid_pass(utils.getNumber(), utils.getPassword());
        System.out.println(user3);

    }
}
