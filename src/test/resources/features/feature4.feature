
Feature: Gmail compose
  I want to use this template for my feature file

  @realtest
  Scenario: Validate mail compose
    Given launch site using "chrome"
    When enter userid as "chanikyareddy231"
    And click userid next button
    And enter password as "Chanikya231"
    And click password next button
    And send mail and test by taking data from excel
    When do logout
    And quit site