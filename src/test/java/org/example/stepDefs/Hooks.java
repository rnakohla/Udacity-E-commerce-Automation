package org.example.stepDefs;

import io.cucumber.java.*;
import org.example.utilities.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;


    @Before
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");

    }

    @After
    public void stopDriver() throws InterruptedException {
        driver.quit();

    }

}
