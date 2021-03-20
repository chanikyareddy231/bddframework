Feature: Gmail login

  @realtest
  Scenario Outline: Valid password in login page
    Given launch site using "<bn>"
    When enter userid as "chanikyareddy231"
    And  click userid next button
    And enter password as "<pwd>"
    And click password next button
    Then Validate outcome related to given password criterialike"<pwdcriteria>"
    When close site

    Examples: 
      |   pwd         |  pwdcriteria  |     bn     |
      | Chanikya231   |   valid       |    chrome  |
      | Chanikya231   |   valid       |    firefox |
      | Chanikya231   |   valid       |    opera   |
      | Chanikya231   |   valid       |    edge    |
      | Chanikya232   |   invalid     |    chrome  |
      | Chanikya232   |   invalid     |    firefox |
      | Chanikya232   |   invalid     |    opera   |
      | Chanikya232   |   invalid     |    edge    |
      |               |   blank       |    chrome  |
      |               |   blank       |    firefox |
      |               |   blank       |    opera   |
      |               |   blank       |    edge    |