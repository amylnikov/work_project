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
 * Класс набора тестов Редактирование документа («Запрос проверки ИНН ФЛ»)
 * @author a.mylnikov
 */
public class InnFLRqModificationTests extends TestBase {
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
     * Подготавливает одну запись через БД
     */
    public void ensurePreconditions() throws ParseException {
        InnFLRqs docs = app.db().getAllInnFlRequests();
        InnFLRqData preData = new InnFLRqData().withPersonInn("012345678987")
                .withLastName("Предварительно").withFirstName("Заполненный").withSecondName("Чувак")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("9999").withDulNumber("888888").withDulDate("05.03.1917")
                .withDulEmitentName("РОВД по гроду Тамбову").withDulDeptCode("800-008");
        if(docs.size() > 0){
            app.db().deleteAllData();
            app.db().insertRow(preData);
        }else if(docs.size() == 0){
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
     * Тест-кейс: Изменение данных в существующем документе
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные со всеми заполнеными полями
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Выбрать и открыть существующий документ в статусе "Новый"
     * 5) Нажть кнопку "Редактировать"
     * 6) Изменить данные в полях тестовыми значениями
     * 7) Сохранить и закрыть документ
     * 8) Обновить список
     * 9) Сравнить количество записей в списке до и после сохранения
     * 10) Получить из БД список всех имеющихся документов модуля
     * 11) Проверить корректность сохраненных данных
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentEditDataAndSave() throws ParseException, InterruptedException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData editedDocument = dataBefore.iterator().next();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("103456789012")
                .withLastName("Иванов").withFirstName("Егор").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulNumber("222222").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("000-000");
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().refreshScroll();
        app.innFlRequest().highlightFirstRow();
        app.innFlRequest().editExistDocument();
        app.innFlRequest().clickFormButton("Редактировать");
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Сохранить");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
        InnFLRqs dataAfter = app.db().getAllInnFlRequests();
        assertThat("Не совпадают сохраненные данные с теми, которые вносились!", dataAfter, equalTo(dataBefore.without(editedDocument).withAdded(newDocumentData.withId(dataAfter.stream().mapToLong((c) -> c.getId()).max().getAsLong()).withDocStatusId("1"))));
    }


    @Test(priority = 2, enabled = true)
    /**
     * Тест-кейс: Изменение данных в существующем документе без сохранения
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные со всеми заполнеными полями
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Выбрать и открыть существующий документ в статусе "Новый"
     * 5) Нажть кнопку "Редактировать"
     * 6) Изменить данные в полях тестовыми значениями
     * 7) Закрыть документ без сохранения
     * 8) Обновить список
     * 9) Сравнить количество записей в списке до и после сохранения
     * 10) Получить из БД список всех имеющихся документов модуля
     * 11) Проверить корректность сохраненных данных
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentEditDataNoSaving() throws ParseException, InterruptedException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("103456789012")
                .withLastName("Иванов").withFirstName("Егор").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulNumber("222222").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("000-000");
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().refreshScroll();
        app.innFlRequest().highlightFirstRow();
        app.innFlRequest().editExistDocument();
        app.innFlRequest().clickFormButton("Редактировать");
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().clickFormButton("Нет");
        app.innFlRequest().refreshScroll();
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
        app.testLink().putTestResults(runStatus, exeption, 5032, 21);
    }
}
