Feature: Software Test Academy functionalities

Scenario: Verify that user is able to navigate to contacts page
  Given User is on Software Test Academy site Home Page
  When he clicks on contacts link
  Then contacts page is displayed
  Then User closes the browser
