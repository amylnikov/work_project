package ru.idsys.idbank.fns.innflchk.appmanager;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Класс управления приложением
 * @author a.mylnikov
 */


public class ApplicationManager {
    private final Properties properties;
    WebDriver wd;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private String browser;
    private InnFLHelper innFLHelper;
    private RDBHelper RDBHelper;
    private TestlinkHelper testlinkHelper;

    /**
     * Базовый конструктор класса
     * @param browser Код используемого браузера
     */
    public ApplicationManager(String browser){
        this.browser = browser;
        properties = new Properties();
    }

    /**
     * Метод инициализации веб-драйвера и впомогательных классов
     * @throws IOException Проброс ошибки
     */
    public void init() throws IOException {
        String target =  System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        RDBHelper = new RDBHelper();
        testlinkHelper = new TestlinkHelper();

        if ("".equals(properties.getProperty("selenium.server"))) {
            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary(properties.getProperty("web.firefoxPath")));
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver(new ChromeOptions().setBinary(properties.getProperty("web.chromePath")));
            } else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }
        }else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "win10")));
            wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
        }
        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseURL"));
        //wd.manage().window().maximize();

        innFLHelper = new InnFLHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login(properties.getProperty("web.UIInnFlChkUserLogin"), properties.getProperty("web.UIInnFlChkUserPassword"));

    }

    /**
     * Метод отключения драйвера
     */
    public void stop() {
        wd.quit();
    }




    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public InnFLHelper innFlRequest(){
        return innFLHelper;
    }

    public RDBHelper db(){return RDBHelper;}

    public TestlinkHelper testLink(){return testlinkHelper;}


    /**
     * Метод создающий параллельную сессию для авторизации с админскими правами
     * Используется в случае необходимости изменения каких-либо настроек
     * @throws IOException
     */
    public void adminBrowserSession () throws IOException {
        String target =  System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if ("".equals(properties.getProperty("selenium.server"))) {
            if (browser.equals(BrowserType.FIREFOX)) {
                wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary(properties.getProperty("web.firefoxPath")));
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver(new ChromeOptions().setBinary(properties.getProperty("web.chromePath")));
            } else if (browser.equals(BrowserType.IE)) {
                wd = new InternetExplorerDriver();
            }
        }else {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(browser);
            capabilities.setPlatform(Platform.fromString(System.getProperty("platform", "win10")));
            wd = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
        }

        wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseURL"));

        sessionHelper = new SessionHelper(wd);

        sessionHelper.login(properties.getProperty("web.bankAdminUserLogin"), properties.getProperty("web.bankAdminUserPassword"));
    }

}
