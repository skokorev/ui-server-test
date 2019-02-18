package ru.scrumtrek.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver getWebDriver()  {
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
