package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    protected IOSDriver driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='SplashScreen']")
    private RemoteWebElement whatsNewScreen;
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Continue\"`]")
    private RemoteWebElement continueButton;

    public StartPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean whatsNewScreenDisplayed() {
        return whatsNewScreen.isDisplayed();
    }
    public void clickContinueButton() {
        continueButton.click();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
