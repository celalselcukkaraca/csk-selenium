Feature: Beyoglu Municipality

  Scenario Outline: Beyoglu Municipality Land Square Meter Unit Value Search
    Given the user navigates to the Beyoglu Municipality Land Market Values Search page
    When the user enters the following details: '<neighborhood>', '<street>', '<year>' and clicks the search button
    Then the user should see the results '<neighborhood>', '<street>', '<year>'
    Examples:
      | neighborhood      | street                | year |
      | ASMALIMESCİT MAH. | ASMALI MESCİT CADDESİ | 2022 |
      | BOSTAN MAH.       | GÜLFİDAN SK.          | 2019 |
