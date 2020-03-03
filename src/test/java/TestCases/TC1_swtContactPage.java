package TestCases;

import Config.TestBase;
import Config.TestResultLoggerExtension;
import Pages.swtContactPage;
import Utils.TestUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith({TestResultLoggerExtension.class})
//@DisplayName("Test Case --> Verify Software academy website's contacts entry page")
public class TC1_swtContactPage extends TestBase
{
    public static swtContactPage swtContactPg ;
    public static TestBase init ;
    public static TestBase extentTestbase;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach()
    void init(TestInfo testInfo,TestReporter testReporter)
    {
         this.testInfo = testInfo;
         this.testReporter= testReporter;
       //  System.out.println(this.testInfo.getTestMethod().toString());
         //testReporter.publishEntry(" publish entry test -- : " + testInfo.getTestMethod().toString());
    }

    @BeforeAll()
    public static void launchBrowser_Chrome()
    {
       // System.out.println("Inside @BeforeTest --launchBrowser_Chrome ");
        TestBase.open_Browser("Chrome");
        swtContactPg = new swtContactPage(driver);
        swtContactPg.launchSwtAcademySite("https://www.swtestacademy.com/");

    }
   //@DisplayName("TestStepnavigateToContactsPage")
    @Test( ) @Order(1)
    public void navigateToContactsPage(TestReporter testReporter) throws Throwable
    {
        swtContactPg.clickContactsLink();
        System.out.println("inside navigateToContactsPage ... executed");
        System.out.println(testInfo.getTestMethod().toString());
        testReporter.publishEntry(" publish entry test -- : " + testInfo.getTestMethod().toString());
    }
   // @DisplayName("Test Step --> enterContactDetails")
    @Test() @Order(2)
    public void enterContactDetails(TestReporter testReporter) throws Throwable
    {
        swtContactPg.fillContactDetails("TestUser","TestUser@gmail.com","Testsubject","Testmessage");
        System.out.println(this.testInfo.getTestMethod().toString());
        testReporter.publishEntry(" publish entry test -- : " + testInfo.getTestMethod().toString());
    }
    @AfterAll() //Teardown steps close the borser
    public static void tearDown_Chrome() throws IOException {
        if(driver!=null)
        {
            driver.close();
        }

    }
}
