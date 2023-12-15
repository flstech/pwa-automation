package com.aktivo.pages;

import com.aktivo.framework.TestUtils;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.List;

import static com.aktivo.framework.PropertyManager.getProps;
import static com.aktivo.locators.WebLocators.AccountSetting.*;
import static com.aktivo.locators.WebLocators.AccountSetting.LOG_OUT_BUTTON;
import static com.aktivo.locators.WebLocators.Dashboard.MIND_SCORE_LINK;
import static com.aktivo.locators.WebLocators.Login.TRY_AGAIN_ERROR_MESSAGE;
import static com.aktivo.locators.WebLocators.Mind.*;

public class MindPage extends BasePage{
    TestUtils utils = new TestUtils();
    public MindPage(){
    }

    public boolean verifyUserOnMindScreen() {
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
        if (driver.findElements(By.xpath(MIND_SCREEN_TITLE)).isEmpty()) {
            actionClick(driver.findElement(By.id(MIND_SCORE_LINK)));
        }
        return !driver.findElements(By.xpath(MIND_SCREEN_TITLE)).isEmpty();
    }

    public void verifyMindPageOptionsShouldBeDisplayed(DataTable dataTable) {

        List<String> expectedOptions = dataTable.asList();
        // Check if each expected option is enabled on the screen
        for (String option : expectedOptions) {
            switch (option.replace(" ", "")) {
                case "MyLibrary" -> {
                    Assert.assertTrue(driver.findElement(By.id(MY_LIBRARY_OPTION)).isDisplayed());
                }
                case "MyMeditations" -> {
                    Assert.assertTrue(driver.findElement(By.id(MY_MEDITATION_OPTION)).isDisplayed());
                }
                case "MyGratitudeBox" -> {
                    Assert.assertTrue(driver.findElement(By.id(MY_GRATITUDE_BOX_OPTION)).isDisplayed());
                }
                case "ThoughtPad" -> {
                    Assert.assertTrue(driver.findElement(By.id(THOUGHT_PAD_OPTION)).isDisplayed());
                }
                case "MyReflectionPool" -> {
                    Assert.assertTrue(driver.findElement(By.id(MY_REFLECTION_POOL_OPTION)).isDisplayed());
                }
                case "MyMindGoals" -> {
                    Assert.assertTrue(driver.findElement(By.id(MY_MIND_GOALS_OPTION)).isDisplayed());
                }
                case "MyJourney" -> {
                    Assert.assertTrue(driver.findElement(By.id(MY_JOURNEY_OPTION)).isDisplayed());
                }
                case "Helpline" -> {
                    Assert.assertTrue(driver.findElement(By.id(MIND_HELP_OPTION)).isDisplayed());
                }
                default -> {
                    System.out.println("Invalid option");
                    Assert.fail("Invalid option selected");
                }
            }
        }
    }

    public void clicksOnTheMindPageOption(String option) {
        switch (option) {
            case "Get Started" -> {
                driver.findElement(By.xpath(GET_STARTED_BUTTON)).click();
                waitForPageLoad(2);
            }
            case "Check State Of Mind" -> {
                driver.findElement(By.id(CHECK_STATE_OF_MIND_BUTTON)).click();
                waitForPageLoad(2);
            }
            default -> {
                System.out.println("Invalid option");
            }
        }
    }

    public boolean userOnMindOptionPage(String option) {
        switch (option) {
            case "questionnaire" -> {
                Assert.assertEquals(driver.findElement(By.xpath(MIND_QUESTIONNAIRE_TITLE)).getText(), "Mind");
                return true;
            }
            case "Reminders" -> {
                Assert.assertEquals(driver.findElement(By.id(REMINDERS_PAGE_TITLE)).getText(), "Reminders");
                return true;
            }
            default -> {
                System.out.println("Invalid option");
                Assert.fail("Invalid option selected");
                return false;
            }
        }
    }
    public boolean navigateToMindPage() {
        if (driver.findElements(By.xpath(MIND_SCREEN_TITLE)).isEmpty()) {
            actionClick(driver.findElement(By.id(MIND_SCORE_LINK)));
        }
        return !driver.findElements(By.xpath(MIND_SCREEN_TITLE)).isEmpty();
    }
}
