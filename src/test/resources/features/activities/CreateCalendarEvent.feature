@activities
Feature: Create calendar event
  As user, I want to be able to create calendar events.

  Scenario: Create calendar event as sales manager
    Given user is on the login page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clicks on create calendar event button
    And user enters "On this meeting we discuss something" as description
    And user enters "Sprint Retrospective" as title
    Then user clicks on save and close button
    And user verifies that description is "On this meeting we discuss something"
    And user verifies that title is "Sprint Retrospective"


    @create_calendar_event_2
  Scenario: Create calendar event as sales manager with data table
    Given user is on the login page
    When user logs in as a sales manager
    And user navigates to "Activities" and "Calendar Events"
    Then user clicks on create calendar event button
    And user enters new calendar event information:
      | description| On this meeting we discuss something |
      | title      | Sprint Retrospective                 |
    Then user clicks on save and close button
    And user verifies new calendar event
      | description| On this meeting we discuss something |
      | title      | Sprint Retrospective                 |

