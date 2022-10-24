@Demo
Feature: As a potential client i want to interact with the mobile application

  Background:
    Given The app is loaded correctly

  @Register
  Scenario: Register a random new user
    When The user goes to the Sign Up page
    And The user registers a new user
    Then Home page is displayed

  @Login
  Scenario Outline: The user log in to the app.
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed

    Examples:
      | email                | password   |
      | nahuelpaco@gmail.com | Nahuel.123 |

  @AddTime
  Scenario Outline: Add time
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed

    When click on Add time entry button
    And Add hours '<hours>'
    And Add minutes '<minutes>'
    And Save new time
    Then Verify added time

    When Delete entry
    Then verify no time entries

    Examples:
      | email                | password   | hours | minutes |
      | nahuelpaco@gmail.com | Nahuel.123 | 05    | 30      |

  @Logout
  Scenario Outline: The user log in to the app.
    When The user logs in the application with: <email>, <password>
    Then Home page is displayed

    When Logout
    Then Verify logout

    Examples:
      | email                | password   |
      | nahuelpaco@gmail.com | Nahuel.123 |