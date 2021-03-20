Feature: Gmail compose

  @smoketest
  Scenario: Validate mail compose
    Given launch site using "chrome"
    When enter userid as "chanikyareddy231"
    And click userid next button
    And enter password as "Chanikya231"
    And click password next button
    And send mail and test
    |      to                                   |   subject |  body |   attachment                                                           |
    |    chinnapureddymahesh55555@gmail.com     |   wishes  |  hi   |   C:\images\seleniumworkspacepath.png  |
    |    chanikyareddy231@gmail.com             |   wishes  |  hi   |   C:\images\seleniumworkspacepath.png  |
      
    When do logout
    And quit site  
      