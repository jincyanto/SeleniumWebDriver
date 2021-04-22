package com.selenium.tutorial;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(MockitoJUnitRunner.class)
public class DropDownHandling {
    WebDriver driver;
    WebDriverWait driverWait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/jincyanto/Downloads/chromedriver");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 3);
    }

    @Test
    public void dropDownByValue() {
        driver.navigate().to("https://www.mediacollege.com/internet/samples/html/country-list.html");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/p[2]/select"))).click();
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/select")));
        dropdown.selectByValue("AF");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/p[2]/select"))).click();
    }

    @Test
    public void dropDownByVisibleTest(){
        driver.navigate().to("https://www.mediacollege.com/internet/samples/html/country-list.html");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/p[2]/select"))).click();
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]/select")));
        dropdown.selectByVisibleText("Armenia");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/p[2]/select"))).click();
    }

    @After
    public void exit() {
        driver.close();

    }
}
