package ru.scrumtrek.uat.steps;

import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import ru.scrumtrek.domain.Line;
import ru.scrumtrek.selenium.WebDriverFactory;
import ru.scrumtrek.selenium.pages.MainPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {
    private static WebDriver webDriver;
    private static MainPage mainPage;

    @Пусть("^система установлена и доступна для пользователей в браузере$")
    public void setup() {
        webDriver = WebDriverFactory.getWebDriver();
        mainPage = MainPage.open(webDriver);
    }

    @Если("^пользователь закрывает браузер?")
    public void tearDown() {
        mainPage = null;
        webDriver.close();
        webDriver.quit();
        webDriver = null;
    }

    @Если("^пользователь заходит на главный экран системы?")
    public void checkMainPagе() {
        assertThat(mainPage).isNotNull();
    }

    @Тогда("^он видит пустой список элементов?")
    public void checkEmptyList() {
        List<Line> lines = mainPage.getLines();
        assertThat(lines).isNotNull();
        assertThat(lines).isEmpty();
    }
}
