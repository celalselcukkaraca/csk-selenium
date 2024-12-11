Feature: On-Duty Pharmacy Search Feature

  Scenario Outline: Pharmacy Search
    Given the user navigates to the OnDuty Pharmacy Search page
    When the user enters the following details: '<city>', '<date>' and clicks the search button
    When the user selects district: '<district>'
    Then the table should be filtered by '<district>'
    When the user clicks show on the map button
    Then the map should be displayed
    Examples:
      | city    | district | date       |
      | ANKARA  | Çankaya  | 10/12/2024 |
      | KOCAELİ | Gölcük   | 11/12/2024 |