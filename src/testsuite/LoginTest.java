package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {


        //find username field
        WebElement userNamefield = driver.findElement(By.xpath("//input[@id='user-name']"));
        userNamefield.sendKeys("standard_user");

        //find password and fill password field
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //Find the login button Element and click
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
        loginButton.click();

        //Verify the text "PRODUCTS"
        String expectedMessage = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //find username field
        WebElement userNamefield = driver.findElement(By.xpath("//input[@id='user-name']"));
        userNamefield.sendKeys("standard_user");

        //find password and fill password field
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //Find the login button Element and click
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
        loginButton.click();

        List<WebElement> number = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualnumber = number.size();
        int expectednumber = 6;
        Assert.assertEquals("6 product not displayed", expectednumber, actualnumber);

    }
      @After
    public void close(){
        driver.quit();
      }

}
