package testTracker.testingInOneBrowser;

import config.DriverInitializer;
import helpers.Attach;
import helpers.ScreenshotExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthPage;
import java.net.MalformedURLException;
import java.time.Duration;
import static io.qameta.allure.Allure.step;


public class AuthTestInOneBrowser {

    private final By CHECK_TITLE = By.xpath("//h1[contains(@class,'title')]");
    DriverInitializer driverInitializer;

    @DisplayName("Тестирования ввода невалидного пароля")
    @Test
    public void authCase002() throws MalformedURLException {
        driverInitializer = new DriverInitializer();

        step("Иинициализируем дайвер и открываем страницу авторизации",() -> {
            driverInitializer.initWebDriver();
        });

        AuthPage authPage1 = new AuthPage(driverInitializer);

        step("Вводим валидный логин",() -> {
            authPage1.USER_NAME.sendKeys("airat.basyrov1");
        });

        step("Вводим не валидный пароль",() -> {
            authPage1.PASSWORD.sendKeys("qwerty123456");
        });

        step("Нажимаем кнопку Войти",() -> {
            authPage1.AUTH_PAGE_BUTTON.click();
        });
        WebElement element = (new WebDriverWait(driverInitializer.driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(authPage1.errorMessage))));
        String errMesPage = authPage1.ERROR_MESSAGE.getText();
        step("Проверяем, что отобразилось информационное сообщение о вводе не правильного пароля",() -> {
            Assertions.assertEquals("Неверный логин/пароль. Проверьте данные xdghxdfgh", errMesPage);
        });
    }

    @DisplayName("Проверка задизейбленной кнопки Войти")
    @Test
    public void authCase003() throws MalformedURLException {
        DriverInitializer driverInitializer = new DriverInitializer();
        driverInitializer.initWebDriver();
        AuthPage authPage = new AuthPage(driverInitializer);
        authPage.USER_NAME.sendKeys("airat.basyrov");
        boolean disable = !authPage.AUTH_PAGE_BUTTON.isEnabled();
        Assertions.assertTrue(disable);
        driverInitializer.driver.quit();
    }

    @DisplayName("Вход на трекер")
    @Test
    public void authCase004() throws MalformedURLException {
        DriverInitializer driverInitializer = new DriverInitializer();
        driverInitializer.initWebDriver();
        AuthPage authPage = new AuthPage(driverInitializer);
        authPage.USER_NAME.sendKeys("airat.basyrov");
        authPage.PASSWORD.sendKeys("qwerty123456");
        authPage.AUTH_PAGE_BUTTON.click();
        WebDriverWait wait = new WebDriverWait(driverInitializer.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(CHECK_TITLE));
        WebElement title = driverInitializer.driver.findElement(CHECK_TITLE);
        Assertions.assertEquals("My Projects", title.getText());
        driverInitializer.driver.quit();
    }
    @AfterEach
    public void takeScreen(){
        Attach.screenshotAs(driverInitializer.driver);
    }

}
