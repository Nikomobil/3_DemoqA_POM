package demoqa.pages.alertsFrameWindows;

import demoqa.core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {


    public AlertsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage alertWithTime() {
        click(timerAlertButton);
        new WebDriverWait(driver, Duration.ofSeconds(6))
                .until(ExpectedConditions.alertIsPresent()).accept();

        return this;
    }

    @FindBy(id = "alertButton")
    WebElement confirmButton;

    public AlertsPage confirmAlert() {
        click(confirmButton);
        ExpectedConditions.alertIsPresent();

        return this;
    }

    @FindBy(id = "confirmButton")
    WebElement confirmBoxButton;

    @FindBy(id = "confirmResult")
    WebElement confirmResult;

    public AlertsPage confirmBoxAlert() {
        click(confirmBoxButton);
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.alertIsPresent());
        alert.accept();
        new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.visibilityOf(confirmResult));
        Assert.assertEquals(confirmResult.getText(), "You selected Ok");
        click(confirmBoxButton);
        Alert alertCancel = new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.alertIsPresent());
        alertCancel.dismiss();
        Assert.assertEquals(confirmResult.getText(), "You selected Cancel");
        return this;
    }

    @FindBy(id = "promtButton")
    WebElement promptButton;

    @FindBy(id = "promptResult")
    WebElement promptResult;
    @FindBy(className = "col-md-6")
    WebElement promptInput;

    public AlertsPage promptAlert() {
        click(promptButton);
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(1))
                .until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("velo");
        alert.accept();
        Assert.assertEquals(promptResult.getText(), "You entered velo");
//        click(promptButton);
//        Alert alertCancel = new WebDriverWait(driver, Duration.ofSeconds(1))
//                .until(ExpectedConditions.alertIsPresent());
//        alertCancel.dismiss();
//        new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.visibilityOf(promptInput));
//        Assert.assertEquals(promptInput.getAttribute("value"), "");
        return this;
    }
}
