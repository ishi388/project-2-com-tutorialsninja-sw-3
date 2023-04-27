package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountOptionList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        try {
            for (WebElement option1 : myAccountOptionList) {
                if (option1.getText().equals(option)) {
                    option1.click();
                }

            }
        }catch (StaleElementReferenceException e)
        {
            myAccountOptionList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
        }

    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully()throws InterruptedException
    {
        Thread.sleep(2000);
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        selectMyAccountOptions("Register");
        String actualMessage = driver.findElement(By.xpath("//h1[normalize-space()='Register Account']")).getText();
        verifyElementMethod("Register Account",actualMessage);

    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException
    {
        Thread.sleep(2000);
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        selectMyAccountOptions("Login");
        String actualMessage = driver.findElement(By.xpath("//h2[normalize-space()='Returning Customer']")).getText();
        Assert.assertEquals("Returning Customer",actualMessage);

    }

    @Test

    public void verifyThatUserRegisterAccountSuccessfully()
    {
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        selectMyAccountOptions("Register");
        sendTextToElement(By.id("input-firstname"),"Abc");
        sendTextToElement(By.id("input-lastname"),"Malhotra");
        sendTextToElement(By.id("input-email"),"abc5900@gmail.com");
        sendTextToElement(By.id("input-telephone"),"1284567890");
        sendTextToElement(By.id("input-password"),"abc123");
        sendTextToElement(By.id("input-confirm"),"abc123");
        clickOnElement(By.xpath("//label[normalize-space()='Yes']"));
        clickOnElement(By.xpath("//input[@name='agree']"));
        clickOnElement(By.xpath("//input[@value='Continue']"));
        String actualMessage = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
        Assert.assertEquals("Your Account Has Been Created!",actualMessage);
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        selectMyAccountOptions("Logout");
        String actualMessageAccount = driver.findElement(By.xpath("//h1[normalize-space()='Account Logout']")).getText();
        Assert.assertEquals("Account Logout",actualMessageAccount);
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));



    }

    @Test

    public void verifyThatUserShouldLoginAndLogoutSuccessfully()
    {
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        selectMyAccountOptions("Login");
        sendTextToElement(By.xpath("//input[@id='input-email']"),"abc5900@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-password']"),"abc123");
        clickOnElement(By.xpath("//input[@value='Login']"));
        String actualMessageMyAccount = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).getText();
        Assert.assertEquals("My Account",actualMessageMyAccount);
        clickOnElement(By.xpath("//i[@class='fa fa-user']"));
        selectMyAccountOptions("Logout");
        String actualMessageAccount = driver.findElement(By.xpath("//h1[normalize-space()='Account Logout']")).getText();
        Assert.assertEquals("Account Logout",actualMessageAccount);
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }
    @After
    public void tearDown() {

        closeBrowser();
    }

}
