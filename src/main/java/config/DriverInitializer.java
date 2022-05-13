package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverInitializer {

    public String browser;
    public WebDriver driver;

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

        //if (browser.equals("chrome")){
        //    driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), chromeOptions());
       // }
       // else {
      //      driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub/"), firefoxOptions());
      //  }
    }

}
