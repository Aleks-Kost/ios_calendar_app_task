package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class CalendarsPage {
    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Calendars\"`]")
    private RemoteWebElement confirmCalendarsPage;
    @iOSXCUITFindBy(accessibility = "Add Calendar")
    private RemoteWebElement addCalendarButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add Calendar'])[2]")
    private RemoteWebElement addCalendarOption;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText")
    private RemoteWebElement confirmNewCalendarCreated;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText")
    private RemoteWebElement confirmDefaultCalendarPresent;
    @iOSXCUITFindBy(accessibility = "Hide All")
    private RemoteWebElement hideAllButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeImage")
    private RemoteWebElement defaultCalendarStatus;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeImage")
    private RemoteWebElement newCalendarStatus;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"More Info\"`][2]")
    private RemoteWebElement infoButton;
    @iOSXCUITFindBy(accessibility = "Done")
    private RemoteWebElement doneButton;

    public CalendarsPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Calendars page is loaded")
    public boolean calendarsPageDisplayed() {
        return confirmCalendarsPage.isDisplayed();
    }
    @Step("Add Calendar button is clicked")
    public void clickAddCalendarButton() {
        addCalendarButton.click();
    }
    @Step("Add Calendar option is selected")
    public void clickAddCalendarOption() {
        addCalendarOption.click();
    }
    @Step("New calendar is displayed")
    public String getNewCalendar() {
        return confirmNewCalendarCreated.getText();
    }
    @Step("Hide all button is clicked")
    public void clickHideAllButton() {
        hideAllButton.click();
    }
    @Step("Default calendar is not selected")
    public String getDefaultCalendarStatus() {
        return defaultCalendarStatus.getAttribute("name");
    }
    @Step("New calendar is not selected")
    public String getNewCalendarStatus() {
        return newCalendarStatus.getAttribute("name");
    }
    @Step("Info button is clicked")
    public void clickInfoButton() {
        infoButton.click();
    }
    @Step("Default calendar is displayed")
    public String getDefaultCalendar() {
        return confirmDefaultCalendarPresent.getText();
    }
    @Step("Done button is clicked")
    public void clickDoneButton() {
        doneButton.click();
    }


}
