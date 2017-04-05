Feature: As a user I want to add article citations in a human readable form.

  Scenario: User can create a new citation
    Given User enters title "The Ultimate Meaning of Life"
    And User enters author "Doe, John"
    And User enters year "1952"
    And User selects type "Article"
    When User presses Add citation -button
    Then The user gives infomessage about success.
