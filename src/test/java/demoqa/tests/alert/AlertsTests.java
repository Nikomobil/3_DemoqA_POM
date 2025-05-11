package demoqa.tests.alert;

import demoqa.core.TestBase;
import demoqa.pages.HomePage;
import demoqa.pages.SidePanel;
import demoqa.pages.alertsFrameWindows.AlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        new HomePage(app.driver, app.wait)
                .getAlertsFrameWindows();
        new SidePanel(app.driver, app.wait)
                .selectAlerts();
    }

    @Test
    public void alertWaitTest(){
        new AlertsPage(app.driver, app.wait)
                .alertWithTime();
    }

    @Test
    public void confirmAlertTest(){
        new AlertsPage(app.driver, app.wait)
                .confirmAlert();
    }

    @Test
    public void confirmBoxAlertTest(){
        new AlertsPage(app.driver, app.wait)
                .confirmBoxAlert();
    }
    @Test
    public void promptAlertTest(){
        new AlertsPage(app.driver, app.wait)
                .promptAlert();
    }

}
