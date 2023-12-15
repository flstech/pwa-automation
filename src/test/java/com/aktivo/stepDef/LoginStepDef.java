package com.aktivo.stepDef;

import com.aktivo.framework.GlobalParams;
import com.aktivo.framework.PropertyManager;
import com.aktivo.pages.DashboardPage;
import com.aktivo.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();

    @Given("I navigate to login page url")
    public void iNavigateToLoginPageUrl() {
        loginPage.setCookiesAndRefreshThePage();
        loginPage.waitForPageLoad(5);
    }


    @When("I Enter valid username and password and click on login")
    public void iEnterValidUsernameAndPasswordAndClickOnLogin() {
        loginPage.enterUserName(PropertyManager.getProps().get("staging_login_user_name"));
        loginPage.enterUserPsw(PropertyManager.getProps().get("staging_login_psw"));
        loginPage.clickLoginButton();
        loginPage.waitForPageLoad(5);
    }

    @Then("I verify user on home page")
    public void iVerifyUserOnHomePage() {
        Assert.assertTrue(loginPage.getHomePageDisplayed());
    }

    @When("I enter invalid username {string} and valid password {string}")
    public void i_enter_invalid_username_and_valid_password(String username, String password) {
        loginPage.enterUserName(username);
        loginPage.enterUserPsw(password);
        loginPage.clickLoginButton();
        loginPage.waitForPageLoad(5);
    }

    @Then("I verify invalid email message {string}")
    public void i_verify_invalid_email_message(String errorMessage) {
        Assert.assertEquals(loginPage.getLoginUserNameErrorMessage(),errorMessage);
    }


    @Then("I verify {string} msg displayed")
    public void iVerifyMsgDisplayed(String message) {
        Assert.assertEquals(loginPage.getTryAgainMessage(),message);
    }

}
