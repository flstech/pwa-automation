package com.aktivo.stepDef;

import com.aktivo.pages.MindPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MindScreenStepDef {
    MindPage mindPage=new MindPage();
    @Given("I verify user on Mind screen")
    public void iVerifyUserOnMindScreen() {
        Assert.assertTrue(mindPage.verifyUserOnMindScreen(),"Mind screen is not displayed");
    }

    @Then("the mind page options should be displayed")
    public void theMindPageOptionsShouldBeDisplayed(io.cucumber.datatable.DataTable dataTable) {
        mindPage.verifyMindPageOptionsShouldBeDisplayed(dataTable);
    }

    @When("the user clicks on the mind {string} button")
    public void theUserClicksOnTheMindButton(String option) {
        mindPage.clicksOnTheMindPageOption(option);

    }

    @Then("the user should be on the mind {string} page")
    public void theUserShouldBeOnTheMindPage(String option) {
        Assert.assertTrue(mindPage.userOnMindOptionPage(option),"mind option is not displayed");
    }

    @Given("the user navigate to mind page")
    public void theUserNavigateToMindPage() {
        Assert.assertTrue(mindPage.navigateToMindPage(),"Mind screen is not displayed");
    }
}
