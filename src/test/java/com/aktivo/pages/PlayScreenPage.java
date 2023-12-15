package com.aktivo.pages;

import com.aktivo.framework.TestUtils;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.aktivo.framework.PropertyManager.getProps;
import static com.aktivo.locators.WebLocators.AccountSetting.*;
import static com.aktivo.locators.WebLocators.AccountSetting.LOG_OUT_BUTTON;
import static com.aktivo.locators.WebLocators.Dashboard.*;
import static com.aktivo.locators.WebLocators.Login.*;
import static com.aktivo.locators.WebLocators.Play.*;

public class PlayScreenPage extends BasePage{
    TestUtils utils = new TestUtils();
    public PlayScreenPage(){
    }


    public boolean verifyUserOnPlayScreen() {
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
        if (driver.findElements(By.id(PLAY_SCREEN_TITLE)).isEmpty()) {
            actionClick(driver.findElement(By.xpath(PLAY_SCREEN_TAB)));
        }
        return !driver.findElements(By.id(PLAY_SCREEN_TITLE)).isEmpty();

    }

    public boolean verifyRiseGameTitleDisplayedOnPlayScreen() {
        return !driver.findElements(By.xpath(RISE_GAME_TITLE_PLAY_SCREEN)).isEmpty();
    }

    public void clickOnAktivoRiseGame() {
        actionClick(driver.findElement(By.id(RISE_GAME_LINK)));
    }

    public boolean verifyRiseGameDashboardDisplayed() {
        return !driver.findElements(By.id(RISE_GAME_DASHBOARD_TITLE)).isEmpty();
    }

    public void clickOnTotalPointCard() {
        actionClick(driver.findElement(By.id(TOTAL_POINTS_SUBTITLE)));
    }

    public boolean verifyTotalPointCardOptions() {
        boolean status=false;
        boolean dailyLifeStylePoints= !driver.findElements(By.xpath(LIFE_CYCLE_DAILY_LIFESTYLE_POINTS)).isEmpty();
        boolean weeklyBonusPoints= !driver.findElements(By.xpath(LIFE_CYCLE_LIFE_BONUS_POINTS)).isEmpty();
        if(dailyLifeStylePoints && weeklyBonusPoints)
            status = true;
        return status;
    }

    public void clickOnRankingCard() {
        actionClick(driver.findElement(By.id(RANKING_TAB_BUTTON)));
    }

    public boolean verifyRankingTabDetails() {
        boolean status=false;
        boolean gameRankText= !driver.findElements(By.id(CURRENT_GAME_RANK_TEXT)).isEmpty();
        boolean participantDetailsText= !driver.findElements(By.id(CURRENT_GAME_RANK_TEXT)).isEmpty();
        boolean rankingInfoText= !driver.findElements(By.id(RANKING_INFO_TEXT)).isEmpty();
        if(gameRankText && participantDetailsText && rankingInfoText)
            status = true;
        return status;
    }

    public boolean verifyCurrentGameLevelOptions() {
        List<String> expectedComponentName = new ArrayList<>( Arrays.asList("Bronze", "Silver\n" +
                " 1000\n" +
                "points", "Gold\n" +
                " 1900\n" +
                "points","Platinum\n" +
                " 2600\n" +
                "points"));
        List<String> actualComponentName = driver.findElements(By.xpath(CURRENT_GAME_LEVEL_OPTION)).stream().map(WebElement::getText).toList();
        utils.log().info("actualComponentName: "+actualComponentName);
        return expectedComponentName.containsAll(actualComponentName);

    }

    public boolean verifyViewProgressScreenDisplayed() {
        return !driver.findElements(By.xpath(WEEK_PROGRESS_TITLE)).isEmpty();
    }

    public boolean verifyCurrentWeekProgress() {
        return !driver.findElements(By.xpath(WEEK_PROGRESS_TITLE)).isEmpty();
    }

    public void clickOnCheckProgressIcon() {
        scrollToElement(driver.findElement(By.xpath(CHECK_PROGRESS_ICON)));
        actionClick(driver.findElement(By.xpath(CHECK_PROGRESS_ICON)));
    }

    public void clickOnDailyLifeStyleOption(String option) {
        clickOnDailyLifestylePointCard();
        switch (option) {
            case "AktivoScore" -> {
                WebElement ele=driver.findElement(By.xpath(DAILY_LIFESTYLE_AKTIVO_SCORE_TAB));
                scrollToElement(ele);
                actionClick(ele);
                waitForPageLoad(2);
            }
            case "FibreScorePoints" -> {
                WebElement ele=driver.findElement(By.xpath(DAILY_LIFESTYLE_FIBER_SCORE_POINTS_TAB));
                scrollToElement(ele);
                actionClick(ele);
                waitForPageLoad(2);
            }
            case "CheckingYourAktivoScore" -> {
                WebElement ele=driver.findElement(By.xpath(DAILY_LIFESTYLE_CHECKING_YOUR_AS_TAB));
                scrollToElement(ele);
                actionClick(ele);
                waitForPageLoad(2);
            }
            case "Steps" -> {
                WebElement ele=driver.findElement(By.xpath(DAILY_LIFESTYLE_STEPS_TAB));
                scrollToElement(ele);
                actionClick(ele);
                waitForPageLoad(2);
            }
            case "Badges" -> {
                WebElement ele=driver.findElement(By.xpath(DAILY_LIFESTYLE_BADGES_TAB));
                scrollToElement(ele);
                actionClick(ele);
                waitForPageLoad(2);
            }
            case "RankingJumps" -> {
                WebElement ele=driver.findElement(By.xpath(DAILY_LIFESTYLE_RANKING_JUMPS_TAB));
                scrollToElement(ele);
                actionClick(ele);
                waitForPageLoad(2);
            }
            default -> System.out.println("Invalid option");
        }
    }

    public boolean verifyRulesScreenIsDisplayed() {
        return !driver.findElements(By.id(DAILY_LIFESTYLE_RULES)).isEmpty();
    }

    public boolean verifyRiseGameComponentList() {
        scrollToBottom();
        List<String> expectedComponentName = new ArrayList<>( Arrays.asList("Total Points", "Ranking", "Daily Lifestyle Points","Weekly Bonus Points"));
        List<String> actualComponentName = driver.findElements(By.xpath(RISE_GAME_COMPONENT_LIST)).stream().map(WebElement::getText).toList();
        for (String element : expectedComponentName) {
            if (!actualComponentName.contains(element)) {
                return false;
            }
        }
        return true;
    }

    public boolean verifyOngoingChallengesListIsDisplayed() {
        return !driver.findElements(By.id(ONGOING_CHALLENGES_TYPE_LIST)).isEmpty();
    }

    public boolean clickOnAnyChallengeEnrollButton() {
        boolean clickEnrollNow=false;
        List<WebElement> elements = driver.findElements(By.id(CHALLENGE_ENROLL_NOW_BUTTON));
        if(!elements.isEmpty()){
            elements.get(0).click();
            clickEnrollNow=true;
        }
        return clickEnrollNow;
    }

    public boolean clickOnAnyChallenge() {
        boolean clickChallenge = false;
        List<WebElement> elements = driver.findElements(By.id(ONGOING_CHALLENGES_TYPE_LIST));
        if (!elements.isEmpty()) {
            elements.get(0).click();
            clickChallenge = true;
        }
        return clickChallenge;

    }

    public boolean verifyChallengeDetailsScreenIsDisplayed() {
        return !driver.findElements(By.id(CHALLENGE_DETAILS_PAGE_TITLE)).isEmpty();
    }

    public void clickChallengeOverTab() {
        scrollToAndClickElement(By.id(CHALLENGE_OVER_TAB_BUTTON));
    }

    public boolean verifyListOfOverChallengeIsDisplayed() {
        return !driver.findElements(By.id(OVER_CHALLENGES_TYPE_LIST)).isEmpty();
    }

    public void clickOnDailyLifestylePointCard() {
        scrollToElement(driver.findElement(By.xpath(LIFE_CYCLE_DAILY_LIFESTYLE_POINTS)));
        actionClick(driver.findElement(By.xpath(LIFE_CYCLE_DAILY_LIFESTYLE_POINTS)));
    }

    public boolean verifyTheComponentsOfDailyLifestylePoints(DataTable dataTable) {
        List<String> expectedComponentName = dataTable.asList();
        List<String> actualComponentName = driver.findElements(By.xpath(DAILY_LIFESTYLE_POINTS_SCORE_CMP_LIST)).stream().map(WebElement::getText).toList();
        return expectedComponentName.equals(actualComponentName);
    }

    public void clickOnWeeklyBonusPointsTab() {
        scrollToAndClickElement(By.id(WEEKLY_BONUS_POINT_TAB));
        waitForPageLoad(2);
    }

    public boolean verifyTheDetailsOfWeeklyBonusPointsSection() {
        return !driver.findElements(By.xpath(WEEKLY_BONUS_PAGE_TITLE)).isEmpty();
    }

    public void clickOnMyRewardsTab() {
        actionClick(driver.findElement(By.id(MY_REWARDS_TAB)));
    }

    public boolean verifyTheRewardsCanClaim() {
        return !driver.findElements(By.id(REWARDS_OPTION)).isEmpty();
    }
}
