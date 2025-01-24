Feature: Search Functionality
  @search-01
  Scenario: Search via search bar
    Given   User open the browser
    When    user fill the item looking for in the searching box and click on search button
    Then    item should be displayed