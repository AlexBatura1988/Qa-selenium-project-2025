package com.alex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.ResourceBundle;

public class BaseTest {

    public static WebDriver driver;
    public ResourceBundle rb;

    @BeforeClass
    @Parameters("browser")
    public void setup(ITestContext testContext, String br) {
        rb = ResourceBundle.getBundle("config");

        if (br.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        } else if (br.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        testContext.setAttribute("WebDriver", driver);
        driver.get(rb.getString("appURL"));

    }
}
