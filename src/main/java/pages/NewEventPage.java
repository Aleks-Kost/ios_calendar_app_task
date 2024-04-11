package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
public class NewEventPage {
    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"New Event\"`]")
    private RemoteWebElement confirmNewEventPage;
    @iOSXCUITFindBy(accessibility = "Title")
    private RemoteWebElement eventTitle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'Starts')]/XCUIElementTypeButton/XCUIElementTypeButton[1]")
    private RemoteWebElement startsDate;
    @iOSXCUITFindBy(accessibility = "24")
    private RemoteWebElement selectStartsDate;
    @iOSXCUITFindBy(accessibility = "24.4.2024")
    private RemoteWebElement confirmStartsDate;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'Starts')]/XCUIElementTypeOther/XCUIElementTypeButton[2]")
    private RemoteWebElement startsTime;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
    private RemoteWebElement selectHour;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[2]")
    private RemoteWebElement selectMinutes;
    @iOSXCUITFindBy(accessibility = "Ends")
    private RemoteWebElement endsDate;
    @iOSXCUITFindBy(accessibility = "25")
    private RemoteWebElement selectEndsDate;
    @iOSXCUITFindBy(accessibility = "25.4.2024")
    private RemoteWebElement confirmEndsDate;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name, 'Ends')]/XCUIElementTypeOther/XCUIElementTypeButton[2]")
    private RemoteWebElement endsTime;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Travel Time\"`]")
    private RemoteWebElement travelTimeButton;
    @iOSXCUITFindBy(accessibility = "30 minutes")
    private RemoteWebElement selectTravelTime;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"30 minutes\"`]")
    private RemoteWebElement confirmTravelTime;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name='All-day']")
    private RemoteWebElement allDaySwitch;
    @iOSXCUITFindBy(accessibility = "Starts, 24.4.2024")
    private RemoteWebElement startsNoTime;
    @iOSXCUITFindBy(accessibility = "Ends, 25.4.2024")
    private RemoteWebElement endsNoTime;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add'])[2]")
    private RemoteWebElement addButton;
    @iOSXCUITFindBy(accessibility = "April")
    private RemoteWebElement toMonthView;

    public NewEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    @Step("New Event page is loaded")
    public boolean newEventPageDisplayed() {
        return confirmNewEventPage.isDisplayed();
    }
    @Step("Calendar name is: {0}")
    public void addEventTitle(String title) {
        eventTitle.clear();
        eventTitle.sendKeys(title);
    }
    public void clickStartsDate() {
        startsDate.click();
    }
    @Step("Starts date is: Apr 24, 2024 ")
    public void chooseStartsDate() {
        selectStartsDate.click();
    }
    public String getStartsDate() {
        return confirmStartsDate.getText();
    }
    public void clickStartsTime() {
        startsTime.click();
    }
    @Step("Starts time is: {0}:{1} ")
    public void chooseStartsTime(String hour, String minutes) {
        selectHour.sendKeys(hour);
        selectMinutes.sendKeys(minutes);
    }
    public String getStartsTime() {
        return startsTime.getText();
    }
    public void clickEndsDate() {
        endsDate.click();
    }
    @Step("Ends date is: Apr 25, 2024 ")
    public void chooseEndsDate() {
        selectEndsDate.click();
    }
    public String getEndsDate() {
        return confirmEndsDate.getText();
    }
    public void clickEndsTime() {
        endsTime.click();
    }
    @Step("Ends time is: {0}:{1} ")
    public void chooseEndsTime(String hour, String minutes) {
        selectHour.sendKeys(hour);
        selectMinutes.sendKeys(minutes);
    }
    public String getEndsTime() {
        return endsTime.getText();
    }
    public void clickTravelTime() {
        travelTimeButton.click();
    }
    @Step("Travel time is: 30 Minutes")
    public void chooseTime() {
        selectTravelTime.click();
    }
    public String getSelectedTime() {
        return confirmTravelTime.getText();
    }
    @Step("All-day switch is clicked")
    public void clickAllDaySwitch() {
        allDaySwitch.click();
    }
    @Step("Starts time is not visible, only the date")
    public String startsTimeNotVisible() {
        return startsNoTime.getText();
    }
    @Step("Ends time is not visible, only the date")
    public String endsTimeNotVisible() {
        return endsNoTime.getText();
    }
    @Step("Add button is clicked")
    public void clickAddButton() {
        addButton.click();
    }
    @Step("Back to month view is clicked")
    public void clickToMonthView() {
        toMonthView.click();
    }
}
