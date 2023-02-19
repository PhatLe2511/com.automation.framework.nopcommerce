package com.nopcommerce.user;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utilities.Environment;

public class NopCommerce_Order extends BaseTest {
    WebDriver driver;
    Environment environment;

    @Parameters({"Browser", "env"})
    @BeforeClass
    protected void BeforeClass(String browserName, String envName){

        ConfigFactory.setProperty("env", envName);

        environment = ConfigFactory.create(Environment.class);

        driver = getBrowserName(browserName, environment.url());


    }
}
