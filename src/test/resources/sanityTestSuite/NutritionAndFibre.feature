Feature: NutritionAndFibre_Screen

  Background:
    Given I verify user on nutrition and fiber screen

  @Sanity
  Scenario: TC0024_Verify user can see only '--' when no score generated.
    Then there is no score generated and '--' displayed

  @Sanity
  Scenario: TC0026_Verify the Smart Fibre Checker button.
    When the user clicks on Smart Fibre Checker
    Then the user should be taken to a page with questions to calculate the fibre score

  @Sanity
  Scenario: TC0027_Verify the UI of Smart Fibre checker page.
    When the user clicks on Smart Fibre Checker
    Then the user is able to food items name
