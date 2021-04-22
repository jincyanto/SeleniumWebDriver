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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(MockitoJUnitRunner.class)
public class CheckBoxTutorial {

    WebDriver driver;
    WebDriverWait driverWait;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/jincyanto/Downloads/chromedriver");
        driver=new ChromeDriver();
        driverWait= new WebDriverWait(driver,3);
    }

    @Test
    public void chkboxClick(){

        driver.navigate().to("http://automationpractice.com/index.php");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"))).click();
        WebElement check_box1 = driver.findElement(By.xpath("//*[@id=\"layered_category_4\"]"));
        check_box1.click();
        System.out.println("chkbox1 clicked");
        WebElement check_box2 = driver.findElement(By.xpath("//*[@id=\"layered_id_attribute_group_2\"]"));
        check_box2.click();
        System.out.println("chkbox2 clicked");
        WebElement check_box3 = driver.findElement(By.xpath("//*[@id=\"layered_id_feature_5\"]"));
        check_box3.click();
        System.out.println("chkbox3 clicked");
    }

    @Test
    public void chkboxUnClick(){

        driver.navigate().to("http://automationpractice.com/index.php");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a"))).click();
        WebElement check_box1 = driver.findElement(By.xpath("//*[@id=\"layered_category_4\"]"));
        check_box1.click();
        System.out.println("chkbox1 clicked");
        check_box1.click();
        System.out.println("chkbox1 unclicked");
    }

   @After
    public void exit(){
        driver.close();
    }

}


