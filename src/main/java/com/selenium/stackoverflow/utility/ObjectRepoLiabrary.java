package com.selenium.stackoverflow.utility;

import com.selenium.stackoverflow.base.BaseClass;

import java.io.*;
import java.util.Properties;

public class ObjectRepoLiabrary extends BaseClass {

    public static String getLocatorProperty(String propertyFilePath, String key) throws IOException {

        String property = "";
        Properties properties = new Properties();
        try {

            properties.load(new FileInputStream(propertyFilePath));
            property = properties.getProperty(key);
            throw new CustomException(CustomException.ExceptionType.FILE_NOT_EXIST, "please check file path and name");

        } catch (CustomException | FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        return property;
    }

}