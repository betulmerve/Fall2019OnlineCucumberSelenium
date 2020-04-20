package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStepDefinitions {


    CalendarEventsPage calendarEventsPage=new CalendarEventsPage();



    @Then("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        System.out.println("User click on create calendar event button");
        calendarEventsPage.clickToCreateCalenderEvent();
    }

    @Then("user enters {string} as title")
    public void user_enters_as_title(String string) {
        System.out.println("User enters title: "+ string);
        calendarEventsPage.enterCalendarEventTitle(string);
    }

    @Then("user enters {string} as description")
    public void user_enters_as_description(String string) {
        System.out.println("User enters description: "+string);
        calendarEventsPage.enterCalendarEventDescription(string);

    }
    @Then("user clicks on save and close button")
    public void user_clicks_on_save_and_close_button() {
        System.out.println("User clicks on save and close button");
       calendarEventsPage.clickOnSaveAndClose();
    }

    @Then("user verifies that description is {string}")
    public void user_verifies_that_description_is(String string) {
        Assert.assertEquals(string,calendarEventsPage.getGeneralInfoDescription());
    }

    @Then("user verifies that title is {string}")
    public void user_verifies_that_title_is(String string) {
        Assert.assertEquals(string,calendarEventsPage.getGeneralInfoTitle());
    }

    @Then("user enters new calendar event information:")
    public void user_enters_new_calendar_event_information(Map<String,String > dataTable) {
        calendarEventsPage.enterCalendarEventDescription(dataTable.get("description"));
        calendarEventsPage.enterCalendarEventTitle( dataTable.get("title"));

    }

    @Then("user verifies new calendar event")
    public void user_verifies_new_calendar_event(Map<String,String >  dataTable) {
        Assert.assertEquals(dataTable.get("description"),calendarEventsPage.getGeneralInfoDescription());
        Assert.assertEquals(dataTable.get("title"),calendarEventsPage.getGeneralInfoTitle());

    }
}