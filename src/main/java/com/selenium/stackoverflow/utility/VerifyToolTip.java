package com.selenium.stackoverflow.utility;

import com.selenium.stackoverflow.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyToolTip extends BaseClass {

    @FindBy(xpath = "//li[@class='-item site-switcher-item']/a")
    WebElement listOfAllStack;

    public VerifyToolTip(WebDriver driver) {
        PageFactory.initElements(driver, this); //initElements method is used to initialize web elements
    }

    public  String  toolTipVerifyTitle() throws InterruptedException {
        Actions actions = new Actions(driver);
        LogClass.info("Mouse moving on icon of list");
        Thread.sleep(2000);
        actions.moveToElement(listOfAllStack).build().perform();
        LogClass.info("Getting the tool tip as a title");
        String toolTip =listOfAllStack.getAttribute("title");
        System.out.println("ToolTip is: "+toolTip);
        return toolTip;
    }
}
