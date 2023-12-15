package com.aktivo.stepDef;

import com.aktivo.pages.PlayScreenPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class PlayScreenStepDef {

    PlayScreenPage playScreenPage = new PlayScreenPage();

    @Given("I verify user on Play screen")
    public void iVerifyUserOnPlayScreen() {
        Assert.assertTrue(playScreenPage.verifyUserOnPlayScreen(),"Play screen is not displayed");
    }


    @Then("I verify Rise game is shown in Play Screen")
    public void iVerifyRiseGameIsShownInPlayScreen() {
        Assert.assertTrue(playScreenPage.verifyRiseGameTitleDisplayedOnPlayScreen(),"Rise game screen is not displayed");
    }

    @Then("I click on play screen Aktivo Rise Game and navigate to Rise Game dashboard")
    public void iClickOnPlayScreenAktivoRiseGameAndNavigateToRiseGameDashboard() {
        playScreenPage.clickOnAktivoRiseGame();
        Assert.assertTrue(playScreenPage.verifyRiseGameDashboardDisplayed(),"Rise game is not displayed");

    }

    @And("I click on Total Points card")
    public void iClickOnTotalPointsCard() {
      playScreenPage.clickOnTotalPointCard();
    }

    @Then("I verify the Total Points tab details")
    public void iVerifyTheTotalPointsTabDetails() {
        Assert.assertTrue(playScreenPage.verifyTotalPointCardOptions(),"Total Points tab details not found");
    }

    @And("I click on Ranking card")
    public void iClickOnRankingCard() {
        playScreenPage.clickOnRankingCard();
    }

    @Then("I verify the Ranking tab details")
    public void iVerifyTheRankingTabDetails() {
        Assert.assertTrue(playScreenPage.verifyRankingTabDetails(),"Ranking tab details not found");
    }

    @Then("I verify current game level options")
    public void iVerifyCurrentGameLevelOptions() {
        Assert.assertTrue(playScreenPage.verifyCurrentGameLevelOptions(),"Current game level options not displayed");
    }

    @And("I click on check progress icon and navigate to view progress screen")
    public void iClickOnCheckProgressIconAndNavigateToViewProgressScreen() {
        playScreenPage.clickOnCheckProgressIcon();
        Assert.assertTrue(playScreenPage.verifyViewProgressScreenDisplayed(),"view progress screen not displayed");
    }

    @Then("I verify the progress of current week")
    public void iVerifyTheProgressOfCurrentWeek() {
        Assert.assertTrue(playScreenPage.verifyCurrentWeekProgress(),"Current week progress screen not displayed");
    }

    @And("I click Daily Lifestyle Point card and select any {}")
    public void iClickDailyLifestylePointCardAndSelectAny(String Option) {
        playScreenPage.clickOnDailyLifeStyleOption(Option);
    }

    @Then("I verify Rules screen is displayed")
    public void iVerifyRulesScreenIsDisplayed() {
        Assert.assertTrue(playScreenPage.verifyRulesScreenIsDisplayed(),"Rules screen is not displayed");
    }

    @And("I click on Weekly Bonus Points tab")
    public void iClickOnWeeklyBonusPointsTab() {
        playScreenPage.clickOnWeeklyBonusPointsTab();
    }

    @Then("I verify the details of weekly Bonus Points section")
    public void iVerifyTheDetailsOfWeeklyBonusPointsSection() {
        Assert.assertTrue(playScreenPage.verifyTheDetailsOfWeeklyBonusPointsSection(),"Weekly Bonus Points section not displayed");
    }

    @And("I verify the list of rise game component")
    public void iVerifyTheListOfRiseGameComponent() {
        Assert.assertTrue(playScreenPage.verifyRiseGameComponentList(),"Rise game component not displayed");
    }

    @And("I click on Daily Lifestyle Point card")
    public void iClickOnDailyLifestylePointCard() {
        playScreenPage.clickOnDailyLifestylePointCard();
    }

    @Then("I verify the components of Daily Lifestyle Points")
    public void iVerifyTheComponentsOfDailyLifestylePoints(io.cucumber.datatable.DataTable dataTable) {
        Assert.assertTrue(playScreenPage.verifyTheComponentsOfDailyLifestylePoints(dataTable),"components of Daily Lifestyle Points not displayed");
    }

    @And("I click on My rewards tab")
    public void iClickOnMyRewardsTab() {
        playScreenPage.clickOnMyRewardsTab();
    }

    @Then("I verify the rewards can claim")
    public void iVerifyTheRewardsCanClaim() {
        Assert.assertTrue(playScreenPage.verifyTheRewardsCanClaim(),"rewards not able to claim");
    }

    @Then("I verify ongoing challenges list is displayed")
    public void iVerifyOngoingChallengesListIsDisplayed() {
        Assert.assertTrue(playScreenPage.verifyOngoingChallengesListIsDisplayed(),"ongoing challenges list is not displayed");
    }

    @And("I click on enroll button of challenge screen")
    public void iClickOnEnrollButtonOfChallengeScreen() {
        Assert.assertTrue(playScreenPage.clickOnAnyChallengeEnrollButton(),"Enroll button of challenge screen not displayed");
    }

    @And("I click on any challenge")
    public void iClickOnAnyChallenge() {
        Assert.assertTrue(playScreenPage.clickOnAnyChallenge(),"not found any challenge");
    }

    @And("I verify challenge details screen is displayed")
    public void iVerifyChallengeDetailsScreenIsDisplayed() {
        Assert.assertTrue(playScreenPage.verifyChallengeDetailsScreenIsDisplayed(),"Unable to see challenge details screen");
    }

    @When("I click challenges over tab")
    public void iClickChallengesOverTab() {
        playScreenPage.clickChallengeOverTab();
    }

    @Then("I verify the list of over challenge")
    public void iVerifyTheListOfOverChallenge() {
        Assert.assertTrue(playScreenPage.verifyListOfOverChallengeIsDisplayed(),"list of over challenge is not displayed");
    }
}
