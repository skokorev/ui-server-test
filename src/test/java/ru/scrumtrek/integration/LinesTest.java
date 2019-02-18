package ru.scrumtrek.integration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.scrumtrek.domain.Line;
import ru.scrumtrek.selenium.WebDriverFactory;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinesTest {
    private static WebDriver webDriver;

    @BeforeAll
    public static void setUp() {
        webDriver = WebDriverFactory.getWebDriver();
        webDriver.get("http://ui-service:8080");
    }

    @AfterAll
    public static void tearDown() {
        webDriver.close();
        webDriver.quit();
        webDriver = null;
    }

    @Test
    @Order(1)
    public void checkEmptyLinesList() {
        List<WebElement> lines = webDriver.findElements(By.xpath("//div[@data-find='line-row']"));
        assertThat(lines).isNotNull();
        assertThat(lines).isEmpty();
    }

    @Test
    @Order(2)
    public void checkAddLineThreeTimes() {
        sendLine("line1");
        sendLine("line2");
        sendLine("line3");

        List<WebElement> lines = webDriver.findElements(By.xpath("//div[@data-find='line-row']"));
        assertThat(lines).hasSize(3);
    }

    @Test
    @Order(3)
    public void checkAddedLines() {
        List<WebElement> webLines = webDriver.findElements(By.xpath("//div[@data-find='line-row']"));
        List<Line> lines = webLines.stream().map(Line::of).collect(Collectors.toList());
        assertThat(lines).containsOnly(
                new Line(1, "line1"),
                new Line(2, "line2"),
                new Line(3, "line3"));
    }

    private static void sendLine(String text) {
        WebElement textBox = webDriver.findElement(By.xpath("//input[@id='line-name']"));
        WebElement button = webDriver.findElement(By.id("line-add-button"));
        textBox.clear();
        textBox.sendKeys(text);
        button.click();
    }
}
