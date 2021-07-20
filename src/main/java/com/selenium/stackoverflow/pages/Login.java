package com.selenium.stackoverflow.pages;

import com.selenium.stackoverflow.base.BaseClass;
import com.selenium.stackoverflow.utility.LogClass;
import com.selenium.stackoverflow.utility.ObjectRepoLiabrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class Login extends BaseClass {

    public String propertyFilePath = "/home/arjun/Dilip/StackOverFlowApplicationAutomationTesting/src/test/resources/objectRepositoryOFWebElement.properties";

    @FindBy(id = "email")
    WebElement emailId;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "submit-button")
    WebElement submitButton;
    @FindBy(xpath = "//a[@class='-link js-site-switcher-button js-gps-track']")
    WebElement iconLogout;
    @FindBy(xpath = "//a[contains(text(), 'log out')]")
    WebElement logoutLink;
    @FindBy(xpath = "//button[contains(text(), 'Log out')]")
    WebElement logoutButton;

    //parameterized constructor is used
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used to initialize web elements
    }

    public void signInUser() throws InterruptedException, IOException {
        Thread.sleep(2000);
        LogClass.info("Clicking on login link");
        //Find element locator using object repository
        driver.findElement(By.xpath(ObjectRepoLiabrary.getLocatorProperty(propertyFilePath, "loginLinkRepo"))).click();
    }

    public void setEmailId(String username) throws InterruptedException {
        Thread.sleep(1000);
        LogClass.info("Entering email id");
        emailId.sendKeys(username);
    }

    public void setPassword(String passwd) throws InterruptedException {
        Thread.sleep(1000);
        LogClass.info("Entering password");
        password.sendKeys(passwd);
    }

    public void clickLogin() throws InterruptedException {
        Thread.sleep(1000);
        LogClass.info("Click on login button");
        submitButton.click();
        LogClass.info("Login successfully");
    }

    public void logOut() throws InterruptedException {
        Actions actions = new Actions(driver);
        LogClass.info("Mouse moving on icon of stack overflow");
        Thread.sleep(2000);
        actions.moveToElement(iconLogout).build().perform();
        Thread.sleep(1000);
        LogClass.info("Clicking on icon of stack overflow");
        iconLogout.click();
        Thread.sleep(1000);
        LogClass.info("Clicking on logout link");
        logoutLink.click();
        Thread.sleep(1000);
        LogClass.info("Click on logout button");
        logoutButton.click();
        LogClass.info("Logout successfully");
        Thread.sleep(1000);
    }
}
