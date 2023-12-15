Feature: Z_FreshUsersEdgeCaseScenario

  Background:
    Given I verify user on fresh user Dashboard screen

  @Sanity
  Scenario: TC0001_Verify user is able to check the score on the page.
    When I navigate to aktivo score page
    Then the user is able to see aktivo score

  @Sanity
  Scenario: TC0011_Verify that the arrow besides Your Aktivo score is redirecting to the statistics page.
    When I navigate to aktivo score page
    And user click on your aktivo score right arrow button
    Then the user navigate to statistics page

  @Sanity
  Scenario: TC0014_Verify the View Statistics button is redirecting to Statistics page.
    When I navigate to aktivo score page
    And the user click on aktivo score
    Then the user click on view statistics button
    Then the user navigate to statistics page

  @Sanity
  Scenario: TC0015_Verify the aktivo score on the View Details page.
    When I navigate to aktivo score page
    And the user clicks on View Details button
    Then the user is able to see the aktivo score on the View Details page

  @Sanity
  Scenario: TC0018_Verify the Get Started CTA for New User.
    Given the user navigate to mind page
    When the user clicks on the mind "Get Started" button
    Then the user should be on the mind "questionnaire" page

  @Sanity
  Scenario: TC0025_Verify user can see the score in the middle of the screen when score is generated.
    Given I verify user on fresh user Dashboard screen
    When the user navigate to nutrition and fiber page
    Then there is score generated