import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthPage;
import java.time.Duration;
import static config.WebDriverInitializer.driver;
import static config.WebDriverInitializer.initWebDriver;

public class AuthTest {
    private final By CHECK_TITLE = By.xpath("//h1[contains(@class,'title')]");
    private static AuthPage authPage;

    @BeforeEach
    public void setting() {
        initWebDriver();
        authPage = new AuthPage();
    }

    @Test
    public void authCase002() {
        authPage.USER_NAME.sendKeys("airat.basyrov");
        authPage.PASSWORD.sendKeys("  user1");
        authPage.AUTH_PAGE_BUTTON.click();
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(authPage.errorMessage))));
        String errMesPage = authPage.ERROR_MESSAGE.getText();
        Assertions.assertEquals("Неверный логин/пароль. Проверьте данные", errMesPage);
    }

    @Test
    public void authCase003() {
        authPage.USER_NAME.sendKeys("airat.basyrov");
        boolean disable = !authPage.AUTH_PAGE_BUTTON.isEnabled();
        Assertions.assertTrue(disable);
    }


    @Test
    public void authCase004() {
        authPage.USER_NAME.sendKeys("airat.basyrov");
        authPage.PASSWORD.sendKeys("qwerty123456");
        authPage.AUTH_PAGE_BUTTON.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(CHECK_TITLE));
        WebElement title = driver.findElement(CHECK_TITLE);
        Assertions.assertEquals("My Projects", title.getText());

    }

}
