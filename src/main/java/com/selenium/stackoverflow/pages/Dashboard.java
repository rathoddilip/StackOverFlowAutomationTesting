package com.selenium.stackoverflow.pages;

import com.selenium.stackoverflow.base.BaseClass;
import com.selenium.stackoverflow.utility.LogClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard extends BaseClass {

    @FindBy(xpath = "//a[@class='-link js-site-switcher-button js-gps-track']")
    WebElement iconLogout;
    @FindBy(xpath = "//a[contains(text(), 'log out')]")
    WebElement logoutLink;
    @FindBy(xpath = "//button[contains(text(), 'Log out')]")
    WebElement logoutButton;

    //parameterized constructor is used
    public Dashboard(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used to initialize web elements
    }

    public void logOut() throws InterruptedException {
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        LogClass.info("Mouse moving on icon of stack overflow");
        actions.moveToElement(iconLogout).build().perform();
        LogClass.info("Clicking on icon of stack overflow");
        iconLogout.click();
        Thread.sleep(1000);
        LogClass.info("Clicking on logout link");
        logoutLink.click();
        Thread.sleep(2000);
        LogClass.info("Click on logout button");
        logoutButton.click();
        LogClass.info("Logout successfully");
        Thread.sleep(1000);
    }
}
