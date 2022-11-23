package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

import javax.swing.text.Utilities;

public class LoginTest extends Utility {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter a valid user name
        sendTextToElement(By.id("username"),"tomsmith");
        //Enter a valid Password
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        //Click on login button
        clickOnElement(By.xpath("//button[@class = 'radius']"));
        String expectedText = "Secure Area";
        String actualText = getTextFromElement(By.xpath("//div[@'class ='div'/h2"));
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter a valid user name
        sendTextToElement(By.id("username"),"tomsmith");
        //Enter a valid Password
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        //Click on login button
        clickOnElement(By.xpath("//button[@class = 'radius']"));
        //Error message "Your username is invalid"
        String expectedMessage = "Your username is invalid";
        String actualMessage = getTextFromElement(By.xpath("//div[@class = 'flash error']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter a valid user name
        sendTextToElement(By.id("username"),"tomsmith");
        //Enter a valid Password
        sendTextToElement(By.name("password"),"SuperSecretPassword!");
        //Click on login button
        clickOnElement(By.xpath("//button[@class = 'radius']"));
        //Error message "Your password is invalid"
        String expectedMessage = "Your password is invalid";
        String actualMessage = getTextFromElement(By.xpath("//div[@class = 'flash error']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}
