package testTracker;

import config.DriverInitializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthPage;
import java.time.Duration;
import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class AuthTest {
    private final By CHECK_TITLE = By.xpath("//h1[contains(@class,'title')]");


    static Stream<Arguments> browserArguments() {
        return Stream.of(
                arguments("chrome", "100.0"),
                arguments("firefox", "99.0")
        );
    }

    @ParameterizedTest
    @MethodSource("browserArguments")
    public void authCase002(String browser, String version) {
        DriverInitializer driverInitializer = new DriverInitializer();
        driverInitializer.setCapabilitiesByArguments(browser, version);
        AuthPage authPage1 = new AuthPage(driverInitializer);
        authPage1.USER_NAME.sendKeys("airat.basyrov");
        authPage1.PASSWORD.sendKeys("  user1");
        authPage1.AUTH_PAGE_BUTTON.click();
        WebElement element = (new WebDriverWait(driverInitializer.driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(authPage1.errorMessage))));
        String errMesPage = authPage1.ERROR_MESSAGE.getText();
        Assertions.assertEquals("Неверный логин/пароль. Проверьте данные", errMesPage);
        driverInitializer.driver.quit();
    }

    @ParameterizedTest
    @MethodSource("browserArguments")
    public void authCase003(String browser, String version) {
        DriverInitializer driverInitializer = new DriverInitializer();
        driverInitializer.setCapabilitiesByArguments(browser,version);
        AuthPage authPage = new AuthPage(driverInitializer);
        authPage.USER_NAME.sendKeys("airat.basyrov");
        boolean disable = !authPage.AUTH_PAGE_BUTTON.isEnabled();
        Assertions.assertTrue(disable);
        driverInitializer.driver.quit();
    }

    @ParameterizedTest
    @MethodSource("browserArguments")
    public void authCase004(String browser, String version) {
        DriverInitializer driverInitializer = new DriverInitializer();
        driverInitializer.setCapabilitiesByArguments(browser,version);
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
}
