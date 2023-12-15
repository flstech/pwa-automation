Feature: PWA_PlayScreen

  Background:
    Given I verify user on Play screen

  @Sanity
  Scenario: TC0068_Verify the Rise game is shown in Play Screen
    Then I verify Rise game is shown in Play Screen

  @Sanity
  Scenario: TC0069_Verify tapping on the Rise game is navigating to the Rise Game dashboard
    Then I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard

  @Sanity
  Scenario: TC0070_Verify if Rise game is showing the required component
    Then I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard
    And I verify the list of rise game component

  @Sanity
  Scenario: TC0071_Verify the Total points section components and navigation
    When I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard
    And I click on Total Points card
    Then I verify the Total Points tab details

  @Sanity
  Scenario: TC0072_Verify the ranking section components and navigation
    When I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard
    And I click on Ranking card
    Then I verify the Ranking tab details

  @Sanity
  Scenario: TC0073_Verify the View of the current game level of the user
    When I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard
    Then I verify current game level options

  @Sanity
  Scenario: TC0074_Verify the behaviour tapping on the icon - "Check progress"
    When I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard
    And I click on check progress icon and navigate to view progress screen
    Then I verify the progress of current week

  @Sanity
  Scenario: TC0075_Verify the components in the Daily Lifestyle Points section
    When I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard
    And I click on Daily Lifestyle Point card
    Then I verify the components of Daily Lifestyle Points
      | Aktivo Score®               |
      | Fibre Score Points          |
      | Checking your Aktivo Score® |
      | Steps                       |
      | Badges                      |
      | Ranking Jumps               |

  @Sanity
  Scenario Outline:TC0076_Verify when tapped on the Daily Lifestyle Point card section
    When I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard
    And I click Daily Lifestyle Point card and select any <Options>
    Then I verify Rules screen is displayed
    Examples:
      | Options |
      | FibreScorePoints |

  @Sanity
  Scenario: TC0077_Verify the components in the Weekly Bonus Points section
    When I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard
    And I click on Weekly Bonus Points tab
    Then I verify the details of weekly Bonus Points section

  @Sanity
  Scenario: TC0078_Verify tapping on the Rewards tab, should show the rewards available which users can claim
    When I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard
    And I click on My rewards tab
    Then I verify the rewards can claim

  @Sanity
  Scenario: TC0080_Verify the Challenges is showing in the Play screen
    Then I verify ongoing challenges list is displayed

  @Sanity
  Scenario: TC0081_Verify that the tapping on the Challenge card user should be shown the challenge details screen
    Then I verify ongoing challenges list is displayed
    And I click on any challenge
    And I verify challenge details screen is displayed

  @Sanity
  Scenario: TC0082_Verify the Challenges enrolled in the Play screen
    Then I verify ongoing challenges list is displayed
    And I click on enroll button of challenge screen
    And I verify popup display with Accept and Decline button

  @Sanity
  Scenario: TC0083_Verify the Over Challenges is showing in the Play screen
    When I click challenges over tab
    Then I verify the list of over challenge
