package ru.scrumtrek.uat;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages({"ru.scrumtrek.uat.feature"})
public class UatSuite {
}
