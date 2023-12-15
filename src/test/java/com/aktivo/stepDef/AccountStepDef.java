package com.aktivo.stepDef;

import com.aktivo.pages.AccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class AccountStepDef {

    AccountPage accountPage = new AccountPage();

    @Given("I verify user on Account screen")
    public void iVerifyUserOnAccountScreen() {
        Assert.assertTrue(accountPage.verifyUserOnPlayScreen(),"Not able to see Account screen");
    }

    @Then("the account options should be displayed:")
    public void theAccountOptionsShouldBeDisplayed(io.cucumber.datatable.DataTable dataTable) {
        accountPage.verifyAccountOptionsShouldBeDisplayed(dataTable);
    }

    @Then("the user clicks on CTA buttons navigate to that Page")
    public void theUserClicksOnCTAButtonsNavigateToThatPage(io.cucumber.datatable.DataTable dataTable) {
        accountPage.verifyUserClicksOnCTAButtonsNavigateToThatPage(dataTable);
    }

    @When("the user clicks on the account {string} option")
    public void theUserClicksOnTheAccountOption(String option) {
        Assert.assertTrue(accountPage.clicksOnTheAccountOption(option),"Option is not displayed");
    }

    @Then("the user should be on the account {string} page")
    public void theUserShouldBeOnTheAccountPage(String page) {
        Assert.assertTrue(accountPage.userOnTheAccountOptionPage(page),"Page is not load");
    }

    @Then("a confirmation pop-up appears with options Logout and Cancel")
    public void aConfirmationPopUpAppearsWithOptionsLogoutAndCancel() {
        Assert.assertTrue(accountPage.confirmationPopUpAppearsWithOptionsLogoutNoAndYes(),"Confirmation pop up is not displayed");
    }
}