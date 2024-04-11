package utilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import pages.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

@Listeners({ ITestListenerUtility.class })

public class DriverSetup extends ConfigReader{

    public static IOSDriver driver;

    protected CalendarHomePage calendarHomePage;
    protected NewEventPage newEventPage;
    protected MonthViewPage monthViewPage;
    protected CalendarsPage calendarsPage;
    protected AddCalendarPage addCalendarPage;
    protected EditCalendarPage editCalendarPage;
    protected StartPage startPage;

    @BeforeMethod
    public void setUp() {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(getProperty("device.name"))
                .setPlatformVersion(getProperty("platform.version"))
                .setBundleId(getProperty("bundle.id"))
                .setNoReset(false)
                .setFullReset(true)
                .setAutoDismissAlerts(true);
        try {
            driver = new IOSDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        calendarHomePage = new CalendarHomePage(driver);
        newEventPage = new NewEventPage(driver);
        monthViewPage = new MonthViewPage(driver);
        calendarsPage = new CalendarsPage(driver);
        addCalendarPage = new AddCalendarPage(driver);
        editCalendarPage = new EditCalendarPage(driver);
        startPage = new StartPage(driver);

    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
