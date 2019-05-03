package ru.scrumtrek.uat.features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        tags = {"@MainFlow", "not @Ignore"},
        glue = "ru.scrumtrek.uat.steps"
)
public class UatMainflow {
}
