@US_001
Feature: User should be able to see his/her name and age on the screen based on his/her credentials

  Background:
    Given user goes to homepage and verifies it


  @TC_001
  Scenario Outline: (Positive Scenario) TC_001 user should able to find their name and age using valid credentials

    When user enters a name "<name>"
    And user enters a date of birth "<day>","<month>","<year>"
    And user clicks on submit button
    Then user verifies the name and age
    Examples:
      | name   | day | month | year |
      | gurhan | 18  | 08    | 2001 |
      | gurhan | 01  | 01    | 1900 |


  @TC_002
  Scenario Outline: (Negative Scenario-1) TC_002 user should be able to get a "incorrect symbols" warning message
  after leaving "your name" part empty or entering special characters or numbers

    When user enters a name "<name>"
    And user enters a date of birth "<day>","<month>","<year>"
    And user clicks on submit button
    Then user verifies the warning message "incorrect symbols"
    Examples:
      | name  | day | month | year |
      |       | 18  | 08    | 2001 |
      | #$%^& | 12  | 10    | 1987 |
      | 23451 | 12  | 10    | 1987 |


  @TC_003
  Scenario Outline: (Negative Scenario-2) TC_003 user should be able to get a "wrong date" warning message
  after entering invalid date

    When user enters a name "<name>"
    And user enters a date of birth "<day>","<month>","<year>"
    And user clicks on submit button
    Then user verifies the warning message "wrong date"
    Examples:
      | name | day | month | year  |
      | jack | 30  | 02    | 2001  |
      | jack | 31  | 06    | 2001  |
      | jack | 12  | 10    | 10000 |
      | jack | 11  | 10    | 10001 |


  @TC_004
  Scenario Outline: (Negative Scenario-3) TC_004 user should be able to get a "your birthday must be in the past"
  warning message after entering a date in from the future

    When user enters a name "<name>"
    And user enters a date of birth "<day>","<month>","<year>"
    And user clicks on submit button
    Then user verifies the warning message "your birthday must be in the past"
    Examples:
      | name | day | month | year |
      | tom  | 25  | 09    | 2023 |
      | tom  | 01  | 02    | 2024 |
      | tom  | 01  | 02    | 2555 |
      | tom  | 31  | 12    | 9999 |


  @TC_005
  Scenario Outline: (Negative Scenario-4) TC_005 user should be able to get a " you are too old to use it"
  warning message after entering a date in from the future

    When user enters a name "<name>"
    And user enters a date of birth "<day>","<month>","<year>"
    And user clicks on submit button
    Then user verifies the warning message " you are too old to use it"
    Examples:
      | name  | day | month | year |
      | lynda | 31  | 12    | 1899 |
      | lynda | 01  | 02    | 1200 |















