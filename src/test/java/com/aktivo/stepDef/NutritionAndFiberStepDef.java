package com.aktivo.stepDef;

import com.aktivo.pages.NutritionAndFiberPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NutritionAndFiberStepDef {
    NutritionAndFiberPage nutritionAndFiberPage= new NutritionAndFiberPage();

    @Given("I verify user on nutrition and fiber screen")
    public void iVerifyUserOnNutritionAndFiberScreen() {
        Assert.assertTrue(nutritionAndFiberPage.verifyUserOnNutritionAndFiberScreen(),"Nutrition and Fiber screen is not displayed");
    }

    @Then("there is no score generated and {string} displayed")
    public void there_is_no_score_generated_and_displayed(String score) {
        Assert.assertEquals(nutritionAndFiberPage.getScore(),score,"score is not displayed");
    }


    @Then("there is score generated")
    public void thereIsScoreGenerated() {
        Assert.assertNotEquals(nutritionAndFiberPage.getScore(),"--","Nutrition and Fiber score is not displayed");
    }

    @When("the user clicks on Smart Fibre Checker")
    public void theUserClicksOnSmartFibreChecker() {
        nutritionAndFiberPage.clickOnSmartFibreChecker();
    }

    @Then("the user should be taken to a page with questions to calculate the fibre score")
    public void theUserShouldBeTakenToAPageWithQuestionsToCalculateTheFibreScore() {
        Assert.assertTrue(nutritionAndFiberPage.verifyQuestionsToCalculateTheFibreScore(),"Questions to calculate the fibre score is not displayed");
    }

    @When("the user navigate to nutrition and fiber page")
    public void theUserNavigateToNutritionAndFiberPage() {
        Assert.assertTrue(nutritionAndFiberPage.navigateToNutritionAndFiberScoredPage(),"Nutrition and Fiber page is not displayed");
    }

    @Then("the user is able to food items name")
    public void theUserIsAbleToFoodItemsName() {
        Assert.assertTrue(nutritionAndFiberPage.verifyFoodItemNameDisplayed(),"unable to see food items");
    }
}
