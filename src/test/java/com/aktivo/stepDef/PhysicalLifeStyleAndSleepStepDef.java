package com.aktivo.stepDef;

import com.aktivo.pages.PhysicalLifeStyleAndSleepPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.aktivo.locators.WebLocators.PhysicalLifeStyleAndSleep.TODAY_LIGHT_ACTIVITY_TAB;

public class PhysicalLifeStyleAndSleepStepDef {
    PhysicalLifeStyleAndSleepPage physicalLifeStyleAndSleepPage = new PhysicalLifeStyleAndSleepPage();

    @Given("I verify user on Physical Life Style And Sleep screen")
    public void iVerifyUserOnPhysicalLifeStyleAndSleepScreen() {
        Assert.assertTrue(physicalLifeStyleAndSleepPage.verifyUserOnPhysicalLifeStyleAndSleepScreen(),"hysical Life Style And Sleep screen not displayed");
    }

    @And("I click on left arrow")
    public void iClickOnLeftArrow() {
        physicalLifeStyleAndSleepPage.clickLeftBackButton();
    }

    @Then("I verify yesterday no activity score message")
    public void iVerifyYesterdayNoActivityScoreMessage() {
        Assert.assertEquals(physicalLifeStyleAndSleepPage.getYesterdayNoActivityScoreMessage(),"There are no physical activities and sleep recorded for the selected date","Yesterday Activity not displayed");
    }

    @And("I click on improve your aktivo score button")
    public void iClickOnImproveYourAktivoScoreButton() {
        physicalLifeStyleAndSleepPage.clickOnImproveYourAktivoScoreButton();
    }


    @Then("I verify tap on \\(X) button close the PWA screen and exit the screen")
    public void iVerifyTapOnXButtonCloseThePWAScreenAndExitTheScreen() {
        Assert.assertEquals(physicalLifeStyleAndSleepPage.verifyTapOnXButtonCloseThePWAScreenAndExitTheScreen(),"Today","Unable to click on close button");
    }

    @When("the user clicks on View Details button")
    public void theUserClicksOnViewDetailsButton() {
        physicalLifeStyleAndSleepPage.clickOnViewDetailsButton();
    }

    @Then("the user should be taken to the details page")
    public void theUserShouldBeTakenToTheDetailsPage() {
        Assert.assertTrue(physicalLifeStyleAndSleepPage.verifyViewDetailsPageDisplayed(),"Not able to see details page");
    }

    @When("the user clicks on yesterday activity button")
    public void theUserClicksOnYesterdayActivityButton() {
        physicalLifeStyleAndSleepPage.clickOnYesterdayActivityButton();
    }

    @Then("the yesterday activity cards options should be displayed:")
    public void theYesterdayActivityCardsOptionsShouldBeDisplayed(io.cucumber.datatable.DataTable dataTable) {
        physicalLifeStyleAndSleepPage.userYesterdayActivityTabOption(dataTable);
    }

    @Then("the today activity cards options should be displayed:")
    public void theTodayActivityCardsOptionsShouldBeDisplayed(io.cucumber.datatable.DataTable dataTable) {
        physicalLifeStyleAndSleepPage.userTodayActivityTabOption(dataTable);
    }

    @When("the user clicks on the i button")
    public void theUserClicksOnTheIButton() {
        physicalLifeStyleAndSleepPage.clickOnTheIButton();
    }

    @Then("the user should be redirected improve your aktivo score")
    public void theUserShouldBeRedirectedImproveYourAktivoScore() {
        Assert.assertTrue(physicalLifeStyleAndSleepPage.verifyRedirectedImproveYourAktivoScorePage());
    }

    @And("the user click on aktivo score")
    public void theUserClickOnAktivoScore() {
        physicalLifeStyleAndSleepPage.clickOnAktivoScoreRoundButton();
    }

    @Then("the user navigate to statistics page")
    public void theUserNavigateToStatisticsPage() {
        Assert.assertTrue(physicalLifeStyleAndSleepPage.verifyStatisticsPageIsDisplayed());
    }

    @And("user click on your aktivo score right arrow button")
    public void userClickOnYourAktivoScoreRightArrowButton() {
        physicalLifeStyleAndSleepPage.clickOnYourAktivoScoreRightArrowButton();
    }

    @Then("the user is able to see aktivo score")
    public void theUserIsAbleToSeeAktivoScore() {
        Assert.assertTrue(physicalLifeStyleAndSleepPage.verifyAktivoScoreRoundButtonIsDisplayed());
    }

    @Then("the user click on view statistics button")
    public void theUserClickOnViewStatisticsButton() {
        physicalLifeStyleAndSleepPage.ClickOnViewStatisticsButton();
    }

    @Then("the user is able to see the aktivo score on the View Details page")
    public void theUserIsAbleToSeeTheAktivoScoreOnTheViewDetailsPage() {
        Assert.assertTrue(physicalLifeStyleAndSleepPage.verifyAktivoScoreIsDisplayOnViewDetailsPage());
    }

    @Then("the user should be able to see grey icon instead of score")
    public void theUserShouldBeAbleToSeeGreyIconInsteadOfScore() {
        Assert.assertTrue(physicalLifeStyleAndSleepPage.verifyGreyIconDisplayedInsteadOfScore(),"grey icon not displayed");
    }
}
