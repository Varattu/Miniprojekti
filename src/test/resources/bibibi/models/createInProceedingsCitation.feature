Feature: As a user I want to add InProceedings citations in a human readable form.

  Scenario: User can create a new InProceedings citation
    Given User enters title "The Ultimate Meaning of Life"
    And User enters author "Doe, John"
    And User enters year "1952"
    And User enters booktitle "Cool booktitle"
    And User selects type "INPROCEEDINGS"
    When User presses Add citation -button
    Then The system gives infomessage about success.
