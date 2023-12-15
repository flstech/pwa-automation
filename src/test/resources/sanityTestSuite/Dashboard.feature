Feature: Dashboard_Screen

  Background:
    Given I verify user on Dashboard screen

  @Sanity
  Scenario: TC0040_Verify the PWA Physical card is displayed in the dashboard
    Then I verify physical card is displayed

 @Sanity
  Scenario: TC0041_Verify when AS is not present for the day
    Then I verify the message aktivo score generated tomorrow

 @Sanity
  Scenario: TC0042_Verify for the case where the score is not generated for the days
    When I navigate to aktivo score page
    And I click on left arrow
    Then I verify yesterday no activity score message

  @Sanity
  Scenario: TC0043_Verify the functionality of PWA header close (X) button
    When I navigate to aktivo score page
    And I click on improve your aktivo score button
    Then I verify tap on (X) button close the PWA screen and exit the screen

  @Sanity
  Scenario: TC0044_Verify displaying the list of Fibre-rich Orignals recipes list is shown when tapped on the Right arrow in Firbe-rich originals section
    When I click on Fibre-rich Originals
    Then I verify atleast one recipe is present

 @Sanity
  Scenario: TC0045_Verify the PWA Mind card is displayed in the dashboard
    Then I verify mind card is displayed

 @Sanity
  Scenario: TC0048_Check the Nutrition and Fiber card is displayed in the dashboard for existing user
    Then I verify Nutrition and Fiber card is displayed

 @Sanity
  Scenario: TC0050_Verify if the Quick links section is displaying the Dashboard
    Then I verify Quick links section with three cards under it like Badges High, Fibre recipes, Statistics

 @Sanity
  Scenario: TC0051_Verify the Quick Links-Badges card is working when tapped and navigating to the respective screen
    Then I click on Badges card and navigate to Badges screen

 @Sanity
  Scenario: TC0052_Verify the Quick Links-High fibre Recipes card is working when tapped and navigating to the respective screen
    Then I click on High Fiber card and navigate to Fibre-rich Originals screen

 @Sanity
  Scenario: TC0053_Verify the Statistics card is working when tapped and navigating to the respective screen
    Then I click on statistics card and navigate to statistics screen

 @Sanity
  Scenario: TC0054_Verify if the Diabetes Self-care section is displaying the Dashboard
    Then I verify Self-care section with three cards under it like Learning Centre,Diabetes Risk Test, Physiological Markers

 @Sanity
  Scenario: TC0055_Verify the Diabetes Self-care-Learning Centre card is working when tapped and navigating to the respective screen
    Then I click on Learning Centre and navigate to Learning Centre screen

 @Sanity
  Scenario: TC0056_Verify the Diabetes Self-care - Diabetes Risk Test card is working when tapped and navigating to the respective screen
    Then I click on Diabetes Risk Test and navigate to Diabetes Risk Test screen

 @Sanity
  Scenario: TC0057_Verify the Diabetes Self-care - Physiological Markers card is working when tapped and navigating to the respective screen
    Then I click on Physiological Markers and navigate to Physiological Markers screen

 @Sanity
  Scenario: TC0058_Verify user are able to navigate to the Aktivo Rise Game when tapped on the Game card in dashboard screen
    Then I click on Aktivo Rise Game and navigate to Aktivo Rise Game screen

 @Sanity
  Scenario: TC0059_Verify if the Challenges is displayed in dashboard
    Then I verify challenges card is displayed

 @Sanity
  Scenario: TC0060_Verify user is navigating to challenge details screen when tapped on challenge card in dashboard
    Then I click on challenges card and navigate to challenge screen

 @Sanity
  Scenario: TC0062_Verify the user is navigating to the challenge details screen and is shown a popup disclaimer with Accept and Decline button
    When I click on challenge enrol button
    Then I verify popup display with Accept and Decline button

 @Sanity
  Scenario: TC0063_Verify the content in the Challenge banner in dashboard
    Then I verify challenge banner is display with contents on dashboard

 @Sanity
  Scenario: TC0064_Verify the behaviour when user taps on Enroll button in the challenge banner in dashboard
    Then I click on enroll button and navigate to challenge screen

 @Sanity
  Scenario: TC0065_Verify user is able to view the Meditation card in dashboard
    Then I verify Meditation card is displayed

 @Sanity
  Scenario: TC0066_Verify if user is navigating to meditation screen when tapped on the card or Play icon on card
    Then I click on the Audio play icon of Meditation card and navigate to meditation audio screen