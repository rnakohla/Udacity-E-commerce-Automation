@smoke
Feature: F04_MyAccount | users could change their passwords

  Scenario: user can change his password
    Given registered user with "test33@test.com" and "123456"
    When  user goes to my account page
    And  user change his password by entering "123456" and the "52525252"
    Then password changed successfully





