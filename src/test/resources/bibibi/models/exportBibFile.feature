Feature: As a user I want to generate BibTeX files.

  Scenario: The system can convert database data into BibTeX format.
    Given Citation is saved to the database
    When User exports citation
    Then Resulting file is in correct format

  Scenario: The system exports a bib-file
    Given Citation is saved to the database
    When User exports citation
    Then Resulting file is the right type
