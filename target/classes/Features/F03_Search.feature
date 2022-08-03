@smoke
Feature: F03_Search | users could search on existing products using sku

  Scenario Outline : user can search product
    Given user search on product using "<SKU>"
    When  search results displayed successfully
    Then search results displayed successfully
    Examples:
      |SKU|
      | TC_78I_UN |


