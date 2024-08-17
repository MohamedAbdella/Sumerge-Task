package TestCases;
import BaseTest.baseTest;
import Pages.P01_LoginPage;
import Pages.P02_ProductsPage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.TestListeners;

@Listeners(TestListeners.class)

public class TC01_LoginTest extends baseTest {
    @Test(priority = 0)
    public void User_Can_Login_With_ValidData(){
        P01_LoginPage loginPage=new P01_LoginPage(driver);
        P02_ProductsPage productsPage= loginPage.user_Enter_Data_TO_Login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.Get_The_PageName().contains("Products"));
    }

    @Test(priority = 1)
    public void User_Login_With_Invalid_Data(){
        Faker fakeData = new Faker();  //Use faker class to generate random data
        String userName = fakeData.name().username();
        String pass = fakeData.number().digits(5).toString();
        P01_LoginPage loginPage=new P01_LoginPage(driver);
        loginPage.user_Enter_Data_TO_Login(userName,pass);
        //Validate that when the user enters invalid data , Validation message appears
        Assert.assertTrue(loginPage.get_Validatio_Message_When_Login_With_Invalid_Data().contains("Epic sadface: Username and password do not match any user in this service"));

    }



}
