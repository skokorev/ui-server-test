package ru.scrumtrek.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@AllArgsConstructor
@EqualsAndHashCode(exclude = {"id"})
public class Line {
    @Getter private int id;
    @Getter private String name;

    public static Line of(WebElement line) {
        String id = line.findElement(By.xpath("div[@data-find='line-id']")).getText();
        String name = line.findElement(By.xpath("div[@data-find='line-name']")).getText();
        return new Line(Integer.valueOf(id), name);
    }
}
