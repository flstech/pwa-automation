Feature: PhysicalLifeStyleAndSleep_Screen

  Background:
    Given I verify user on Physical Life Style And Sleep screen

  @Sanity
  Scenario: TC0002_Verify View Details button is tappable.
    When the user clicks on View Details button
    Then the user should be taken to the details page

  @Sanity
  Scenario: TC0004_Verify that as the score is not generated, the score should not be visible , there must be icon revolving.
    Then the user should be able to see grey icon instead of score

  @Sanity
  Scenario: TC0005_Verify that all the cards of yesterday’s activities are present under View Details button with their values.. Cards are: Exercise, Light Activity, Sedentary, Sleep, Steps
    When the user clicks on yesterday activity button
    Then the yesterday activity cards options should be displayed:
      | Exercise      |
      | LightActivity |
      | Sedentary     |
      | Sleep         |
      | Steps         |

  @Sanity
  Scenario: TC0008_Verify that all the cards of today’s activities are present with their values.. Cards are: Exercise, Light Activity, Sedentary, Sleep, Steps
    Then the today activity cards options should be displayed:
      | Exercise      |
      | LightActivity |
      | Sedentary     |
      | Sleep         |
      | Steps         |

  @Sanity
  Scenario: TC0009_Verify that the 'i' button is redirecting to the information page of Aktivo score.
    When the user clicks on the i button
    Then the user should be redirected improve your aktivo score