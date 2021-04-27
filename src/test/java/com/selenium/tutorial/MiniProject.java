package com.selenium.tutorial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RunWith(MockitoJUnitRunner.class)
public class MiniProject {

    WebDriver driver;
    WebDriverWait driverWait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/jincyanto/Downloads/chromedriver");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, 10);
    }


    @Test
    public void registration() {
        try {
            driver.navigate().to("http://automationpractice.com/index.php");
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"))).click();

            String emailId ="janedoe"+Math.random()+"@gmail.com";

            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email_create\"]"))).sendKeys(emailId);
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //*[@id=\"SubmitCreate\"]/span"))).click();
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"id_gender2\"]"))).click();
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer_firstname\"]"))).sendKeys("Jane");
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customer_lastname\"]"))).sendKeys("Doe");
            driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwd\"]"))).sendKeys("password@123");

            Select daysDropdown = new Select(getVisibilty("//*[@id=\"days\"]"));
            daysDropdown.selectByValue("1");
            Select monthDropDown = new Select(getVisibilty("//*[@id=\"months\"]"));
            monthDropDown.selectByValue("1");
            Select yearDropDown = new Select(getVisibilty("//*[@id=\"years\"]"));
            yearDropDown.selectByValue("1994");

            getVisibilty("//*[@id=\"firstname\"]").sendKeys("Jane");
            getVisibilty("//*[@id=\"lastname\"]").sendKeys("Doe");
            getVisibilty("//*[@id=\"company\"]").sendKeys("XYZ");
            getVisibilty("//*[@id=\"address1\"]").sendKeys("ABC lane");
            getVisibilty("//*[@id=\"city\"]").sendKeys("City");

            Select stateDropdown = new Select(getVisibilty("//*[@id=\"id_state\"]"));
            stateDropdown.selectByVisibleText("Michigan");

            getVisibilty("//*[@id=\"postcode\"]").sendKeys("48005");
            getVisibilty("//*[@id=\"phone_mobile\"]").sendKeys("9876543210");
            getVisibilty("//*[@id=\"alias\"]").sendKeys("Same as above address");
            getVisibilty("//*[@id=\"submitAccount\"]/span").click();

            Files.write(Paths.get("/Users/jincyanto/SeleniumWebDriverTutorial/SeleniumWebDriver/src/test/java/resources/EMAILS"), (emailId+"\n").getBytes(),
                    StandardOpenOption.APPEND);

            System.out.println(driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"))).getText());
            Assert.assertEquals("Jane Doe",driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"))).getText());

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void signIn(){
        driver.navigate().to("http://automationpractice.com/index.php");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a"))).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email_create\"]"))).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]"))).sendKeys("janedoe@gmail.com");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwd\"]"))).sendKeys("password@123");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"SubmitLogin\"]/span"))).click();
    }

    public WebElement getVisibilty(String xpath){

        WebElement ele = driver.findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",ele);

        return ele;

    }

}
