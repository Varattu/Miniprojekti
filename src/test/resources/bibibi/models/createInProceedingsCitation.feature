Feature: As a user I want to add InProceedings citations in a human readable form.

  Scenario: User can set citation type "inproceeding"
    Given New citation is initialized
    When User sets inproceedings citation type "INPROCEEDINGS"
    Then The inproceedings citation type should be "INPROCEEDINGS"

  Scenario: User can set inproceedings citation key
    Given New citation is initialized
    When User sets inproceedings citation key "TEST66"
    Then The inproceedings citation key should be "TEST66"

  Scenario: User can set inproceedings citation title
    Given New citation is initialized
    When User sets inproceedings citation title "Test title"
    Then The inproceedings citation title should be "Test title"

Scenario: User can set inproceedings citation year
    Given New citation is initialized
    When User sets inproceedings citation year 1964
    Then The inproceedings citation year should be 1964