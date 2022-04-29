package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static config.WebDriverInitializer.driver;

public class AuthPage {

    @FindBy(xpath = "//button[contains(@class, 'btn')]")
    public WebElement AUTH_PAGE_BUTTON;
    @FindBy(name = "username")
    public WebElement USER_NAME;
    @FindBy(name = "password")
    public WebElement PASSWORD;
    @FindBy(xpath = "//div[contains(@class, 'errorMessage')]")
    public WebElement ERROR_MESSAGE;

    public String errorMessage = "//div[contains(@class, 'errorMessage')]";

    public AuthPage (){
        PageFactory.initElements(driver, this);
    }

}
