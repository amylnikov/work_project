package ru.idsys.idbank.fns.innflchk.tests.UI;

import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.idsys.idbank.fns.innflchk.model.InnFLRqData;
import ru.idsys.idbank.fns.innflchk.model.InnFLRqs;
import ru.idsys.idbank.fns.innflchk.tests.TestBase;

import java.text.ParseException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Класс набора тестов Удаление документа («Запрос проверки ИНН ФЛ»)
 * @author a.mylnikov
 */
public class InnFLRqDeletionTests extends TestBase {
    private ArrayList<Integer> runStatus = new ArrayList<Integer>();
    private ArrayList<String> exeption = new ArrayList<String>();

    @BeforeTest
    /**
     * Проверка наличия актуальной для тестирования сборки
     */
    public void checkNewBuildForTesting(){
        if(!app.testLink().checkAvailableBuilds(5032)) {
            app.stop();
            System.out.println("Нет новых сборок для прогона.");
            System.exit(-1);
        }
    }

    @BeforeMethod
    /**
     * Предварительная подготовка среды для выполнения теста
     * Удаляет записи из Системы при их наличии
     * Подготавливает тестовые записи для выполнения условий тестов
     */
    public void ensurePreconditions() throws ParseException {
        if(app.db().getAllInnFlRequests().size() > 5){
            app.db().deleteAllData();
        }
        for(int i = 1; i < 5; i++){
            InnFLRqData preData = new InnFLRqData().withPersonInn("012345678987")
                    .withLastName("Предварительно" + i).withFirstName("Заполненный" + i).withSecondName("Чувак" + i)
                    .withDulDocId("21").withDocName("ПасРФ").withDulSerial("9999").withDulNumber("888888").withDulDate("05.03.1917")
                    .withDulEmitentName("РОВД по гроду Тамбову").withDulDeptCode("800-008");
            app.db().insertRow(preData);
        }
    }

    @BeforeMethod(enabled = true)
    /**
     * Метод проверки не закрытого всплывающего окна перед тестами
     */
    public void escapePopupContent() throws InterruptedException {
        if(app.innFlRequest().checkPopupContent()){
            app.innFlRequest().clickFormButton("OK");
        }
    }

    @Test(priority = 1, enabled = true)
    /**
     * Тест-кейс: Удаление одного выбранного документа
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 3) Выбрать существующий документ
     * 4) Нажать кнопку "Удалить"
     * 5) Обновить список
     * 6) Сравнить количество записей в списке до и после сохранения
     * 7) Получить из БД список всех имеющихся документов модуля
     * 8) Проверить корректность сохраненных данных
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentDeleteSingle() throws ParseException, InterruptedException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData deletedDocument = dataBefore.iterator().next();
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().refreshScroll();
        app.innFlRequest().highlightRowById(deletedDocument.getId());
        app.innFlRequest().deleteDocument();
        app.innFlRequest().clickFormButton("Да");
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size() - 1));
        InnFLRqs dataAfter = app.db().getAllInnFlRequests();
        assertThat("Не совпадают сохраненные данные с теми, которые вносились!", dataAfter, equalTo(dataBefore.without(deletedDocument)));
    }


    @Test(priority = 2, enabled = true)
    /**
     * Тест-кейс: Удаление нескольких выбранных документов
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 3) Выбрать несколько существующих документов
     * 4) Нажать кнопку "Удалить"
     * 5) Обновить список
     * 6) Сравнить количество записей в списке до и после сохранения
     * 7) Получить из БД список всех имеющихся документов модуля
     * 8) Проверить корректность сохраненных данных
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentDeleteMultiple() throws ParseException, InterruptedException {
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().refreshScroll();
        app.innFlRequest().highlightAllRows();
        app.innFlRequest().deleteDocument();
        app.innFlRequest().clickFormButton("Да");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(0));
        InnFLRqs dataAfter = app.db().getAllInnFlRequests();
        assertThat("Не совпадают сохраненные данные с теми, которые вносились!", dataAfter, equalTo(new InnFLRqs()));
    }

    @Test(priority = 3, enabled = true)
    /**
     * Тест-кейс: Отмена удаления выбранного документа
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 3) Выбрать существующий документ
     * 4) Нажать кнопку "Удалить"
     * 5) Не подтверждать удаление
     * 6) Обновить список
     * 7) Сравнить количество записей в списке до и после сохранения
     * 8) Получить из БД список всех имеющихся документов модуля
     * 9) Проверить корректность сохраненных данных
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentDeleteWithoutConfirm() throws ParseException, InterruptedException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData deletedDocument = dataBefore.iterator().next();
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().refreshScroll();
        app.innFlRequest().highlightRowById(deletedDocument.getId());
        app.innFlRequest().deleteDocument();
        app.innFlRequest().clickFormButton("Нет");
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
        InnFLRqs dataAfter = app.db().getAllInnFlRequests();
        assertThat("Не совпадают сохраненные данные с теми, которые вносились!", dataAfter, equalTo(dataBefore));
    }


    @AfterMethod
    /**
     * После каждого теста получает статус прогона теста
     */
    public void getTestsRunStatus(ITestResult result){
        runStatus.add(result.getStatus());
        if(result.getThrowable() != null) {
            exeption.add(result.getThrowable().toString());
        }else{
            exeption.add("");
        }
    }

    @AfterTest()
    /**
     * После всех тестов отмечает в Тестлинке статус по каждому пройденному кейсу и по сьюту вцелом
     */
    public void closeCasesInTestlink() {
        app.testLink().putTestResults(runStatus, exeption, 5032, 25);
    }
}
