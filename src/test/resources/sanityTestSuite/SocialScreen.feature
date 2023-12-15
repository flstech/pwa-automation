Feature: PWA_SocialScreen

  Background:
    Given I verify user on Social screen

  @Sanity
  Scenario: TC0035_Verify components in social wall screen
    Then I verify Social Wall displayed with its component

  @ignore
  Scenario: TC0037_Verify camera uploading on social wall post

  @Sanity
  Scenario: TC0038_Verify UI of the page matches the design.
    Then the header contains the text Social in the middle

  @Sanity
  Scenario: TC0039_ Verify three dots is present beside every social post
    When the user looks at each social post
    Then they should see three dots menu icon beside each post
