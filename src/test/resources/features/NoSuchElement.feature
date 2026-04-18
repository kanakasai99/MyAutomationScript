Feature: To check No such element exception

  Scenario: To check the no such elemrnt exception
    Given the user to logged in practice page
    When user enter perform the action
    Then the server responds with nosuchelement exception
