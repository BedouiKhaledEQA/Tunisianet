Feature: login Functionality
  @log-01
  Scenario: login with valid credential
    Given User open the browser
    When  User fill the email and password and click on login button
    Then  User should navigate at Homepage