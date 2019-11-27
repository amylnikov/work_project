package ru.idsys.idbank.fns.innflchk.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.idsys.idbank.fns.innflchk.appmanager.ApplicationManager;

import java.util.concurrent.TimeUnit;


/**
 * Вспомогательный класс, в который вынесены общие процессы для большинства тестов.
 * Как пример - инициализация и запуск браузера перед выполнением тестов.
 * @author a.mylnikov
 */

public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    /**
     * Метод для создания задержки в тестах,
     * для избежания проблем с интерфейсными лагами
     * @param seconds Параметр для передачи количества секунд
     * @throws InterruptedException
     */
    public void waitToContinue(long seconds) throws InterruptedException {
        TimeUnit.SECONDS.sleep(seconds);
    }

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        app.stop();
    }

}
