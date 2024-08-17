package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class P03_CartPage {
    private WebDriver driver;
    private By Products_Numbers_Icon = By.className("shopping_cart_badge");
    private By First_Oriduct_Name = By.id("item_4_title_link");
    private By Second_Product_Name = By.id("item_0_title_link");

    public P03_CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public String getCartBadgeCount() {
        return driver.findElement(Products_Numbers_Icon).getText();
    }

    public Boolean Is_First_Product_Displayed() {

        driver.findElement(First_Oriduct_Name);
        return true;
    }

    public Boolean Is_Second_Product_Displayed() {
            driver.findElement(Second_Product_Name).isDisplayed();
            return true;
    }


}