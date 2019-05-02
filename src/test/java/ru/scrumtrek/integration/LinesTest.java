package ru.scrumtrek.integration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import ru.scrumtrek.domain.Line;
import ru.scrumtrek.selenium.WebDriverFactory;
import ru.scrumtrek.selenium.pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LinesTest {
    private static WebDriver webDriver;
    private static MainPage mainPage;

    @BeforeAll
    public static void setUp() {
        webDriver = WebDriverFactory.getWebDriver();
        mainPage = MainPage.open(webDriver);
    }

    @AfterAll
    public static void tearDown() {
        mainPage = null;
        webDriver.close();
        webDriver.quit();
        webDriver = null;
    }

    @Test
    @Order(1)
    public void checkEmptyLinesList() {
        List<Line> lines = mainPage.getLines();
        assertThat(lines).isNotNull();
        assertThat(lines).isEmpty();
    }

    @Test
    @Order(2)
    public void checkAddLineThreeTimes() throws Exception {
        mainPage.addLine("line1");
        mainPage.addLine("line2");
        mainPage.addLine("line3");
        List<Line> lines = mainPage.getLines();
        assertThat(lines).hasSize(3);
    }

    @Test
    @Order(3)
    public void checkAddedLines() {
        List<Line> lines = mainPage.getLines();
        assertThat(lines).containsOnly(
                new Line(0, "line1"),
                new Line(0, "line2"),
                new Line(0, "line3"));
    }

    @Test
    @Order(4)
    public void checkRemoveLines() {
        mainPage.removeLines();
        List<Line> lines = mainPage.getLines();
        assertThat(lines).isNotNull();
        assertThat(lines).isEmpty();
    }
}
