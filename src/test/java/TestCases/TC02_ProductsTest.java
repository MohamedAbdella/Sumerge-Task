package TestCases;

import BaseTest.baseTest;
import Pages.P01_LoginPage;
import Pages.P02_ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Listeners.TestListeners;
@Listeners(TestListeners.class)

public class TC02_ProductsTest extends baseTest {
    @Test(priority = 0)
    public void Verify_All_Products_Displayed() {
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        P02_ProductsPage productsPage = loginPage.user_Enter_Data_TO_Login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.get_Number_OfProducts(), 6);//Validate that the products number is 6
    }

    @Test(priority = 1)
    public void Validate_Products_Details() {
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        P02_ProductsPage productPage = loginPage.user_Enter_Data_TO_Login("standard_user", "secret_sauce");
        String[][] expectedProducts = {
                {"Sauce Labs Backpack", "$29.99", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."},
                {"Sauce Labs Bike Light", "$9.99", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included."},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt."},
                {"Sauce Labs Fleece Jacket", "$49.99", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office."},
                {"Sauce Labs Onesie", "$7.99", "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "This classic Sauce Labs t-shirt is perfect to wear when cozying up to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton."}
        };
        for (int i = 0; i < productPage.getAllProducts().size(); i++) {
            String name = productPage.getProductName(productPage.getAllProducts().get(i));
            String price = productPage.getProductPrice(productPage.getAllProducts().get(i));
            String description = productPage.getProductDescription(productPage.getAllProducts().get(i));

            Assert.assertEquals(name, expectedProducts[i][0], "Product name mismatch.");
            Assert.assertEquals(price, expectedProducts[i][1], "Product price mismatch.");
            Assert.assertEquals(description, expectedProducts[i][2], "Product description mismatch.");
        }
    }

    @Test(priority = 2)
    public void Test_Product_Sorting_By_Price() {
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        P02_ProductsPage productPage = loginPage.user_Enter_Data_TO_Login("standard_user", "secret_sauce");
        productPage.Sort_Products_ByPrice_Low_To_High();
        Assert.assertTrue(productPage.verifyProductsSortedByPriceLowToHigh(), "Products isn't sorted by price from low to high");

    }


}
