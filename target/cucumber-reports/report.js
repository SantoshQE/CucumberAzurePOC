$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/SoftwareTestAcademy.feature");
formatter.feature({
  "name": "As a user I want to test Software Test Academy ALL functionalities",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Verify that user is able to navigate to contacts page",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User is on Software Test Academy site Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "Stepdefinitions.Stepdef_SWTestAcademy.user_is_on_Software_Test_Academy_site_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Inside teardown method--\u003eTest Passed");
formatter.embedding("image/png", "embedded0.png", "Test");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "he clicks on contacts link",
  "keyword": "When "
});
formatter.match({
  "location": "Stepdefinitions.Stepdef_SWTestAcademy.he_clicks_on_contacts_link()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Inside teardown method--\u003eTest Passed");
formatter.embedding("image/png", "embedded1.png", "Test");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "contacts page is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefinitions.Stepdef_SWTestAcademy.contacts_page_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.write("Inside teardown method--\u003eTest Passed");
formatter.embedding("image/png", "embedded2.png", "Test");
formatter.afterstep({
  "status": "passed"
});
});