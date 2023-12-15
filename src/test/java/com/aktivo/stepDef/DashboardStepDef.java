package com.aktivo.stepDef;

import com.aktivo.pages.DashboardPage;
import com.aktivo.pages.PhysicalLifeStyleAndSleepPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.ITestResult;


public class DashboardStepDef {
    DashboardPage dashboardPage = new DashboardPage();
    PhysicalLifeStyleAndSleepPage physicalLifeStyleAndSleepPage = new PhysicalLifeStyleAndSleepPage();

    @Given("I verify user on Dashboard screen")
    public void iVerifyUserOnDashboardScreen() {
        Assert.assertTrue(dashboardPage.verifyUserOnDashboardScreen(),"Dashboard screen is not displayed");
    }

    @Then("I verify physical card is displayed")
    public void iVerifyPhysicalCardIsDisplayed() {
        Assert.assertTrue(dashboardPage.verifyPhysicalCardDisplayed(),"Physical card is not present");
    }

    @When("I navigate to aktivo score page")
    public void iNavigateToAktivoScorePage() {
        physicalLifeStyleAndSleepPage.navigateToAktivoScorePage();
    }

    @Then("I verify the message aktivo score generated tomorrow")
    public void iVerifyTheMessageAktivoScoreGeneratedTomorrow() {
        dashboardPage.getScoreGenrateTomorrowMessage();
    }


    @When("I click on Fibre-rich Originals")
    public void iClickOnFibreRichOriginals() {
        dashboardPage.navigateToFibreRichOriginalsPage();
    }

    @Then("I verify atleast one recipe is present")
    public void iVerifyAtleastOneRecipeIsPresent() {
        Assert.assertTrue(dashboardPage.VerifyRecipeIsPresent(),"Recipes not present");
    }

    @Then("I verify mind card is displayed")
    public void iVerifyMindCardIsDisplayed() {
        Assert.assertTrue(dashboardPage.verifyMindCardDisplayed(),"Mind card is not present");
    }

    @Then("I verify Nutrition and Fiber card is displayed")
    public void iVerifyNutritionAndFiberCardIsDisplayed() {
        Assert.assertTrue(dashboardPage.verifyNutritionAndFiberCardDisplayed(),"Nutrition And Fiber card is not present");
    }

    @Then("I verify Quick links section with three cards under it like Badges High, Fibre recipes, Statistics")
    public void iVerifyQuickLinksSectionWithThreeCardsUnderItLikeBadgesHighFibreRecipesStatistics() {
        Assert.assertEquals(dashboardPage.quickLinkIsDisplayedWithCardOptions(),3,"Quick links card option mismatch");
    }

    @Then("I click on Badges card and navigate to Badges screen")
    public void iClickOnBadgesCardAndNavigateToBadgesScreen() {
        dashboardPage.clickOnBadgesCardQuickLink();
        Assert.assertTrue(dashboardPage.verifyBadgesPageDisplay(),"Badges Page is not display");

    }

    @Then("I click on High Fiber card and navigate to Fibre-rich Originals screen")
    public void iClickOnHighFiberCardAndNavigateToFibreRichOriginalsScreen() {
        dashboardPage.clickOnFibreRichQuickLink();
        Assert.assertTrue(dashboardPage.verifyFibreRichPageDisplay(),"Fibre-rich Originals screen is not display");
    }

    @Then("I click on statistics card and navigate to statistics screen")
    public void iClickOnStatisticsCardAndNavigateToStatisticsScreen() {
        dashboardPage.clickOnStatisticsQuickLink();
        Assert.assertTrue(dashboardPage.verifyStatisticsPageDisplay(),"Statistics screen is not display");

    }

    @Then("I verify Self-care section with three cards under it like Learning Centre,Diabetes Risk Test, Physiological Markers")
    public void iVerifySelfCareSectionWithThreeCardsUnderItLikeLearningCentreDiabetesRiskTestPhysiologicalMarkers() {
        Assert.assertEquals(dashboardPage.selfCareSectionWithCardOptions(),3,"self Care Section With Card Options mismatched");
    }

    @Then("I click on Diabetes Risk Test and navigate to Diabetes Risk Test screen")
    public void iClickOnDiabetesRiskTestAndNavigateToDiabetesRiskTestScreen() {
        dashboardPage.clickOnDiabetesRiskTestQuickLink();
        Assert.assertTrue(dashboardPage.verifyDiabetesRiskTestPageDisplay(),"DiabetesRisk Test Page is not display");
    }

    @Then("I click on Physiological Markers and navigate to Physiological Markers screen")
    public void iClickOnPhysiologicalMarkersAndNavigateToPhysiologicalMarkersScreen() {
        dashboardPage.clickOnPhysiologicalMarkersQuickLink();
        Assert.assertTrue(dashboardPage.verifyPhysiologicalMarkersPageDisplay(),"Physiological Markers Page is not display");
    }

    @Then("I click on Aktivo Rise Game and navigate to Aktivo Rise Game screen")
    public void i_click_on_aktivo_rise_game_and_navigate_to_aktivo_rise_game_screen() {
        dashboardPage.clickOnAktivoRiseGameLink();
        Assert.assertTrue(dashboardPage.verifyAktivoRiseGamePageDisplay(),"Aktivo RiseGame Page is not display");
    }

    @Then("I verify challenges card is displayed")
    public void iVerifyChallengesCardIsDisplayed() {
        Assert.assertTrue(dashboardPage.verifyChallengesCardDisplayed(),"Challenge card is not present");
    }

    @Then("I click on challenges card and navigate to challenge screen")
    public void iClickOnChallengesCardAndNavigateToChallengeScreen() {
        dashboardPage.clickOnChallengeQuickLink();
        Assert.assertTrue(dashboardPage.verifyChallengePageDisplay(),"Challenge Page is not display");
    }

    @Then("I verify challenge banner is display with contents on dashboard")
    public void iVerifyChallengeBannerIsDisplayWithContentsOnDashboard() {
        Assert.assertTrue(dashboardPage.verifyChallengeBannerContent(),"Challenge banner is not display");
    }

    @Then("I click on enroll button and navigate to challenge screen")
    public void iClickOnEnrollButtonAndNavigateToChallengeScreen() {
        dashboardPage.clickOnEnrollNowButtonOfDashboardBanner();
        Assert.assertTrue(dashboardPage.verifyChallengePageDisplay(),"Challenge Page is not display");
    }

    @Then("I click on Learning Centre and navigate to Learning Centre screen")
    public void iClickOnLearningCentreAndNavigateToLearningCentreScreen() {
        dashboardPage.clickOnLearningCentreQuickLink();
        Assert.assertTrue(dashboardPage.verifyLearningCentrePageDisplay(),"Learning Center Page is not display");

    }

    @When("I click on challenge enrol button")
    public void iClickOnChallengeEnrolButton() {
        dashboardPage.clickOnChallengeEnrollNowButtonOfDashboard();
    }

    @Then("I verify popup display with Accept and Decline button")
    public void iVerifyPopupDisplayWithAcceptAndDeclineButton() {
        Assert.assertTrue(dashboardPage.verifyEnrolChallengePopupButtons(),"Accept & Decline button is not display");
    }

    @Then("I verify Meditation card is displayed")
    public void iVerifyMeditationCardIsDisplayed() {
        Assert.assertTrue(dashboardPage.verifyMeditationCardDisplayed(),"Meditation card is not present");
    }

    @Then("I click on the Audio play icon of Meditation card and navigate to meditation audio screen")
    public void iClickOnTheAudioPlayIconOfMeditationCardAndNavigateToMeditationAudioScreen() {
        dashboardPage.verifyMeditationCardDisplayed();
        Assert.assertTrue(dashboardPage.verifyMeditationAudioScreenDisplayed(),"Meditation Audio screen is not present");
    }

    @Given("I verify user on fresh user Dashboard screen")
    public void iVerifyUserOnFreshUserDashboardScreen() {
        Assert.assertTrue(dashboardPage.verifyUserOnFreshUserDashboardScreen(),"User is not able to see fresh screen");
    }
}