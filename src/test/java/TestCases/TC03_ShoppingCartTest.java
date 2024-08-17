package TestCases;

import BaseTest.baseTest;
import Pages.P01_LoginPage;
import Pages.P02_ProductsPage;
import Pages.P03_CartPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListeners;

@Listeners(TestListeners.class)

public class TC03_ShoppingCartTest extends baseTest {
    @Test(priority = 0)
    public void User_Add_Products_To_Cart_And_Validate_Cart_Badge_Count() {
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        P02_ProductsPage productsPage = loginPage.user_Enter_Data_TO_Login("standard_user", "secret_sauce");
        productsPage.Add_First_Product_To_Cart();
        productsPage.Add_Second_Product_To_Cart();
        Assert.assertEquals(productsPage.getCartBadgeCount(), "2");
    }

    @Test(priority = 1)
    public void User_Remove_Product_To_Cart_And_Validate_Cart_Badge_Count() {
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        P02_ProductsPage productsPage = loginPage.user_Enter_Data_TO_Login("standard_user", "secret_sauce");
        productsPage.Add_First_Product_To_Cart();
        productsPage.Add_Second_Product_To_Cart();
        productsPage.Remove_First_Product_From_Cart();
        Assert.assertEquals(productsPage.getCartBadgeCount(), "1");
    }

    @Test(priority = 2)
    public void User_Add_Products_To_ShoppingCart_And_Validate_Cart_Updated() {
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        P02_ProductsPage productsPage = loginPage.user_Enter_Data_TO_Login("standard_user", "secret_sauce");
        productsPage.Add_First_Product_To_Cart();
        productsPage.Add_Second_Product_To_Cart();
        P03_CartPage cartPage = productsPage.User_NavigateTo_CartPage();
        Assert.assertTrue(cartPage.Is_First_Product_Displayed());
        Assert.assertTrue(cartPage.Is_Second_Product_Displayed());
    }

}
