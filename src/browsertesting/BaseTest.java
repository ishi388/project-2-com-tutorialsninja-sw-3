package browsertesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    //launching the browser
    public void openBrowser(String baseUrl)
    {

        driver = new ChromeDriver(); // set up the browser
        driver.get(baseUrl); // opening the Url
        driver.manage().window().maximize(); // maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //Giving implicit wait

    }

    //Closing the browser

    public void closeBrowser()
    {
        driver.close();
    }

}
