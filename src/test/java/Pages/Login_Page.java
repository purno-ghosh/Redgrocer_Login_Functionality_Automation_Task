package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
    WebDriver driver;
    @FindBy(xpath = "//button[contains(.,'Ok. I Understood')]")
    WebElement linkLogin;
    @FindBy(id = "phone-code")
    WebElement Number;

    @FindBy(id = "password")
    WebElement Password;

    @FindBy(xpath = "//button[contains(.,'Login')]")
    WebElement loginbtn;
    @FindBy(xpath = "//h1[@class='h3'][contains(.,'Dashboard')]")
    WebElement TextName;

    @FindBy(xpath = "//span[@data-notify='message'][contains(.,'Invalid email or password')]")
    WebElement ErrorText;

    @FindBy(xpath = "//a[contains(.,'Sign in')]")
    WebElement SingIn;


    public Login_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory pageFactory;
        PageFactory.initElements(driver, this);
    }

    public String dologin_with_valid_num_pass(String number, String password) throws InterruptedException {

        linkLogin.click();
        SingIn.click();
        Number.sendKeys(number);
        Password.sendKeys(password);
        loginbtn.click();
        return TextName.getText();


    }

    public String dologin_with_invalid_num_valid_pass(String number, String password) throws InterruptedException {
        SingIn.click();
        Number.sendKeys(number);
        Password.sendKeys(password);
        loginbtn.click();
        return ErrorText.getText();
    }

    public String dologin_with_valid_num_invalid_pass(String number, String password) throws InterruptedException {
        SingIn.click();
        Number.sendKeys(number);
        Password.sendKeys(password);
        loginbtn.click();
        return ErrorText.getText();
    }

}
