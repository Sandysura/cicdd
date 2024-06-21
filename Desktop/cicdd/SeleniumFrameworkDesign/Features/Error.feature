
@tag
Feature: Error validation
  I want to use this template for my feature file

  Background:
  Given I landed on Ecommerce Page
  
  @Errorhandling
  Scenario Outline: Title of your scenario outline
    When Logged in with username "<username>" and "<password>"
    Then "Incorrect email or password." message is displayed

    Examples: 
      | username                   | password      |
      | sandysura23@gmail.com |     Sandy123@ |
      
