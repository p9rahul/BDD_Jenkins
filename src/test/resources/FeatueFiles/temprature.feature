Feature: open weather map application


  @Smoke
  Scenario: 1.Verify all menu & links on the page
    Given Starts on the "https://openweathermap.org/"
    Then verify below links on the website
      | Support Center                       |
      | Sign Up                              |
      | Sign In                              |
      | Weather in your city                 |
      | Weather                              |
      | Maps                                 |
      | Guide                                |
      | API                                  |
      | Price                                |
      | Partners                             |
      | Stations                             |
      | Widgets                              |
      | Blog                                 |
      | Main                                 |
      | Daily                                |
      | Hourly                               |
      | Chart                                |
      | Map                                  |
      | More weather in your city            |
      | www.agromonitoring.com               |
      | www.agromonitoring.com               |
      | blog                                 |
      | info@openweathermap.org              |
      | How to start                         |
      | Move to agromonitoring.com           |
      | Forecast & Historical weather map    |
      | 15 Weather map layers                |
      | Interactive current weather map      |
      | Read more                            |
      | View solutions                       |
      | Try Free APIs                        |
      | Connect                              |
      | Support center                       |
      | privacy policy.                      |
      | Find your city                       |
      | Weather maps                         |
      | How to start                         |
      | Weather APIs for developers          |
      | Current weather                      |
      | Hourly historical data               |
      | History bulk                         |
      | Examples of API use                  |
      | Examples of weather map layers       |
      | Map styles legend                    |
      | Libraries to connect weather layers  |
      | Price-list                           |
      | Subscribe to APIs                    |
      | Support center                       |
      | How to connect your weather station  |
      | About company                        |
      | Team                                 |
      | Weather model                        |
      | Terms and conditions of sale         |
      | Privacy policy                       |
      | Websites terms and conditions of use |
      | Our team                             |
      |	5 day / 3 hour weather forecast      |
      |	16 day / daily weather forecast      |

  @Smoke
  Scenario: 2.Verify invalid city temperature
    Given Starts on the "https://openweathermap.org/"
    When Enters an invalid city name "abcdef"
    Then Searches for the weather
    And Verifies that website suggests city is "Not found"

  @Smoke
  Scenario: 3.Verify valid city temperature
    Given Starts on the "https://openweathermap.org/"
    When Enters an valid city name "Bangalore"
    Then Searches for the weather
    And Verifies that website successfully returns weather details for the city "Bangalore"

  @Smoke
  Scenario: 4.Verify links inside the maps dropdown
    Given Starts on the "https://openweathermap.org/"
    When Click on the "Maps" dropdown link
    Then verify below links inside the maps
      | Weather maps           |
      | Current satellite maps |
      | Beautiful places       |
