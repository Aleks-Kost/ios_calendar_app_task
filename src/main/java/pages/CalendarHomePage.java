package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class CalendarHomePage {
    protected IOSDriver driver;

    @iOSXCUITFindBy(accessibility = "Calendar")
    private RemoteWebElement calendarHomePage;
    @iOSXCUITFindBy(accessibility = "Add")
    private RemoteWebElement addEventButton;
    @iOSXCUITFindBy(accessibility = "Calendars")
    private RemoteWebElement calendarsButton;

    public CalendarHomePage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendar home page is loaded")
    public boolean calendarHomePageDisplayed() {
        return calendarHomePage.isDisplayed();
    }
    @Step("Add New Event button is clicked")
    public void clickAddButton() {
        addEventButton.click();
    }
    @Step("Calendars tab is clicked")
    public void clickCalendarsTab() {
        calendarsButton.click();
    }

}
