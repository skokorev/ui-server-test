package ru.scrumtrek.selenium;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.System.getProperty;

public class WebDriverFactory {

    public static WebDriver getWebDriver()  {
        String driverType = getProperty("selenium-webdriver");
        if (null == driverType || "local".equals(driverType))
            return createLocalWebdriver();
        return createRemoteWebdriver();
    }

    private static WebDriver createLocalWebdriver() {
        String webdriver = System.getenv("WEBDRIVER_PATH");
        System.setProperty("webdriver.chrome.driver",
                null != webdriver ?
                        webdriver :
                        "/opt/chromedriver/chromedriver");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        //options.addArguments("--no-sandbox");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().setSize(new Dimension(1600, 1200));
        return driver;
    }

    private static WebDriver createRemoteWebdriver() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
                    options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
