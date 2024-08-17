package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P02_ProductsPage {
    private WebDriver driver;
    private By productItems = By.className("inventory_item");
    private By pageName = By.className("title");
    private By productName = By.className("inventory_item_name");
    private By productPrice = By.className("inventory_item_price");
    private By productDescription = By.className("inventory_item_desc");
    private By sortDropdown = By.className("product_sort_container");
    private By Btn_Of_AddCart_For_First_Product = By.id("add-to-cart-sauce-labs-backpack");
    private By Btn_Of_AddCart_For_Second_Product = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeBtn_Of_First_Product = By.id("remove-sauce-labs-backpack");
    private By getRemoveBtn_Of_Second_Product = By.id("remove-sauce-labs-bike-light");
    private By cartBadgeIcon = By.cssSelector(".shopping_cart_badge");
    private By cartIcon=By.cssSelector(".shopping_cart_link");
    private By menuIcon = By.id("react-burger-menu-btn");
    private By logOutBtn = By.id("logout_sidebar_link");


    public P02_ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String Get_The_PageName() {
        return driver.findElement(pageName).getText();
    }

    // Method to get the number of products displayed on the page
    public int get_Number_OfProducts() {
        List<WebElement> products = driver.findElements(productItems);
        return products.size();
    }

    // Get All Products In The Page
    public List<WebElement> getAllProducts() {
        return driver.findElements(productItems);
    }

    public String getProductName(WebElement product) {
        return product.findElement(productName).getText();
    }

    public String getProductPrice(WebElement product) {
        return product.findElement(productPrice).getText();
    }

    public String getProductDescription(WebElement product) {
        return product.findElement(productDescription).getText();
    }

    public void Sort_Products_ByPrice_Low_To_High() {
        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByValue("lohi");
    }

    public boolean verifyProductsSortedByPriceLowToHigh() {
        // Find all the price elements on the product page
        List<WebElement> prices = driver.findElements(By.cssSelector(".inventory_item_price"));

        // Create a list to store the price values as doubles
        List<Double> priceValues = new ArrayList<>();

        // Loop through each price element
        for (WebElement price : prices) {
            // Get the text of the price element, remove the dollar sign, and convert it to a double
            double priceValue = Double.parseDouble(price.getText().replace("$", ""));
            // Add the double value of the price to the list of price values
            priceValues.add(priceValue);
        }
        // Create a new list to store the sorted version of the price values
        List<Double> sortedPrices = new ArrayList<>(priceValues);

        // Sort the new list of prices in ascending order (from low to high)
        Collections.sort(sortedPrices);

        // Compare the original list of prices with the sorted list
        return priceValues.equals(sortedPrices);
    }

    public void Add_First_Product_To_Cart() {
        driver.findElement(Btn_Of_AddCart_For_First_Product).click();
    }

    public void Remove_First_Product_From_Cart() {
        driver.findElement(removeBtn_Of_First_Product).click();
    }

    public void Add_Second_Product_To_Cart() {
        driver.findElement(Btn_Of_AddCart_For_Second_Product).click();
    }

    public void Remove_Second_Product_From_Cart() {
        driver.findElement(getRemoveBtn_Of_Second_Product).click();
    }

    public String getCartBadgeCount() {
        return driver.findElement(cartBadgeIcon).getText();
    }

    public P03_CartPage User_NavigateTo_CartPage() {
        driver.findElement(cartIcon).click();
        return new P03_CartPage(driver);
    }

    public P01_LoginPage User_LogOut() {
        driver.findElement(menuIcon).click();
        driver.findElement(logOutBtn).click();
        return new P01_LoginPage(driver);
    }

}
