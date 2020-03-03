package Stepdefinitions;

import Config.TestBase;
import Pages.swtContactPage;
import Utils.TestUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;

public class Stepdef_SWTestAcademy  extends TestBase
{
    public static swtContactPage swtContactPg ;
    public static TestBase init ;
    public static TestBase extentTestbase;

    @Given("User is on Software Test Academy site Home Page")
    public void user_is_on_Software_Test_Academy_site_Home_Page()
    {
        // Write code here that turns the phrase above into concrete actions
        TestBase.open_Browser("Chrome");
        swtContactPg = new swtContactPage(driver);
        swtContactPg.launchSwtAcademySite("https://www.swtestacademy.com/");
        //throw new io.cucumber.java.PendingException();
    }

    @When("he clicks on contacts link")
    public void he_clicks_on_contacts_link() {
        // Write code here that turns the phrase above into concrete actions
        swtContactPg.clickContactsLink();
        System.out.println("inside navigateToContactsPage ... executed");
       // throw new io.cucumber.java.PendingException();
    }

    @Then("contacts page is displayed")
    public void contacts_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        swtContactPg.fillContactDetails("TestUser","TestUser@gmail.com","Testsubject","Testmessage");
       // throw new io.cucumber.java.PendingException();
    }

    @Then("User closes the browser")
    public void userClosesTheBrowser()
    {
        if(driver!=null)
        {
            driver.close();
        }
    }
    @AfterStep
    public void tearDown(Scenario scenario)
    {
        if (scenario.isFailed() == false)
        {
            // Take a screenshot...
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.write("Inside teardown method-->Test Passed");
           // scenario.embed(screenshot, "image/png");
            //scenario.embed([dsds],"gf");
            scenario.embed(screenshot,"image/png","Test");

        }
        if (scenario.isFailed())
        {
            // Take a screenshot...
             final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.write("Inside teardown method -->Test Failed");
            scenario.embed(screenshot,"image/png","Test");
        }
    }
  /*  @After
    public void tearDown2(Scenario scenario)
    {
        if (scenario.isFailed() == false)
        {
            // Take a screenshot...
            //  final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.write("tearDown2 -- Inside teardown method-->Test Passed");
            //scenario.embed(screenshot, "image/png");
        }
        if (scenario.isFailed())
        {
            // Take a screenshot...
            //  final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            // embed it in the report.
            scenario.write("tearDown2 --Inside teardown method -->Test Failed");
            //scenario.embed(screenshot, "image/png");
        }
    }*/
  @After
    public void convertJsonReportToXML() throws IOException
  {
      driver.quit();
      //TestUtil.convertJSONToXML();
     // checkifRunFinished();
  }
    @AfterAll
    public void checkifRunFinished() throws IOException
    {
        System.out.println("Inside checkifRunFinished..");
        TestUtil.convertJSONToXML();
    }
}
