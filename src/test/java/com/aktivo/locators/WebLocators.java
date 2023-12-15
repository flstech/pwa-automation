package com.aktivo.locators;

public class WebLocators {
    public static class Login{
        public static final String TRY_AGAIN_ERROR_MESSAGE="//button[text()='Try Again']";
        public static final String LOGIN_USER_NAME_TEXT_BOX= "#email";
        public static final String LOGIN_USER_PASSWORD_TEXT_BOX= "#password";
        public static final String LOGIN_BUTTON= "//button[normalize-space()='Login']";
        public static final String USER_NAME_ERROR_MESSAGE="#email-helper-text";
        public static final String PASSWORD_ERROR_MESSAGE="#password-helper-text";
        public static final String PRIVACY_POLICY_LINK_BUTTON="//p[normalize-space()='Privacy Policy']";
        public static final String TERMS_CONDITION_LINK_BUTTON="//p[normalize-space()='Terms & Conditions']";

    }

    public static class Dashboard{
        public static final String HOME_SCREEN_TAB= "//a[@href='/aktivo-lite/dashboard']";
        public static final String PLAY_SCREEN_TAB= "//a[@href='/aktivo-lite/play']";
        public static final String SOCIAL_SCREEN_TAB= "//a[@href='/aktivo-lite/social']";
        public static final String ACCOUNT_SCREEN_TAB= "//a[@href='/aktivo-lite/account']";
        public static final String PHYSICAL_LIFE_STYLE_AND_SLEEP_TAB = "score";
        public static final String NUTRITION_AND_FIBER_SCORE_LINK= "//a[@id='nutrition']";
        public static final String MIND_SCORE_LINK= "mind";
        public static final String RISE_GAME_LINK ="riseGame";
        public static final String RISE_GAME_HEADING_TITLE="//h3[normalize-space()='Today']";
        public static final String BADGES_QUICK_LINK ="badges";
        public static final String HIGH_FIBER_RECIPES_QUICK_LINK ="high-fibre";
        public static final String STATISTICS_QUICK_LINK ="statistics";
        public static final String LEARNING_CENTER_LINK ="learningCentre";
        public static final String DIABETES_RISK_TEST_LINK ="diabetesRiskTest";
        public static final String PHYSIOLOGICAL_MARKERS_LINK ="physiologicalMarkers";
        public static final String FEATURE_MEDITATION_LINK ="featureMeditation";
        public static final String SCORE_GENERATE_TOMORROW_TEXT="(//h3[@class='text-sm mb-2 text-13 text-skin-dashboardText'][contains(text(),'Your')])[1]";
        public static final String FIBER_RICH_ORIGINAL_RIGHT_ARROW="//h3[normalize-space()='Fibre-rich originals']/../..//img";
        public static final String FIBER_RICH_RECIPE ="//a[@data-testid='linkElement']";
        public static final String QUICK_LINKS_OPTION_LIST ="//h3[normalize-space()='Quick Links']/../..//li//p";
        public static final String YOUR_BADGES_LABEL  ="yourBadgesTitle";
        public static final String FIBER_RICH_LABEL  ="//span[contains(text(),'Fibre-rich Originals')]";
        public static final String STATISTICS_LABEL ="//h3[normalize-space()='Statistics']";
        public static final String DIABETES_SELF_CARE_LIST ="//h3[normalize-space()='Diabetes Self-care']/../..//li//p";
        public static final String LEARNING_CENTER_LABEL  ="//h3[normalize-space()='Learning Centre']";
        public static final String DIABETES_RISK_TEST_LABEL  ="//h3[normalize-space()='Diabetes Risk Test']";
        public static final String PHYSIOLOGICAL_MARKERS_LABEL ="//h3[normalize-space()='Physiological Markers']";
        public static final String CHALLENGES_QUICK_LINK= "//a[@href='/aktivo-lite/challenges']";
        public static final String CHALLENGES_PAGE_TITLE="//h3[normalize-space()='Challenges']";
        public static final String DASHBOARD_CHALLENGE_BANNER_ENROL_NOW_BUTTON ="//button[normalize-space()='Enrol Now!']";
        public static final String DASHBOARD_CHALLENGE_BANNER_X_BUTTON ="//img[@src='image/cross.svg']";
        public static final String DASHBOARD_CHALLENGE_BANNER_REMIND_LATER_BUTTON ="//p[normalize-space()='Remind Later']";
        public static final String DASHBOARD_CHALLENGE_ENROL_NOW_BUTTON ="//li//p[normalize-space()='Enrol Now!']";
        public static final String ENROL_CHALLENGE_DECLINE_BUTTON ="//button[normalize-space()='Decline']";
        public static final String ENROL_CHALLENGE_ACCEPT_BUTTON ="//button[normalize-space()='Accept']";
        public static final String DASHBOARD_MEDITATION_AUDIO_PLAY_BUTTON ="//button//img[@src='image/playy.svg']";
        public static final String MEDITATION_SCREEN_PLAY_BUTTON ="//a[@href='/aktivo-lite/feature-medidation-video']//img[@src='image/playy.svg']";
    }

    public static class AccountSetting{
        public static final String ACCOUNT_SCREEN_TITLE ="//h3[normalize-space()='Account']";
        public static final String EDIT_PROFILE_BUTTON ="editProfileOption";
        public static final String SAVE_PROFILE_BUTTON ="saveUserInfo";
        public static final String NICK_NAME_TEXT_BOX ="nickname";
        public static final String FIRST_NAME_TEXT_BOX ="firstname";
        public static final String LAST_NAME_TEXT_BOX ="lastname";
        public static final String DOB_TEXT_BOX="dateOfBirth";
        public static final String HEIGHT_TEXT_BOX="height";
        public static final String WEIGHT_TEXT_BOX="weight";
        public static final String BEDTIME_TEXT_BOX="bedtime";
        public static final String WAKEUP_TIME_TEXT_BOX="wakeUpTime";
        public static final String CIG_PER_DAY_TEXT_BOX="cigPerDay";
        public static final String DRINKS_PER_WEEK_TEXT_BOX="drinksPerWeek";
        public static final String CONNECTED_APPS_BUTTON ="connectedApps";
        public static final String REMINDERS_BUTTON ="reminderList";
        public static final String BADGES_BUTTON ="badges";
        public static final String HELP_BUTTON ="accountHelp";
        public static final String PRIVACY_POLICY_BUTTON ="accountPrivacyPolicy";
        public static final String TERMS_AND_CONDITIONS_BUTTON ="accountTermsConditions";
        public static final String LOG_OUT_BUTTON ="logOutOption";
        public static final String ACCOUNT_OPTION_LIST="//p[normalize-space()='AccountOptions']";
        public static final String CONNECTED_APPS_PAGE_TITLE ="connectedAppsHeader";
        public static final String REMINDERS_PAGE_TITLE= "reminderTitle";
        public static final String YOUR_BADGES_PAGE_TITLE="yourBadgesTitle";
        public static final String HELP_PAGE_TITLE="//span[contains(text(),'Frequently Asked Questions')]";
        public static final String PRIVACY_POLICY_PAGE_TITLE="(//span[contains(text(),'Privacy Policy')])[1]";
        public static final String TERMS_AND_CONDITION_PAGE_TITLE="(//span[contains(text(),'Terms & Conditions')])[2]";
        public static final String EDIT_PROFILE_PAGE_TITLE="(//h3[normalize-space()='Edit Profile'])[1]";
        public static final String LOGOUT_NO_BUTTON="logOutNo";
        public static final String LOGOUT_YES_BUTTON="logOutYes";
    }

    public static class PhysicalLifeStyleAndSleep {
        public static final String AKTIVO_SCORE_TOMORROW_MESSAGE ="(//div[@class='text-center pt-5 mx-8'])[1]";
        public static final String TODAY_HEADING_TITLE="title";
        public static final String LEFT_BACK_BUTTON = "backBtn";
        public static final String RIGHT_BACK_BUTTON = "nextBtn";
        public static final String YESTERDAY_NO_ACTIVITY_MESSAGE = "//p[contains(text(),'no physical activities')]";
        public static final String IMPROVE_YOUR_SCORE_BUTTON="improveScore";
        public static final String CLOSE_X_BUTTON = "closeBtn";
        public static final String VIEW_DETAILS_BUTTON = "//button[normalize-space()='View Details']";
        public static final String VIEW_DETAILS_PAGE_TITLE = "//h3[normalize-space()='What is the Aktivo Score®?']";
        public static final String TODAY_EXERCISER_TAB = "todayExcercise";
        public static final String TODAY_LIGHT_ACTIVITY_TAB = "todayLightActivity";
        public static final String TODAY_SEDENTARY_ACTIVITY_TAB ="todaySedentary";
        public static final String TODAY_SLEEP_ACTIVITY_TAB ="todaySleep";
        public static final String TODAY_STEP_ACTIVITY_TAB ="todaySteps";
        public static final String YESTERDAY_EXERCISER_TAB = "excercise";
        public static final String YESTERDAY_LIGHT_ACTIVITY_TAB = "lightActivity";
        public static final String YESTERDAY_SEDENTARY_ACTIVITY_TAB ="sedentary";
        public static final String YESTERDAY_SLEEP_ACTIVITY_TAB ="sleep";
        public static final String YESTERDAY_STEP_ACTIVITY_TAB ="steps";
        public static final String IMPROVE_YOUR_AKTIVO_SCORE_PAGE_TITLE ="//h3[normalize-space()='Stay Healthy with your Aktivo Score®']";
        public static final String AKTIVO_SCORE_ROUND_BUTTON = "scoreValue";
        public static final String YOUR_AKTIVO_SCORE_RIGHT_ARROW_BUTTON="//a[@href='/aktivo-lite/score-statistics']";
        public static final String VIEW_STATISTICS_BUTTON ="//button[normalize-space()='View Statistics']";
        public static final String AKTIVO_SCORE_BUTTON_ON_VIEW_DETAILS_PAGE ="//p[contains(@class,'text-skin-primary')]";
        public static final String GREY_LOTTIE_ICON ="lottie";
    }

    public static class Play{
        public static final String PLAY_SCREEN_TITLE ="playHeading";
        public static final String RISE_GAME_TITLE_PLAY_SCREEN ="//a//h3[normalize-space()='Aktivo Rise Game']";
        public static final String RISE_GAME_DASHBOARD_TITLE ="currentRiseGameName";
        public static final String TOTAL_POINTS_SUBTITLE ="riseGameTotalPoints";
        public static final String LIFE_CYCLE_DAILY_LIFESTYLE_POINTS ="(//h3[normalize-space()='Daily Lifestyle Points'])[1]";
        public static final String LIFE_CYCLE_LIFE_BONUS_POINTS = "//img[@src='image/bonus-point.svg']/..//h3[normalize-space()='Weekly Bonus Points']";
        public static final String RISE_GAME_COMPONENT_LIST= "//button[contains(@id,'headlessui-disclosure-button')]";
        public static final String DAILY_LIFESTYLE_POINTS_SCORE_CMP_LIST="//div[contains(@class,'aktivoscore')]/p";
        public static final String ONGOING_CHALLENGES_TYPE_LIST="challengeType";
        public static final String CHALLENGE_ENROLL_NOW_BUTTON="challengeEnrollNow";
        public static final String CHALLENGE_OVER_TAB_BUTTON="overHeading";
        public static final String RANKING_TAB_BUTTON="riseGameRankTitle";
        public static final String CURRENT_GAME_RANK_TEXT="currentGameRank";
        public static final String RANKING_INFO_TEXT="riseGameRankInfo";
        public static final String CURRENT_GAME_LEVEL_OPTION="//div[contains(@id,'riseGame-')]";
        public static final String CHECK_PROGRESS_ICON= "//a[@href='/aktivo-lite/check-progress']";
        public static final String WEEK_PROGRESS_TITLE= "//p[normalize-space()='View Progress']";
        public static final String DAILY_LIFESTYLE_AKTIVO_SCORE_TAB="//p[normalize-space()='Aktivo Score®']";
        public static final String DAILY_LIFESTYLE_FIBER_SCORE_POINTS_TAB="//p[normalize-space()='Fibre Score Points']";
        public static final String DAILY_LIFESTYLE_CHECKING_YOUR_AS_TAB="//p[normalize-space()='Checking your Aktivo Score®']";
        public static final String DAILY_LIFESTYLE_STEPS_TAB="//p[normalize-space()='Steps']";
        public static final String DAILY_LIFESTYLE_BADGES_TAB="//p[normalize-space()='Badges']";
        public static final String DAILY_LIFESTYLE_RANKING_JUMPS_TAB="//p[normalize-space()='Ranking Jumps']";
        public static final String DAILY_LIFESTYLE_RULES="img_comp-klrpg6c82";
        public static final String WEEKLY_BONUS_POINT_TAB="name-1";
        public static final String WEEKLY_BONUS_PAGE_TITLE="//p[normalize-space()='Weekly Aktivo Score® Range']";
        public static final String MY_REWARDS_TAB ="riseGameMyRewards";
        public static final String REWARDS_OPTION ="riseGameDisplayName";
        public static final String CHALLENGE_DETAILS_PAGE_TITLE ="challengeDetailsHeader";
        public static final String OVER_CHALLENGES_TYPE_LIST="overChallengeTitle";

    }

    public static class Social{
        public static final String SOCIAL_SCREEN_TITLE ="socialPageHeader";
        public static final String SHARE_YOUR_THOUGHTS_TEXT_BOX="createPostInput";
        public static final String SOCIAL_POST_LIST="//div[@class='postlist']";
        public static final String CAMERA_ICON_IMAGE="cameraIcon";
        public static final String THREE_DOTS_POST_MENU_BUTTON="menuButton";
    }

    public static class NutritionAndFiber{
        public static final String NUTRITION_FIBER_SCREEN_TITLE ="//h3[normalize-space()='Nutrition And Fibre']";
        public static final String NUTRITION_FIBER_SCORE ="score";
        public static final String SMART_FIBER_CHECKER_BUTTON="smartFibreChecker";
        public static final String QUESTION_LIST_TO_CALCULATE_FS="//div[contains(@class,'fiber_title')]";
        public static final String ONE_BOWL_RICE_FS="//p[normalize-space()='1 Bowl of Rice']";
    }

    public static class Mind{
        public static final String MIND_SCREEN_TITLE ="//h3[normalize-space()='Aktivo® Mind']";
        public static final String MIND_QUESTIONNAIRE_TITLE ="//h3[normalize-space()='Mind']";
        public static final String CHECK_STATE_OF_MIND_BUTTON ="mindQuestionnaire";
        public static final String GET_STARTED_BUTTON ="//button[normalize-space()='Get Started']";
        public static final String MY_LIBRARY_OPTION ="mindLibrary";
        public static final String MY_MEDITATION_OPTION ="featureMeditation";
        public static final String SELF_COMPASSION_OPTION ="compassion";
        public static final String MY_GRATITUDE_BOX_OPTION ="gratitudeBox";
        public static final String THOUGHT_PAD_OPTION ="thoughtPad";
        public static final String MY_REFLECTION_POOL_OPTION ="reflectionPool";
        public static final String MY_MIND_GOALS_OPTION ="selectMindGoals";
        public static final String MY_JOURNEY_OPTION ="mindJourney";
        public static final String MIND_HELP_OPTION ="mindHelp";
    }


}
