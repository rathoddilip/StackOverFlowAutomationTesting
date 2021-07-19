package com.selenium.stackoverflow.test;

import com.selenium.stackoverflow.base.BaseClass;
import com.selenium.stackoverflow.pages.Login;
import com.selenium.stackoverflow.utility.CustomListener;
import com.selenium.stackoverflow.utility.MyScreenRecorder;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Feature("Login to application")
@Listeners(CustomListener.class)
public class StackOverFlowTest extends BaseClass {

    public static String email = "diliprathod32@gmail.com";
    public static String password = "Login@123";

    @Severity(SeverityLevel.CRITICAL)
    @Description("Login to application with valid credentials")
    @Story("Test login account ")
    @Test(priority = 1)
    public void loginToApplication() throws Exception {
        MyScreenRecorder.startRecording("loginToApplication");
        Login login = new Login(driver);
        login.signInUser();
        login.setEmailId(email);
        login.setPassword(password);
        login.clickLogin();
        String expectedEmail = "diliprathod32@gmail.com";
        Assert.assertEquals(email, expectedEmail);
        MyScreenRecorder.stopRecording();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("Logout from application")
    @Story("Test logout account ")
    @Test(priority = 2)
    public void logOutFromApplication() throws InterruptedException, IOException {
        Login login = new Login(driver);
        login.signInUser();
        login.setEmailId(email);
        login.setPassword(password);
        login.clickLogin();
        login.logOut();
        String expectedUrl = "https://stackoverflow.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }
}
