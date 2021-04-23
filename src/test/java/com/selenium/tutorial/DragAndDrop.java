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
public class DragAndDrop {

    WebDriver driver;
    WebDriverWait driverWait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/jincyanto/Downloads/chromedriver");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 3);
    }

    @Test
    public void drahDrop(){
        driver.navigate().to("https://www.w3schools.com/html/html5_draganddrop.asp");
        WebElement from = driver.findElement(By.xpath("//*[@id=\"drag1\"]"));
        WebElement to = driver.findElement(By.xpath("//*[@id=\"div2\"]"));
        Actions act = new Actions(driver);
        act.dragAndDrop(from,to).build().perform();
    }
}


