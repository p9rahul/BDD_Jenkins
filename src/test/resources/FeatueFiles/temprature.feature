Feature: open weather map application

  @Smoke
  Scenario: 1.Verify all menu & links on the page
    Given Starts on the "https://openweathermap.org/"
    Then verify below links on the website
      | Support Center                 |
      | Weather in your city            |
      | 5 day / 3 hour weather forecast |
      | 16 day / daily weather forecast |

  @Smoke1
  Scenario: 2.Verify invalid city temperature
    Given Starts on the "https://openweathermap.org/"
    When Enters an invalid city name "abcdef"
    Then Searches for the weather
    And Verifies that website suggests city is "Not found"

  @Smoke1
  Scenario: 3.Verify valid city temperature
    Given Starts on the "https://openweathermap.org/"
    When Enters an valid city name "Bangalore"
    Then Searches for the weather
    And Verifies that website successfully returns weather details for the city "Bangalore"

  @Smoke1
  Scenario: 4.Verify links inside the maps dropdown
    Given Starts on the "https://openweathermap.org/"
    When Click on the "Maps" dropdown link
    Then verify below links inside the maps
      | Weather maps           |
      | Current satellite maps |
      | Beautiful places       |
