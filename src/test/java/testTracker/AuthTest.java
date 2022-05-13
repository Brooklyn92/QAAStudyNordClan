package testTracker;

import config.DriverInitializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthPage;
import java.net.MalformedURLException;
import java.time.Duration;

public class AuthTest {
    private final By CHECK_TITLE = By.xpath("//h1[contains(@class,'title')]");

    @AfterEach
    public void tearDown(){
        //di.driver.quit();
    }

    @Test
    public void authCase002() throws MalformedURLException {
        DriverInitializer driverInitializer = new DriverInitializer().initDriverInitializer("chrome");
        AuthPage authPage1 = new AuthPage(driverInitializer);
        authPage1.USER_NAME.sendKeys("airat.basyrov");
        authPage1.PASSWORD.sendKeys("  user1");
        authPage1.AUTH_PAGE_BUTTON.click();
        WebElement element = (new WebDriverWait(driverInitializer.driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(authPage1.errorMessage))));
        String errMesPage = authPage1.ERROR_MESSAGE.getText();
        Assertions.assertEquals("Неверный логин/пароль. Проверьте данные", errMesPage);
    }

    @Test
    public void authCase003() throws MalformedURLException {
        DriverInitializer driverInitializer = new DriverInitializer().initDriverInitializer("firefox");
        AuthPage authPage = new AuthPage(driverInitializer);
        authPage.USER_NAME.sendKeys("airat.basyrov");
        boolean disable = !authPage.AUTH_PAGE_BUTTON.isEnabled();
        Assertions.assertTrue(disable);
    }

    @Test
    public void authCase004() throws MalformedURLException {
        DriverInitializer driverInitializer = new DriverInitializer().initDriverInitializer("chrome");
        AuthPage authPage = new AuthPage(driverInitializer);
        authPage.USER_NAME.sendKeys("airat.basyrov");
        authPage.PASSWORD.sendKeys("qwerty123456");
        authPage.AUTH_PAGE_BUTTON.click();
        WebDriverWait wait = new WebDriverWait(driverInitializer.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(CHECK_TITLE));
        WebElement title = driverInitializer.driver.findElement(CHECK_TITLE);
        Assertions.assertEquals("My Projects", title.getText());
    }
}
