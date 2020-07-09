package Runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/LoginFeature", glue = {"Hooks", "TestStep","Ultilities"}, plugin = {"pretty", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"})
public class LoginRunner {
}
