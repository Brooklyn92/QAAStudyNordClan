package pages;

import config.DriverInitializer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {
    @FindBy(xpath = "//button[contains(@class, 'btn')]")
    public WebElement AUTH_PAGE_BUTTON;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement USER_NAME;

    @FindBy(name = "password")
    public WebElement PASSWORD;

    @FindBy(xpath = "//div[contains(@class, 'errorMessage')]")
    public WebElement ERROR_MESSAGE;

    public String errorMessage = "//div[contains(@class, 'errorMessage')]";


    public AuthPage(DriverInitializer driverInitializer) {
        PageFactory.initElements(driverInitializer.driver, this);
    }



}
