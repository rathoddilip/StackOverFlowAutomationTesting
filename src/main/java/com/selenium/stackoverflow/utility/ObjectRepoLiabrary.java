package com.selenium.stackoverflow.utility;

import com.selenium.stackoverflow.base.BaseClass;

import java.io.*;
import java.util.Properties;

public class ObjectRepoLiabrary extends BaseClass {

    public static String getLocatorProperty(String propertyFilePath, String key) throws IOException {

        String property;
        Properties properties = new Properties();
        properties.load(new FileInputStream(propertyFilePath));
        property = properties.getProperty(key);
        try {
            if(property.isEmpty())
            throw new CustomException(CustomException.ExceptionType.KEY_NOT_EXIST, "please check object repository property file");

        } catch (CustomException exception) {
            System.out.println(exception.getMessage());
        }
        return property;
    }

}