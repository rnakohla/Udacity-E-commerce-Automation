@smoke
Feature: F01_Register | users could register with new accounts
 Scenario Outline: guest user could register with valid data successfully
    Given user go to register page
    When user clicks on Registration Link
    And  user enters "<firstname>","<lastname>","<email>","<password>"
    Then the registration page displayed successfully
   Examples:
     |firstname |lastname |email |password |
     |Rana |Ahmed |rna@gmail.com |12345678 |
     |Test |test2 |test22@gmail.com |1234567|
