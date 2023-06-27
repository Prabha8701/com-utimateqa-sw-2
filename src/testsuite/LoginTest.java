package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @After
    public void closeDown(){
       // closeBrowser();
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        //Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";
        String actualText= driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();

        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("Prime123");

        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("prime123");

        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        String expectedText="Invalid email or password.";
       String actualText= driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals(expectedText,actualText);

    }
}
