@smoke
Feature: F05_ChangeCurrency | users could change currency

  Scenario: user can change currency
    Given user go to product  details page "Apple MacBook Pro 13"
    When  user change currency
    Then currency changed successfully





