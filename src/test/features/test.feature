Feature: Test google launch

  Background: Rum the background steps

  Scenario: Validate the title of the app
    Given launch the URL
    Then validate the title of the page


  Scenario Outline: Search anything on the web
    Given launch the URL
    Then search for keyword in google <keyword>
    Examples:
      | keyword  |
      | "google" |