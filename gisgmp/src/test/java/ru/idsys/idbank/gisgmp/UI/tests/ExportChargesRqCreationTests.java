package ru.idsys.idbank.gisgmp.UI.tests;

import org.testng.annotations.Test;
import ru.idsys.idbank.gisgmp.UI.model.ChargesRq;
import ru.idsys.idbank.gisgmp.UI.model.ChargesRqData;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Класс с тест-кейсами проверок модуля Запрос начислений ГИС ГМП
 * из пользовательского интерфейса
 * @author a.mylnikov
 */
public class ExportChargesRqCreationTests extends TestBase{

    /*   @BeforeMethod  //Не прокатило
    public void ensurePreconditions(){
        if(!app.db().currentGMPFormatVersion().equals("2_1")){
            app.db().setGMPFormatVersion("2_1");
        }
    }
    */

    /**
     * Тест-кейс: Создание Запроса начислений ГИС ГМП из интерфеса (Заполняются все доступные поля)
     * Предусловие: Формат версии ГИС ГМП = 2.1
     * Описание:
     * 1) Авторизоваться в Системе под пользователем с ролями открывающими доступ к разделу "ГИС ГМП - Экспорт начислений ГИС ГМП"
     * 2) Создать новый документ "Запрос экспорта начислений ГИС ГМП"
     * 3) Заполнить все доступные поля данными
     * 4) Сохранить документ
     * О.Р.
     * Документ успешно создается в Системе
     * @throws InterruptedException Проброс ошибки
     */
    @Test
    public void testCreateExportChargesRqWithAllFields() throws InterruptedException, MalformedURLException {
        ChargesRq before = app.db().getAllChargesRq();
        System.out.println("Количество записей в таблице = " + before.size());
        if (before.size() != 0) {
            System.out.println(before.iterator().next().getId() + " | "
                    + before.iterator().next().getDataRequestType() + " | "
                    + before.iterator().next().getStartDateTime() + " | "
                    + before.iterator().next().getEndDateTime() + " | "
                    + before.iterator().next().getQtObjInPortion() + " | "
                    + before.iterator().next().getIdAccountEsia() + " | "
                    + before.iterator().next().getIdSessionEsia() + " | "
                    + before.iterator().next().getDateTimeSessionOpen() + " | "
                    + before.iterator().next().getUserType() + " | "
                    + before.iterator().next().getInn() + " | "
                    + before.iterator().next().getSupplierBillId() + " | "
                    + before.iterator().next().getPayerIdentifier() + " | "
                    + before.iterator().next().getApplicationId());
        }
        ChargesRqData chargeRq = new ChargesRqData();
        if (app.db().currentGMPFormatVersion().equals("2_1") || app.db().currentGMPFormatVersion().equals("2_0")) {
            chargeRq.withDataRequestType("Неоплаченные предварительные начисления")
                    .withStartDateTime("05.03.2019 11:51:00")
                    .withEndDateTime("05.03.2019 11:51:00")
                    .withQtObjInPortion("120")
                    .withIdAccountEsia("209111001")
                    .withIdSessionEsia("332")
                    .withDateTimeSessionOpen("01.03.2019 12:51:00")
                    .withUserType("Индивидуальный предприниматель")
                    .withInn("123456789012")
                    .withSupplierBillId("32117072411021588933")
                    .withPayerIdentifier("2100000000123456789012643")
                    .withApplicationId("123");
        } else{
            chargeRq.withDataRequestType("Неоплаченные предварительные начисления")
                    .withStartDateTime("05.03.2019 11:51:00")
                    .withEndDateTime("05.03.2019 11:51:00")
                    .withQtObjInPortion("120")
                    .withSupplierBillId("32117072411021588933")
                    .withPayerIdentifier("2100000000123456789012643")
                    .withApplicationId("123");
        }


            app.goTo().menuSection("Экспорт начислений ГИС ГМП");
            TimeUnit.SECONDS.sleep(1);
            app.charges().createNew();
            app.charges().fillChargesRqForm("Все поля заполнены", chargeRq);
            TimeUnit.SECONDS.sleep(1);
            app.charges().refreshScroll();
            assertThat(app.charges().countInVisibleScroll(), equalTo(before.size() + 1));
            ChargesRq after = app.db().getAllChargesRq();
            assertThat(after, equalTo(before.withAdded(chargeRq.withId(after.stream().mapToLong((c) -> c.getId()).max().getAsLong()))));
            app.testlink().testlinkAPIClient();
    }
}
