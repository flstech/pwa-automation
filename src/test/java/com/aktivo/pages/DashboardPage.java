package com.aktivo.pages;

import com.aktivo.framework.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import static com.aktivo.framework.PropertyManager.getProps;
import static com.aktivo.locators.WebLocators.PhysicalLifeStyleAndSleep.*;
import static com.aktivo.locators.WebLocators.Dashboard.*;
import static com.aktivo.locators.WebLocators.Login.*;

public class DashboardPage extends BasePage{

    TestUtils utils = new TestUtils();
    public DashboardPage(){
    }

    public boolean verifyUserOnFreshUserDashboardScreen() {
        utils.log().info("navigate to url and set the cookies");
        driver.navigate().to(getProps().get("cp_login_staging_url"));
        waitForPageLoad(1);
        driver.manage().deleteAllCookies();
        waitForPageLoad(3);
        driver.navigate().refresh();
        waitForPageLoad(3);
        if(!driver.findElements(By.xpath(TRY_AGAIN_ERROR_MESSAGE)).isEmpty())
        {
            Cookie cookie = new Cookie("member_id", getProps().get("staging_fresh_user_member_id"));
            Cookie cname = new Cookie("accessToken", getProps().get("staging_fresh_user_access_token"));
            driver.manage().addCookie(cookie);
            driver.manage().addCookie(cname);
            utils.log().info("cookies are set and refresh the page");
            waitForPageLoad(5);
            driver.navigate().refresh();
            waitForPageLoad(10);
        }
        return !driver.findElements(By.xpath(HOME_SCREEN_TAB)).isEmpty();
    }

    public boolean verifyUserOnDashboardScreen() {
        utils.log().info("navigate to url and set the cookies");
        driver.navigate().to(getProps().get("cp_login_staging_url"));
        waitForPageLoad(8);
        if(!driver.findElements(By.xpath(TRY_AGAIN_ERROR_MESSAGE)).isEmpty())
        {
            Cookie cookie = new Cookie("member_id", getProps().get("staging_user_member_id"));
            Cookie cname = new Cookie("accessToken", getProps().get("staging_user_access_token"));
            driver.manage().addCookie(cookie);
            driver.manage().addCookie(cname);
            utils.log().info("cookies are set and refresh the page");
            waitForPageLoad(5);
            driver.navigate().refresh();
            waitForPageLoad(10);
        }
        return !driver.findElements(By.xpath(HOME_SCREEN_TAB)).isEmpty();
    }

    public boolean verifyPhysicalCardDisplayed() {
        return !driver.findElements(By.id(PHYSICAL_LIFE_STYLE_AND_SLEEP_TAB)).isEmpty();
    }

    public void getScoreGenrateTomorrowMessage() {
        utils.log().info("AKTIVO_SCORE_TOMORROW_MESSAGE:"+driver.findElement(By.xpath(SCORE_GENERATE_TOMORROW_TEXT)).getText());
        Assert.assertEquals(driver.findElement(By.xpath(SCORE_GENERATE_TOMORROW_TEXT)).getText(),"Your Aktivo Score® will be ready tomorrow morning.","Message mismatch");
    }

    public void navigateToFibreRichOriginalsPage() {
        actionClick(driver.findElement(By.xpath(FIBER_RICH_ORIGINAL_RIGHT_ARROW)));
        waitForPageLoad(5);
    }

    public boolean VerifyRecipeIsPresent() {
        return !driver.findElements(By.xpath("FIBER_RICH_RECIPE")).isEmpty();
    }

    public boolean verifyMindCardDisplayed() {
        return !driver.findElements(By.id(MIND_SCORE_LINK)).isEmpty();
    }

    public boolean verifyNutritionAndFiberCardDisplayed() {
        return !driver.findElements(By.xpath(NUTRITION_AND_FIBER_SCORE_LINK)).isEmpty();
    }

    public int quickLinkIsDisplayedWithCardOptions() {
        scrollToElement(driver.findElement(By.xpath(QUICK_LINKS_OPTION_LIST)));
        return driver.findElements(By.xpath(QUICK_LINKS_OPTION_LIST)).size();
    }


    public boolean verifyBadgesPageDisplay() {
        return !driver.findElements(By.id(YOUR_BADGES_LABEL)).isEmpty();
    }

    public void clickOnBadgesCardQuickLink() {
        scrollToElement(driver.findElement(By.id(BADGES_QUICK_LINK)));
        actionClick(driver.findElement(By.id(BADGES_QUICK_LINK)));
    }

    public void clickOnFibreRichQuickLink() {
        scrollToElement(driver.findElement(By.id(HIGH_FIBER_RECIPES_QUICK_LINK)));
        actionClick(driver.findElement(By.id(HIGH_FIBER_RECIPES_QUICK_LINK)));
    }

    public boolean verifyFibreRichPageDisplay() {
        return !driver.findElements(By.xpath(FIBER_RICH_LABEL)).isEmpty();
    }

    public boolean verifyStatisticsPageDisplay() {
        return !driver.findElements(By.xpath(STATISTICS_LABEL)).isEmpty();
    }

    public void clickOnStatisticsQuickLink() {
        scrollToElement(driver.findElement(By.id(STATISTICS_QUICK_LINK)));
        actionClick(driver.findElement(By.id(STATISTICS_QUICK_LINK)));
    }

    public int selfCareSectionWithCardOptions() {
        scrollToElement(driver.findElement(By.xpath(DIABETES_SELF_CARE_LIST)));
        return driver.findElements(By.xpath(DIABETES_SELF_CARE_LIST)).size();
    }

    public void clickOnLearningCentreQuickLink() {
        scrollToElement(driver.findElement(By.id(LEARNING_CENTER_LINK)));
       actionClick(driver.findElement(By.id(LEARNING_CENTER_LINK)));
    }

    public boolean verifyLearningCentrePageDisplay() {
        return !driver.findElements(By.xpath(LEARNING_CENTER_LABEL)).isEmpty();
    }


    public void clickOnDiabetesRiskTestQuickLink() {
        scrollToElement(driver.findElement(By.id(DIABETES_RISK_TEST_LINK)));
        actionClick(driver.findElement(By.id(DIABETES_RISK_TEST_LINK)));
    }

    public boolean verifyDiabetesRiskTestPageDisplay() {
        return !driver.findElements(By.xpath(DIABETES_RISK_TEST_LABEL)).isEmpty();
    }

    public void clickOnPhysiologicalMarkersQuickLink() {
        scrollToElement(driver.findElement(By.id(PHYSIOLOGICAL_MARKERS_LINK)));
        actionClick(driver.findElement(By.id(PHYSIOLOGICAL_MARKERS_LINK)));
    }

    public boolean verifyPhysiologicalMarkersPageDisplay() {
        return !driver.findElements(By.xpath(PHYSIOLOGICAL_MARKERS_LABEL)).isEmpty();
    }

    public void clickOnAktivoRiseGameLink() {
        scrollToElement(driver.findElement(By.id(RISE_GAME_LINK)));
        actionClick(driver.findElement(By.id(RISE_GAME_LINK)));
    }

    public boolean verifyAktivoRiseGamePageDisplay() {
        return !driver.findElements(By.xpath(RISE_GAME_HEADING_TITLE)).isEmpty();

    }

    public boolean verifyChallengesCardDisplayed() {
        return !driver.findElements(By.xpath(CHALLENGES_QUICK_LINK)).isEmpty();
    }

    public void clickOnChallengeQuickLink() {
        scrollToElement(driver.findElement(By.xpath(CHALLENGES_QUICK_LINK)));
        actionClick(driver.findElement(By.xpath(CHALLENGES_QUICK_LINK)));
    }

    public boolean verifyChallengePageDisplay() {
        return !driver.findElements(By.xpath(CHALLENGES_PAGE_TITLE)).isEmpty();
    }

    public boolean verifyChallengeBannerContent() {
        boolean bannerStatus=false;
        boolean crossButton= !driver.findElements(By.xpath(DASHBOARD_CHALLENGE_BANNER_X_BUTTON)).isEmpty();
        boolean remindLaterButton= !driver.findElements(By.xpath(DASHBOARD_CHALLENGE_BANNER_REMIND_LATER_BUTTON)).isEmpty();
        boolean enrollNowButton= !driver.findElements(By.xpath(DASHBOARD_CHALLENGE_BANNER_ENROL_NOW_BUTTON)).isEmpty();
        if(crossButton && remindLaterButton && enrollNowButton)
            bannerStatus = true;
        return bannerStatus;
    }

    public void clickOnEnrollNowButtonOfDashboardBanner() {
        actionClick(driver.findElement(By.xpath(DASHBOARD_CHALLENGE_BANNER_ENROL_NOW_BUTTON)));
    }

    public void clickOnChallengeEnrollNowButtonOfDashboard() {
        scrollToElement(driver.findElement(By.xpath(CHALLENGES_QUICK_LINK)));
        actionClick(driver.findElement(By.xpath(DASHBOARD_CHALLENGE_ENROL_NOW_BUTTON)));
    }


    public boolean verifyEnrolChallengePopupButtons() {
        boolean buttonStatus=false;
        boolean acceptButton= !driver.findElements(By.xpath(ENROL_CHALLENGE_ACCEPT_BUTTON)).isEmpty();
        boolean declineButton= !driver.findElements(By.xpath(ENROL_CHALLENGE_DECLINE_BUTTON)).isEmpty();
        if(acceptButton && declineButton)
            buttonStatus = true;
        return buttonStatus;

    }

    public boolean verifyMeditationCardDisplayed() {
        scrollToElement(driver.findElement(By.id(FEATURE_MEDITATION_LINK)));
        return !driver.findElements(By.id(FEATURE_MEDITATION_LINK)).isEmpty();
    }

    public boolean verifyMeditationAudioScreenDisplayed() {
        actionClick(driver.findElement(By.xpath(DASHBOARD_MEDITATION_AUDIO_PLAY_BUTTON)));
        waitForPageLoad(1);
        return !driver.findElements(By.xpath(MEDITATION_SCREEN_PLAY_BUTTON)).isEmpty();
    }
}
