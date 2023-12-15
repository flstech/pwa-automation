Feature: Account_Screen

  Background:
    Given I verify user on Account screen

  @Sanity
  Scenario: TC0030_Verify the Options list enabled in My Accounts screen for user from respective Company
    Then the account options should be displayed:
      | Connected Apps       |
      | Reminders            |
      | Badges               |
      | Help                 |
      | Privacy Policy       |
      | Terms and Conditions |
      | Edit Profile         |
      | Logout               |

  @Sanity
  Scenario: TC0032_Verify all the Cta's are redirecting to the next page.
    Then the user clicks on CTA buttons navigate to that Page
      | ConnectedApps      |
      | Reminders          |
      | Badges             |
      | Help               |
      | PrivacyPolicy      |
      | TermsAndConditions |
      | EditProfile        |

  @Sanity
  Scenario: TC0033_Verify Edit profile link is redirecting to next page for editing the details.
    When the user clicks on the account "EditProfile" option
    Then the user should be on the account "EditProfile" page

  @Sanity
  Scenario: TC0034_Verify the Logout Button on the screen
    When the user clicks on the account "LogOut" option
    Then a confirmation pop-up appears with options Logout and Cancel