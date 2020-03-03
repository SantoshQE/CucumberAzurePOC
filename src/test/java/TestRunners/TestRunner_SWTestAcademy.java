package TestRunners;

import Utils.TestUtil;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;

import java.io.IOException;

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
/*    @AfterAll
    public void checkifRunFinished() throws IOException
    {
        System.out.println("Inside checkifRunFinished..");
        TestUtil.convertJSONToXML();
    }*/
    @BeforeClass
    public static void setup() {
        System.out.println("Ran the before");
    }

    @AfterClass
    public static void teardown() throws IOException {
        System.out.println("Ran the after");
        TestUtil.convertJSONToXML();
    }
}
