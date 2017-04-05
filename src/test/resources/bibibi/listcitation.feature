Feature: As a user I want to list citations in a human readable form.

  Scenario: User can list citations
    Given There is citations in database
    When User presses list citations button
    Then The system lists citations in human readable format
