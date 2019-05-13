package ru.scrumtrek.uat.steps;

import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import ru.scrumtrek.domain.Line;
import ru.scrumtrek.selenium.WebDriverFactory;
import ru.scrumtrek.selenium.pages.MainPage;

import java.util.List;
import java.util.Map;

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

    @Тогда("^при открытии системы в браузере пользователь видит главный экран системы$")
    @Если("^пользователь заходит на главный экран системы?")
    public void checkMainPagе() {
        assertThat(mainPage).isNotNull();
    }

    @И("^вводит в поле для добавления нового элемента значения и нажимает на кнопку ввода:$")
    public void addNewValue(DataTable table) {
        List<String> values = table.asList();
        values.forEach(mainPage::addLine);
    }

    @И("^он нажимает на кнопку удаления всех элементов$")
    public void removeAllElements() {
        mainPage.removeLines();
    }

    @Тогда("^он видит пустой список элементов?")
    public void checkEmptyList() {
        List<Line> lines = mainPage.getLines();
        assertThat(lines).isNotNull();
        assertThat(lines).isEmpty();
    }

    @Тогда("^пользователь видит в списке (\\d+) элемента$")
    public void checkElementsCount(int elementsExpected) {
        List<Line> lines = mainPage.getLines();
        assertThat(lines.size()).isEqualTo(elementsExpected);
    }

    @Тогда("^он видит в списке элементов:$")
    public void checkElementsList(DataTable table) {
        List<Map<String, String>> rows = table.asMaps();
        Line[] expectedLines = rows.stream().
                map(k -> new Line(Integer.valueOf(k.get("id")), k.get("result"))).
                toArray(Line[]::new);
        List<Line> lines = mainPage.getLines();
        assertThat(lines).containsOnly(expectedLines);
    }

    @Тогда("^(?:пользователь|он) видит окно с ошибкой$")
    public void checkErrorPopupVisibility() {
        assertThat(mainPage.isErrorPopupVisible()).isTrue();
    }

    @И("^текст ошибки \"([^\"]*)\"$")
    public void checkErrorText(String errorText) {
        assertThat(mainPage.getErrorPopupText()).isEqualTo(errorText);
    }

    @И("^закрывает окно с ошибкой$")
    public void checkPopupClosing() {
        mainPage.closeErrorPopup();
        assertThat(mainPage.isErrorPopupVisible()).isFalse();
    }

    @Тогда("^заканчиваем тестирование$")
    public void checkBrowserIsClosed() {
        assertThat(mainPage).isNull();
    }
}
