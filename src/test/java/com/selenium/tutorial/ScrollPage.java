package com.selenium.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

@RunWith(MockitoJUnitRunner.class)
public class ScrollPage {

    WebDriver driver;
    WebDriverWait driverWait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/jincyanto/Downloads/chromedriver");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 3);
    }

    @Test
    public void scrollTest() {
        driver.navigate().to("https://www.amazon.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0, 2000)");
    }

    @After
    public void exit() {
        driver.close();
    }
}

