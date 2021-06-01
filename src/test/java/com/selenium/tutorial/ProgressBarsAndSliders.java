package com.selenium.tutorial;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(MockitoJUnitRunner.class)
public class ProgressBarsAndSliders {
    WebDriver driver;
    WebDriverWait driverWait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/jincyanto/Downloads/chromedriver");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 3);
    }

    @Test
    public void moveSlider(){
        driver.navigate().to("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
        WebElement slider =  driver.findElement(By.xpath("//*[@id=\"slider3\"]/div/input"));
        Actions move = new Actions(driver);
        move.moveToElement(slider).clickAndHold().moveByOffset(50,0).release().perform();

    }
        }







//public void rangeSliders(){
//        driver.navigate().to("https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html");
//        WebElement slider= driver.findElement(By.xpath("//*[@id=\"slider2\"]/div/input"));
//        Actions move = new Actions(driver);
//        Action action =move.dragAndDropBy(slider,-7,0).build();
//        action.perform();