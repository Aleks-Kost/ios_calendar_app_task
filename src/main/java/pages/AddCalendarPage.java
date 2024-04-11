package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCalendarPage {
    protected IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Add Calendar']")
    private RemoteWebElement confirmAddCalendarPage;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"Calendar Name\"`]")
    private RemoteWebElement calendarNameField;
    @iOSXCUITFindBy(accessibility = "chevron")
    private RemoteWebElement changeColorArrow;
    @iOSXCUITFindBy(accessibility = "Blue")
    private RemoteWebElement bluerColor;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Add Calendar'])[2]")
    private RemoteWebElement backButton;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Done'])[2]")
    private RemoteWebElement doneButton;

    public AddCalendarPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean addCalendarPageDisplayed() {
        return confirmAddCalendarPage.isDisplayed();
    }
    @Step("New Calendar name is: {0}")
    public void enterCalendarName(String name) {
        calendarNameField.clear();
        calendarNameField.sendKeys(name);
    }
    public void clickChangeColor() {
        changeColorArrow.click();
    }
    @Step("Blue color is selected")
    public void selectBlueColor() {
        bluerColor.click();
    }
    public void clickBackButton() {
        backButton.click();
    }
    @Step("Done button is clicked")
    public void clickDoneButton() {
        doneButton.click();
    }

}
