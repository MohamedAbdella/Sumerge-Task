package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {

    private WebDriver driver;
    private By userNameField = By.id("user-name");
    private By PassField = By.id("password");
    private By loginBtn = By.id("login-button");
    private By validation_Message = By.tagName("h3");

    public P01_LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean Is_Login_Page_Appeared(){
        driver.findElement(loginBtn);
        return true;
    }

    public P02_ProductsPage user_Enter_Data_TO_Login(String username, String password) {
        driver.findElement(userNameField).sendKeys(username);
        driver.findElement(PassField).sendKeys(password);
        driver.findElement(loginBtn).click();
        return new P02_ProductsPage(driver);
    }

    public String get_Validatio_Message_When_Login_With_Invalid_Data() {
        return driver.findElement(validation_Message).getText();
    }
}
