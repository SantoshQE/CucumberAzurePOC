package Stepdefinitions;

import Config.TestBase;
import Pages.swtContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
}
