package com.selenium.stackoverflow.pages;

import com.selenium.stackoverflow.base.BaseClass;
import com.selenium.stackoverflow.utility.LogClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {


    @FindBy(xpath = "//a[contains(text(), 'Log in')]")
    WebElement loginLink;
    @FindBy(id = "email")
    WebElement emailId;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "submit-button")
    WebElement submitbutton;


    //parameterized constructor is used
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used to initialize web elements
    }

    public void signInUser() throws InterruptedException {
        Thread.sleep(1000);
        LogClass.info("Clicking on login link");
        loginLink.click();
        Thread.sleep(1000);
    }

    public void setEmailId(String username) throws InterruptedException {
        Thread.sleep(2000);
        LogClass.info("Entering email id");
        emailId.sendKeys(username);
        Thread.sleep(1000);
    }

    public void setPassword(String passwd) throws InterruptedException {
        Thread.sleep(2000);
        LogClass.info("Entering password");
        password.sendKeys(passwd);
        Thread.sleep(1000);
    }

    public void clickLogin() throws InterruptedException {
        Thread.sleep(2000);
        LogClass.info("Click on login button");
        submitbutton.click();
        LogClass.info("Login successfully");
        Thread.sleep(1000);
    }
}
