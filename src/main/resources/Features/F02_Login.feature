@smoke
Feature: F02_Login | users could use login functionality to use their accounts

 Scenario Outline: user could login with valid email and password
   Given registered user with "<email>" and "<password>" logout to go to login page
   When user login with valid "<email>" and "<password>"
   Then user login to the system successfully
   Examples:
     |email | password|
     |valid1@valid.com|123456  |




  Scenario Outline: user couldn't login with invalid email and password
  Given user go to login page
  When user login with invalid "<invalidEmail>" and "<password>"
  Then user could not login to the system
    Examples:
      |invalidEmail |password|
      |invalid@invalid.com|123456  |