package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src\\test\\resources\\Features",
        glue="Stepdefinitions",
        strict = true,
        plugin = { "pretty", "junit:target/cucumber-reports/Cucumber_Results.xml","json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-reports"},
        monochrome = true
)
public class TestRunner_SWTestAcademy
{

}
