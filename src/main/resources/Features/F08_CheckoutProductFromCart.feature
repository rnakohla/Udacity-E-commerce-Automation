@smoke
Feature: Guest users can checkout product from on E-commerce web site

  Scenario: verify user checkout products successfully
    Given user search on product "MacB"
    When   Search results appear successfully
    And   user add this product to Shopping cart
    And user Can Checkout Products
    Then user Can View Order Details
