package ru.idsys.idbank.gisgmp.UI.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.idsys.idbank.gisgmp.UI.appmanager.ApplicationManager;

/**
 * Вспомогательный класс, в который вынесены общие процессы для большинства тестов.
 * Как пример - инициализация и запуск браузера перед выполнением тестов.
 * @author a.mylnikov
 */

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }
}
