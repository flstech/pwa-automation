Feature: Mind_Screen

  Background:
    Given I verify user on Mind screen

  @Sanity
  Scenario: TC0017_Verify the Mind Card on the dashboard.
    Then I verify user on Mind screen

  @Sanity
  Scenario: TC0019_verify the questionnaire page is displayed after clicking on Check State of Mind button.
    When the user clicks on the mind "Check State Of Mind" button
    Then the user should be on the mind "questionnaire" page

  @Sanity
  Scenario: TC0022 - Verify user can see all the options on the page below score.
    Then the mind page options should be displayed
      | My Library         |
      | My Meditations     |
      | My Gratitude Box   |
      | ThoughtPad         |
      | My Reflection Pool |
      | My Mind Goals      |
      | My Journey         |
      | Helpline           |
