package com.selenium.stackoverflow.utility;

import com.selenium.stackoverflow.base.BaseClass;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CustomListener extends BaseClass implements ITestListener {
    ScreenShotTestImage screenShotTestImage = new ScreenShotTestImage();

    public CustomListener() {
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("SUCCESS Test");
        screenShotTestImage.success(result.getMethod().getMethodName());
        LogClass.info(result.getMethod().getMethodName() + " :take success screenshot in ITestlistner method");
        Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED Test");

        try {
            screenShotTestImage.failed(result.getMethod().getMethodName());
            LogClass.error(result.getMethod().getMethodName() + " :take failed screenshot in Ilistner method");
            Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Error fail: " + "_" + 2 + "_" + "fail");
        }
    }
}
