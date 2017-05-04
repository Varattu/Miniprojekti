Feature: As a user I want to add article citations in a human readable form.

  Scenario: User can set a title for an article citation
    Given New citation is initialized
    When User enters article title "Example Title"
    Then The title of a article should be "Example Title"

  Scenario: User can set author for an article citation
    Given New citation is initialized
    When User enters article author "Kenny, G"
    Then The author of an article should be "Kenny, G"

    Scenario: User can set year for an article citation
        Given New citation is initialized
        When User enters article author "Kenny, G"
        Then The author of an article citation should be "Kenny, G"