package com.aktivo.pages;

import com.aktivo.framework.TestUtils;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.List;

import static com.aktivo.framework.PropertyManager.getProps;
import static com.aktivo.locators.WebLocators.AccountSetting.*;
import static com.aktivo.locators.WebLocators.PhysicalLifeStyleAndSleep.*;
import static com.aktivo.locators.WebLocators.Dashboard.*;
import static com.aktivo.locators.WebLocators.Login.TRY_AGAIN_ERROR_MESSAGE;

public class PhysicalLifeStyleAndSleepPage extends BasePage{

    TestUtils utils = new TestUtils();
    public PhysicalLifeStyleAndSleepPage(){
    }
    public void navigateToAktivoScorePage() {
        actionClick(driver.findElement(By.id(PHYSICAL_LIFE_STYLE_AND_SLEEP_TAB)));
        waitForPageLoad(3);
    }

    public void clickLeftBackButton() {
        actionClick(driver.findElement(By.id(LEFT_BACK_BUTTON)));
        waitForPageLoad(3);
    }

    public String getYesterdayNoActivityScoreMessage() {
        return  driver.findElement(By.xpath(YESTERDAY_NO_ACTIVITY_MESSAGE)).getText();
    }

    public void clickOnImproveYourAktivoScoreButton() {
        waitForPageLoad(3);
       scrollToAndClickElement(By.id(IMPROVE_YOUR_SCORE_BUTTON));
        waitForPageLoad(3);
    }

    public String verifyTapOnXButtonCloseThePWAScreenAndExitTheScreen() {
        actionClick(driver.findElement(By.id(CLOSE_X_BUTTON)));
        waitForPageLoad(3);
        return driver.findElement(By.id(TODAY_HEADING_TITLE)).getText();
    }

    public boolean verifyUserOnPhysicalLifeStyleAndSleepScreen() {
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
        if (driver.findElements(By.id(TODAY_HEADING_TITLE)).isEmpty()) {
            actionClick(driver.findElement(By.id(PHYSICAL_LIFE_STYLE_AND_SLEEP_TAB)));
        }
        return driver.findElement(By.id(TODAY_HEADING_TITLE)).getText().equals("Today");
    }

    public void clickOnViewDetailsButton() {
        actionClick(driver.findElement(By.xpath(VIEW_DETAILS_BUTTON)));
    }

    public boolean verifyViewDetailsPageDisplayed() {
      return !driver.findElements(By.xpath(VIEW_DETAILS_PAGE_TITLE)).isEmpty();
    }

    public void userTodayActivityTabOption( DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList();
        // Check if each expected option is enabled on the screen
        for (String option : expectedOptions) {
            switch (option) {
                case "Exercise" -> {
                    Assert.assertTrue(driver.findElement(By.id(TODAY_EXERCISER_TAB)).isDisplayed(),"Exercise option is not displayed");
                }
                case "LightActivity" -> {
                    Assert.assertTrue(driver.findElement(By.id(TODAY_LIGHT_ACTIVITY_TAB)).isDisplayed(),"LightActivity option is not displayed");
                }
                case "Sedentary" -> {
                    Assert.assertTrue(driver.findElement(By.id(TODAY_SEDENTARY_ACTIVITY_TAB)).isDisplayed(),"Sedentary option is not displayed");
                }
                case "Sleep" -> {
                    Assert.assertTrue(driver.findElement(By.id(TODAY_SLEEP_ACTIVITY_TAB)).isDisplayed(),"Sleep option is not displayed");
                }
                case "Steps" -> {
                    Assert.assertTrue(driver.findElement(By.id(TODAY_STEP_ACTIVITY_TAB)).isDisplayed(),"Steps option is not displayed");
                }
                default -> {
                    System.out.println("Invalid option");
                    Assert.fail("Invalid option selected");
                }
            }
        }
    }

    public void userYesterdayActivityTabOption( DataTable dataTable) {
        List<String> expectedOptions = dataTable.asList();
        // Check if each expected option is enabled on the screen
        for (String option : expectedOptions) {
            switch (option) {
                case "Exercise" -> {
                    Assert.assertTrue(driver.findElement(By.id(YESTERDAY_EXERCISER_TAB)).isDisplayed(),"Exercise not present");
                }
                case "LightActivity" -> {
                    Assert.assertTrue(driver.findElement(By.id(YESTERDAY_LIGHT_ACTIVITY_TAB)).isDisplayed(),"LightActivity not present");
                }
                case "Sedentary" -> {
                    Assert.assertTrue(driver.findElement(By.id(YESTERDAY_SEDENTARY_ACTIVITY_TAB)).isDisplayed(),"Sedentary not present");
                }
                case "Sleep" -> {
                    Assert.assertTrue(driver.findElement(By.id(YESTERDAY_SLEEP_ACTIVITY_TAB)).isDisplayed(),"Sleep not present");
                }
                case "Steps" -> {
                    Assert.assertTrue(driver.findElement(By.id(YESTERDAY_STEP_ACTIVITY_TAB)).isDisplayed(),"Steps not present");
                }
                default -> {
                    System.out.println("Invalid option");
                    Assert.fail("Invalid option selected");
                }
            }
        }
    }

    public void clickOnYesterdayActivityButton() {
        actionClick(driver.findElement(By.id(LEFT_BACK_BUTTON)));
    }

    public boolean verifyRedirectedImproveYourAktivoScorePage() {
        return !driver.findElements(By.xpath(IMPROVE_YOUR_AKTIVO_SCORE_PAGE_TITLE)).isEmpty();
    }

    public void clickOnTheIButton() {
        scrollToAndClickElement(By.id(IMPROVE_YOUR_SCORE_BUTTON));
    }

    public void clickOnAktivoScoreRoundButton() {
        driver.findElement(By.id(AKTIVO_SCORE_ROUND_BUTTON)).click();
    }

    public boolean verifyStatisticsPageIsDisplayed() {
        return driver.findElement(By.xpath(STATISTICS_LABEL)).isDisplayed();
    }

    public void clickOnYourAktivoScoreRightArrowButton() {
        scrollToAndClickElement(By.xpath(YOUR_AKTIVO_SCORE_RIGHT_ARROW_BUTTON));
    }

    public boolean verifyAktivoScoreRoundButtonIsDisplayed() {
        return driver.findElement(By.id(AKTIVO_SCORE_ROUND_BUTTON)).isDisplayed();
    }

    public void ClickOnViewStatisticsButton() {
        scrollToAndClickElement(By.xpath(VIEW_STATISTICS_BUTTON));
    }

    public boolean verifyAktivoScoreIsDisplayOnViewDetailsPage() {
        String score=driver.findElement(By.xpath(AKTIVO_SCORE_BUTTON_ON_VIEW_DETAILS_PAGE)).getText();
        // Compare the numerical value with zero
        if (Integer.parseInt(score)> 0) {
            System.out.println("The score value is greater than zero.");
            return true;
        } else {
            System.out.println("The score value is not greater than zero.");
            return false;
        }
    }

    public boolean verifyGreyIconDisplayedInsteadOfScore() {
        return !driver.findElements(By.id(GREY_LOTTIE_ICON)).isEmpty();
    }
}
