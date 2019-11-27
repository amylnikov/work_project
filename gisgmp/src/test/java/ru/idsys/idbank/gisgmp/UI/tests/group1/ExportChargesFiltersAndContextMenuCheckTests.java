package ru.idsys.idbank.gisgmp.UI.tests.group1;

import org.testng.annotations.Test;
import ru.idsys.idbank.gisgmp.UI.tests.TestBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExportChargesFiltersAndContextMenuCheckTests extends TestBase {

    @Test(enabled = false)
    public void testFilterStatus() throws InterruptedException, IOException {

        app.goTo().menuSection("Экспорт начислений ГИС ГМП");
        TimeUnit.SECONDS.sleep(1);
        app.charges().useStatusFilter("Новый");
        TimeUnit.SECONDS.sleep(1);
        int countInDB = app.db().countDocumentsInStatus("1");
        System.out.println("В БД запросов: " + countInDB);
        int countInUI = app.charges().countInVisibleScroll();
        System.out.println("В скроллере запросов: " + countInUI);
        assertThat(countInUI,equalTo(countInDB));
    }

    @Test
    public void testContextMenuSend() throws InterruptedException, IOException {
        app.adminBrowserSession();
        app.stop();
        int countInDBBefore = app.db().countDocumentsInStatus("1");
        app.goTo().menuSection("Экспорт начислений ГИС ГМП");
        TimeUnit.SECONDS.sleep(1);
        app.charges().useStatusFilter("Новый");
        TimeUnit.SECONDS.sleep(1);
        app.charges().useContextMenu("Отправить");
        TimeUnit.SECONDS.sleep(1);
        int countInDBAfter = app.db().countDocumentsInStatus("1");
        assertThat(countInDBBefore,equalTo(countInDBAfter + 1));
    }
}
