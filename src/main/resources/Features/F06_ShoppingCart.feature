@smoke
Feature: User can Add products on shopping cart

  Scenario: user can add product to wishes list from search result page
    Given user Search by "MacB"
    When Search result appear successfully
    And user add  product to Shopping cart
    Then selected product is added to shopping cart successfully


  Scenario: verify remove products from shopping cart
    Given user Search again by "MacB"
    When Search result appeared successfully
    And Add first product to Shopping cart
    Then Remove product from shopping cart
