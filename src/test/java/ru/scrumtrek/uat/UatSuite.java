package ru.scrumtrek.uat;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.scrumtrek.uat.features.UatMainflow;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        UatMainflow.class
})
public class UatSuite {
}
