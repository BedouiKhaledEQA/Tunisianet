package com.Tunisianet;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public static Properties props = new Properties();

    public Base() {
        String environnement = System.getProperty("env", "local");
        String filePath = "src/main/java/com/Tunisianet/Properties/";

        // Charge le fichier de configuration en fonction de l'environnement
        File file = new File(filePath + environnement + "_config.properties");
        try (FileInputStream fis = new FileInputStream(file)) {
            props.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Échec du chargement du fichier de configuration pour l'environnement : " + environnement, e);
        }
    }

    public static WebDriver luncher() throws MalformedURLException {
        String browser = System.getProperty("browser", "chrome");
        String environnement = System.getProperty("env", "local");
        String os = props.getProperty("os", "windows");

        if ("prod".equalsIgnoreCase(environnement)) {
            DesiredCapabilities des = new DesiredCapabilities();
            des.setPlatform(getPlatform(os));

            // Configuration des options selon le navigateur
            boolean isHeadless = Boolean.parseBoolean(props.getProperty("chromeHeadless", "true"));
            switch (browser.toLowerCase()) {
                case "chrome":
                    des.setBrowserName("chrome");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    if (isHeadless) {
                        chromeOptions.addArguments("--headless");
                    }
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
                    break;
                case "firefox":
                    des.setBrowserName("firefox");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"), des);
                    break;
                case "edge":
                    des.setBrowserName("edge");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444"), des);
                    break;
                default:
                    throw new RuntimeException("Navigateur non pris en charge : " + browser);
            }
        } else { // Mode local
            driver = getLocalDriver(browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(props.getProperty("url"));
        return driver;
    }

    // Méthode pour obtenir la plateforme en fonction de l'OS
    private static Platform getPlatform(String os) {
        switch (os.toLowerCase()) {
            case "windows":
                return Platform.WIN10;
            case "mac":
                return Platform.MAC;
            default:
                throw new RuntimeException("Système d'exploitation non pris en charge : " + os);
        }
    }

    // Méthode pour obtenir le driver en mode local
    private static WebDriver getLocalDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                boolean isHeadlessLocal = Boolean.parseBoolean(props.getProperty("chromeHeadless", "true"));
                if (isHeadlessLocal) {
                    chromeOptions.addArguments("--headless");
                }
                return new ChromeDriver(chromeOptions);
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
            default:
                throw new RuntimeException("Navigateur non pris en charge : " + browser);
        }
    }
}
