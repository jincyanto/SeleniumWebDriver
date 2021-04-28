package com.selenium.tutorial;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(MockitoJUnitRunner.class)
public class DoubleClick {
    WebDriver driver;
    WebDriverWait driverWait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/jincyanto/Downloads/chromedriver");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 10);
    }

    @Test
    public void doubleClick(){
        driver.navigate().to("http://demo.guru99.com/test/simple_context_menu.html");
        Actions act= new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"))).doubleClick().build().perform();
    }

    
}
