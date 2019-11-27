package ru.idsys.idbank.gisgmp.WS.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.idsys.idbank.gisgmp.WS.appmanager.ApplicationManager;

/**
 * Вспомогательный класс, в который вынесены общие процессы для большинства тестов.
 * Как пример - инициализация и запуск браузера перед выполнением тестов.
 * @author a.mylnikov
 */

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager("");

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(enabled = false)
    public void tearDown() {
        app.stop();
    }
}
