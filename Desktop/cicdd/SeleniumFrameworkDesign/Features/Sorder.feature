
@tag
Feature: purchase the product from Ecommerce Website
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: positive test for submitting the order
    Given Logged in with username "<name>" and "<password>"
    When I add product "<productName>" to cart
    Then checkout "<productName>" and submit the order

    Examples: 
      | name                   | password      | productName  |
      | sandysura123@gmail.com |     Sandy123@ | ZARA COAT 3 |