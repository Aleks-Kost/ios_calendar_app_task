package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class MonthViewPage {
    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"April 2024\"`]")
    private RemoteWebElement monthViewPage;
    @iOSXCUITFindBy(accessibility = "Wednesday, 24 April")
    private RemoteWebElement eventDateOne;
    @iOSXCUITFindBy(accessibility = "Thursday, 25 April")
    private RemoteWebElement eventDateTwo;

    public MonthViewPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean monthViewPageDisplayed() {
        return monthViewPage.isDisplayed();
    }
    @Step("Event is added for April 24")
    public String getEventDateOne() {
        return eventDateOne.getText();
    }
    @Step("Event is added for April 25")
    public String getEventDateTwo() {
        return eventDateTwo.getText();
    }

}
