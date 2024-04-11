package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverSetup;

public class CalendarTest1 extends DriverSetup  {

    @Test(testName = "Calendar Test 1")
    public void calendarTest() {

        Assert.assertTrue(startPage.whatsNewScreenDisplayed(), "What's New Screen is not displayed");

        startPage.clickContinueButton();
        Assert.assertTrue(calendarHomePage.calendarHomePageDisplayed(), "Calendar home page is not displayed");

        calendarHomePage.clickAddButton();
        Assert.assertTrue(newEventPage.newEventPageDisplayed(), "New Event page is not displayed");

        newEventPage.addEventTitle("Automation Course");

        newEventPage.clickStartsDate();
        newEventPage.chooseStartsDate();
        Assert.assertEquals(newEventPage.getStartsDate(), "24.4.2024");

        newEventPage.clickStartsTime();
        newEventPage.chooseStartsTime("11", "10");
        Assert.assertEquals(newEventPage.getStartsTime(), "11:10");

        newEventPage.clickEndsDate();
        newEventPage.chooseEndsDate();
        Assert.assertEquals(newEventPage.getEndsDate(), "25.4.2024");

        newEventPage.clickEndsTime();
        newEventPage.chooseEndsTime("12", "25");
        Assert.assertEquals(newEventPage.getEndsTime(), "12:25");

        newEventPage.clickTravelTime();
        newEventPage.chooseTime();
        Assert.assertEquals(newEventPage.getSelectedTime(), "30 minutes");

        newEventPage.clickAllDaySwitch();
        Assert.assertNotEquals(newEventPage.startsTimeNotVisible(),"Starts, 11:10, 24.4.2024");
        Assert.assertNotEquals(newEventPage.endsTimeNotVisible(),"Ends, 12:25, 25.4.2024");

        newEventPage.clickAllDaySwitch();

        newEventPage.clickAddButton();
        newEventPage.clickToMonthView();
        Assert.assertTrue(monthViewPage.monthViewPageDisplayed(), "Month view page is not displayed");
        Assert.assertEquals(monthViewPage.getEventDateOne(), "1 event");
        Assert.assertEquals(monthViewPage.getEventDateTwo(), "1 event");
    }
}
