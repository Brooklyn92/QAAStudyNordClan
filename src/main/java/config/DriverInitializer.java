package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverInitializer {

    //=======Настройка driver и Selenoid на двух браузерах и параллельным запуском каждго теста в двух браузерах одноверменно===============
    public WebDriver driver;

    public ChromeOptions chromeOptions(String browserName, String browserVersion){
        ChromeOptions capabilities = new ChromeOptions();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);
        capabilities.setCapability("enableVNC", true);
        return capabilities;
    }

    public FirefoxOptions firefoxOptions(String browserName, String browserVersion){
        FirefoxOptions capabilities = new FirefoxOptions();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", browserVersion);
        capabilities.setCapability("enableVNC", true);
        return capabilities;
    }

    public void setCapabilitiesByArguments(String browserName, String browserVersion) {
        if (browserName.equals("chrome")){
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"),
                        chromeOptions(browserName,browserVersion));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"),
                        firefoxOptions(browserName,browserVersion));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        driver.get("http://docker.nordclan:33220/login");
    }
}




//====================Настройка driver и Selenoid на одном браузере====================
/*
    public void initWebDriver() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        //driver = new ChromeDriver();
        //driver.manage().window().setPosition(new Point(2000, 0));
        //driver.manage().window().maximize();
        //driver.get("http://docker.nordclan:33220/login");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), options);
        driver.get("http://docker.nordclan:33220/login");

    }
 */


//================Настройка driver и Selenoid на двух браузерах========================
/*
    public ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        return options;
    }

    public FirefoxOptions firefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("enableVNC", true);
        options.setCapability("enableVideo", true);
        return options;
    }

    public DriverInitializer initDriverInitializer(String br) throws MalformedURLException {
        if (br.equals("chrome")) {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), chromeOptions());
        } else {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), firefoxOptions());
        }
        driver.get("http://docker.nordclan:33220/login");
        return this;
    }
*/
