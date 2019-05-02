package ru.scrumtrek.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.scrumtrek.domain.Line;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.getProperty;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MainPage {
    private WebDriver driver;
    private final WebDriverWait wait;

    private MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    private static String getUrl() {
        String driverType = getProperty("selenium-webdriver");
        return null == driverType || "local".equals(driverType) ?
                "http://localhost:8080" :
                "http://ui-service:8080";
    }

    public static MainPage open(WebDriver driver) {
        driver.get(getUrl());
        return new MainPage(driver);
    }

    public List<Line> getLines() {
        List<WebElement> webLines = driver.findElements(By.xpath("//div[@data-find='line-row']"));
        return webLines.stream().map(Line::of).collect(Collectors.toList());
    }

    public void addLine(String text) {
        WebElement textBox = driver.findElement(By.xpath("//input[@id='line-name']"));
        WebElement button = driver.findElement(By.id("line-add-button"));
        textBox.clear();
        textBox.sendKeys(text);
        button.click();
        wait.until(
                or(
                        presenceOfElementLocated(
                                By.xpath("//div[@data-find='line-name' and contains(text(), '" + text + "')]")
                        ),
                        presenceOfElementLocated(
                                By.id("__BVID__3")
                        )
                )
        );
    }

    public void removeLines() {
        WebElement button = driver.findElement(By.xpath("//button[contains(text(), 'Delete all')]"));
        button.click();
    }
}
