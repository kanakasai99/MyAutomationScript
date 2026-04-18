Feature: Just a Invalid login practice

  Scenario Outline: I want to test practice login page with Scenario outline
    Given the page is login page
    When I login with different "<username>" and "<password>"
    Then the outcome should be "<expected>"
    Examples:
      |username|password|expected|
      |student|Password123|success|
      |sai    |Sai1234   |error  |