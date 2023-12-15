package com.aktivo.stepDef;

import com.aktivo.pages.PlayScreenPage;
import com.aktivo.pages.SocialPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SocialScreenStepDef {
    SocialPage socialPage = new SocialPage();

    @Given("I verify user on Social screen")
    public void iVerifyUserOnPlayScreen() {
        Assert.assertTrue(socialPage.verifyUserOnSocialScreen(),"Social Screen is not displayed");
    }

    @Then("I verify Social Wall displayed with its component")
    public void iVerifySocialWallDisplayedWithItsComponent() {
        Assert.assertTrue(socialPage.verifySocialWallDisplayedWithItsComponent(),"Social Wall not displayed with its component");
    }

    @Then("the header contains the text Social in the middle")
    public void theHeaderContainsTheTextSocialInTheMiddle() {
        Assert.assertTrue(socialPage.verifyTheHeaderContainsTheTextSocialInTheMiddle(),"Social screen header is not displayed");
    }
    Integer postCount;
    @When("the user looks at each social post")
    public void theUserLooksAtEachSocialPost() {
        postCount=socialPage.getListOfPostCount();
    }

    @Then("they should see three dots menu icon beside each post")
    public void theyShouldSeeThreeDotsMenuIconBesideEachPost() {
        Assert.assertEquals(postCount,socialPage.getThreeDotsMenuIconCount(),"Unable to see three dots menu icon beside each post");
    }
}
