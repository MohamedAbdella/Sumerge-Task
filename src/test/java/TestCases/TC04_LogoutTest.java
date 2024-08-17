package TestCases;

import BaseTest.baseTest;
import Pages.P01_LoginPage;
import Pages.P02_ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListeners;

@Listeners(TestListeners.class)
public class TC04_LogoutTest extends baseTest {
    @Test
    public void User_LogOut_And_Ensure_Users_Are_Redirected_ToLoginPage(){
        P01_LoginPage loginPage = new P01_LoginPage(driver);
        P02_ProductsPage productsPage = loginPage.user_Enter_Data_TO_Login("standard_user", "secret_sauce");
        productsPage.User_LogOut();
        Assert.assertTrue(loginPage.Is_Login_Page_Appeared());

    }
}
