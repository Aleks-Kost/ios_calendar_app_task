package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DriverSetup;

public class CalendarTest2 extends DriverSetup  {

    @Test(testName = "Calendar Test 2")
    public void calendarTest() {

        Assert.assertTrue(startPage.whatsNewScreenDisplayed(), "What's New Screen is not displayed");

        startPage.clickContinueButton();
        Assert.assertTrue(calendarHomePage.calendarHomePageDisplayed(), "Calendar home page is not displayed");

        calendarHomePage.clickCalendarsTab();
        Assert.assertTrue(calendarsPage.calendarsPageDisplayed(), "Calendars page is not displayed");

        calendarsPage.clickAddCalendarButton();
        calendarsPage.clickAddCalendarOption();
        Assert.assertTrue(addCalendarPage.addCalendarPageDisplayed(), "Add calendar page is not displayed");

        addCalendarPage.enterCalendarName("Aleks Calendar");
        addCalendarPage.clickChangeColor();
        addCalendarPage.selectBlueColor();
        addCalendarPage.clickBackButton();
        Assert.assertTrue(addCalendarPage.addCalendarPageDisplayed(), "Add calendar page is not displayed");

        addCalendarPage.clickDoneButton();
        Assert.assertTrue(calendarsPage.calendarsPageDisplayed(), "Calendars page is not displayed");
        Assert.assertEquals(calendarsPage.getNewCalendar(),"Aleks Calendar");

        calendarsPage.clickHideAllButton();
        Assert.assertNotEquals(calendarsPage.getDefaultCalendarStatus(), "selected");
        Assert.assertNotEquals(calendarsPage.getNewCalendarStatus(), "selected");

        calendarsPage.clickInfoButton();
        Assert.assertTrue(editCalendarPage.editCalendarPageDisplayed(), "Edit calendar page is not displayed");

        editCalendarPage.clickDeleteCalendar();
        editCalendarPage.clickToConfirmDelete();
        Assert.assertEquals(calendarsPage.getDefaultCalendar(),"Calendar");
        Assert.assertNotEquals(calendarsPage.getNewCalendar(),"Aleks Calendar");

        calendarsPage.clickDoneButton();
        Assert.assertTrue(calendarHomePage.calendarHomePageDisplayed(), "Calendar home page is not displayed");

    }
}
