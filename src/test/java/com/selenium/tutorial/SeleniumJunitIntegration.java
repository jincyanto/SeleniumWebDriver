package com.selenium.tutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(MockitoJUnitRunner.class)
public class SeleniumJunitIntegration {

    @Test
    public void installationTest(){
        System.setProperty("webdriver.chrome.driver","/Users/jincyanto/Downloads/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.close();
    }
}

