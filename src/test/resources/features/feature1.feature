Feature: Gmail Login

Background:
   Given launch site using "chrome"
   
 @smoketest  
 Scenario: Validate Gmail home page tittle
         Then tittle should be "Gmail"
         When close site
         
  @smoketest       
  Scenario Outline: Validate userid in home page
    When enter userid as "<uid>"
    And  click userid next button
    Then Validate outcome related to given userid criterialike "<uidcriteria>"
    When close site

    Examples: 
      |   uid            |  uidcriteria   |
      | chanikyareddy231 |  valid         |
      | chanikyaredddy231| 	invalid       |
      |                  | 	blank         |