package com.selenium.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(MockitoJUnitRunner.class)
public class Hovering {

        WebDriver driver;
        WebDriverWait driverWait;

        @Before
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "/Users/jincyanto/Downloads/chromedriver");
            driver = new ChromeDriver();
            driverWait = new WebDriverWait(driver, 3);
        }

        @Test
        public void hoveringTest(){
            driver.navigate().to("https://www.amazon.com/");
            Actions action = new Actions(driver);
            WebElement element = driver.findElement(By.xpath("//*[@id=\"icp-nav-flyout\"]/span"));
            action.moveToElement(element).perform();
            System.out.println("hovered");
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"icp-flyout-mkt-change\"]/span/div"))).click();
        }

        @After
        public void exit() {
            driver.close();

        }
     }

