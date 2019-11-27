package ru.idsys.idbank.fns.innflchk.tests.UI;


import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.idsys.idbank.fns.innflchk.model.InnFLRqData;
import ru.idsys.idbank.fns.innflchk.model.InnFLRqs;
import ru.idsys.idbank.fns.innflchk.tests.TestBase;


import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Класс набора тестов Создание нового документа в системе («Запрос проверки ИНН ФЛ»).
 * @author a.mylnikov
 */

public class InnFLRqNewCreationTests extends TestBase {
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
        if(docs.size() > 1){
            app.db().deleteAllData();
            app.db().insertRow(preData);
        }else if(docs.size() == 0){
            app.db().insertRow(preData);
        }
    }

    @BeforeMethod
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
     * Тест-кейс: Создание документа с заполнением всех полей корректными данными
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные со всеми заполнеными полями
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Нажть кнопку "Создать"
     * 5) Заполнить поля данными
     * 6) Сохранить и закрыть документ
     * 7) Обновить список
     * 8) Сравнить количество записей в списке до и после сохранения
     * 9) Получить из БД список всех имеющихся документов модуля
     * 10)Проверить корректность сохраненных данных
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationWithAllCorrectData() throws InterruptedException, ParseException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("103456789012")
                .withLastName("Иванов").withFirstName("Егор").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulNumber("222222").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("000-000");
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Сохранить");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size() + 1));
        InnFLRqs dataAfter = app.db().getAllInnFlRequests();
        assertThat("Не совпадают сохраненные данные с теми, которые вносились!", dataAfter, equalTo(dataBefore.withAdded(newDocumentData.withId(dataAfter.stream().mapToLong((c) -> c.getId()).max().getAsLong()).withDocStatusId("1"))));
    }


    @Test(priority = 2, enabled = true)
    /**
     * Тест-кейс: Создание документа без заполнения полей данными
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 3) Нажть кнопку "Создать"
     * 4) Сохранить документ
     * 5) Сравнить полученное сообщение об ошибке с ожидаемым результатом
     * 6) Обновить список
     * 7) Сравнить количество записей в списке до и после сохранения
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationWithoutDataFilling() throws InterruptedException, ParseException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().clickFormButton("Сохранить");
        assertThat("Не выведено предупреждающее окно!", app.innFlRequest().checkPopupContent(), equalTo(true));
        app.innFlRequest().clickFormButton("OK");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
    }


    @Test(priority = 3, enabled = true)
    /**
     * Тест-кейс: Создание документа с заполнением только обязательных полей
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные только с обязательными полями
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Нажть кнопку "Создать"
     * 5) Заполнить поля данными
     * 6) Сохранить и закрыть документ
     * 7) Обновить список
     * 8) Сравнить количество записей в списке до и после сохранения
     * 9) Получить из БД список всех имеющихся документов модуля
     * 10) Проверить корректность сохраненных данных
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationWithRequiredData() throws InterruptedException, ParseException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("103456789012")
                .withLastName("Иванов").withFirstName("Егор")
                .withDulDocId("21").withDocName("ПасРФ").withDulNumber("222222");

        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Сохранить");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size() + 1));
        InnFLRqs dataAfter = app.db().getAllInnFlRequests();
        assertThat("Не совпадают сохраненные данные с теми, которые вносились!", dataAfter, equalTo(dataBefore.withAdded(newDocumentData.withId(dataAfter.stream().mapToLong((c) -> c.getId()).max().getAsLong()).withDocStatusId("1"))));
    }

    @Test(priority = 4, enabled = true)
    /**
     * Тест-кейс: Создание документа с незаполненным обязательным полем ИНН
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные без обязательного поля ИНН
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Нажть кнопку "Создать"
     * 5) Заполнить поля данными
     * 6) Сохранить документ
     * 7) Сравнить полученное сообщение об ошибке с ожидаемым результатом
     * 8) Обновить список
     * 9) Сравнить количество записей в списке до и после сохранения
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationWithoutInn() throws InterruptedException, ParseException, IOException, UnsupportedFlavorException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData
                .withLastName("Иванов").withFirstName("Егор").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulNumber("222222").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("000-000");

        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Сохранить");
        assertThat("Не выведено предупреждающее окно!", app.innFlRequest().checkPopupContent(), equalTo(true));
        assertThat("Предупреждающее сообщение не соответствует ожидаемому результату!", app.innFlRequest().getPopupContent(), equalTo("Запрос проверки ИНН ФЛ:- не заполнено поле \"ИНН\" (FNS_INN_PERSON_TEST_QUERY::PERSON_INN)"));
        app.innFlRequest().clickFormButton("OK");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().clickFormButton("Нет");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
    }

    @Test(priority = 5, enabled = true)
    /**
     * Тест-кейс: Создание документа с незаполненным обязательным полем Фамилия
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные без обязательного поля Фамилия
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Нажть кнопку "Создать"
     * 5) Заполнить поля данными
     * 6) Сохранить документ
     * 7) Сравнить полученное сообщение об ошибке с ожидаемым результатом
     * 8) Обновить список
     * 9) Сравнить количество записей в списке до и после сохранения
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationWithoutLastName() throws InterruptedException, ParseException, IOException, UnsupportedFlavorException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("103456789012")
                .withFirstName("Егор").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulNumber("222222").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("000-000");

        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Сохранить");
        assertThat("Не выведено предупреждающее окно!", app.innFlRequest().checkPopupContent(), equalTo(true));
        assertThat("Предупреждающее сообщение не соответствует ожидаемому результату!", app.innFlRequest().getPopupContent(), equalTo("Запрос проверки ИНН ФЛ:- не заполнено поле \"Фамилия\" (FNS_INN_PERSON_TEST_QUERY::LAST_NAME)"));
        app.innFlRequest().clickFormButton("OK");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().clickFormButton("Нет");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
    }

    @Test(priority = 6, enabled = true)
    /**
     * Тест-кейс: Создание документа с незаполненным обязательным полем Имя
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные без обязательного поля Имя
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Нажть кнопку "Создать"
     * 5) Заполнить поля данными
     * 6) Сохранить документ
     * 7) Сравнить полученное сообщение об ошибке с ожидаемым результатом
     * 8) Обновить список
     * 9) Сравнить количество записей в списке до и после сохранения
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationWithoutFirstName() throws InterruptedException, ParseException, IOException, UnsupportedFlavorException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("103456789012")
                .withLastName("Антонов").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulNumber("222222").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("000-000");

        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Сохранить");
        assertThat("Не выведено предупреждающее окно!", app.innFlRequest().checkPopupContent(), equalTo(true));
        assertThat("Предупреждающее сообщение не соответствует ожидаемому результату!", app.innFlRequest().getPopupContent(), equalTo("Запрос проверки ИНН ФЛ:- не заполнено поле \"Имя\" (FNS_INN_PERSON_TEST_QUERY::FIRST_NAME)"));
        app.innFlRequest().clickFormButton("OK");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().clickFormButton("Нет");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
    }

    @Test(priority = 7, enabled = true)
    /**
     * Тест-кейс: Создание документа с незаполненным обязательным полем Номер ДУЛ
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные без обязательного поля Номер ДУЛ
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Нажть кнопку "Создать"
     * 5) Заполнить поля данными
     * 6) Сохранить документ
     * 7) Сравнить полученное сообщение об ошибке с ожидаемым результатом
     * 8) Обновить список
     * 9) Сравнить количество записей в списке до и после сохранения
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationWithoutDulNumber() throws InterruptedException, ParseException, IOException, UnsupportedFlavorException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("103456789012")
                .withLastName("Антонов").withFirstName("Игорь").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("000-000");

        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Сохранить");
        assertThat("Не выведено предупреждающее окно!", app.innFlRequest().checkPopupContent(), equalTo(true));
        assertThat("Предупреждающее сообщение не соответствует ожидаемому результату!", app.innFlRequest().getPopupContent(), equalTo("Запрос проверки ИНН ФЛ:- не заполнено поле \"Номер ДУЛ\" (FNS_INN_PERSON_TEST_QUERY::DUL_NUMBER)"));
        app.innFlRequest().clickFormButton("OK");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().clickFormButton("Нет");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
    }

    @Test(priority = 8, enabled = true)
    /**
     * Тест-кейс: Создание документа с некорректно заполненным «ИНН»
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные с некорректно заполненным полем "ИНН"
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Нажать кнопку "Создать"
     * 5) Заполнить поля данными
     * 6) Сохранить документ
     * 7) Сравнить полученное сообщение об ошибке с ожидаемым результатом
     * 8) Обновить список
     * 9) Сравнить количество записей в списке до и после сохранения
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationWithWrongInn() throws InterruptedException, ParseException, IOException, UnsupportedFlavorException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("1234")
                .withLastName("Антонов").withFirstName("Игорь").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulNumber("232323").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("000-000");

        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Сохранить");
        assertThat("Не выведено предупреждающее окно!", app.innFlRequest().checkPopupContent(), equalTo(true));
        assertThat("Предупреждающее сообщение не соответствует ожидаемому результату!", app.innFlRequest().getPopupContent(), equalTo("Неверный формат ИНН"));
        app.innFlRequest().clickFormButton("OK");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().clickFormButton("Нет");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
    }

    @Test(priority = 9, enabled = true)
    /**
     * Тест-кейс: Создание документа с некорректно заполненным «Код подразделения орг. выдавшей ДУЛ»
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные с некорректно заполненным полем "Код подразделения орг. выдавшей ДУЛ"
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Нажать кнопку "Создать"
     * 5) Заполнить поля данными
     * 6) Сохранить документ
     * 7) Сравнить полученное сообщение об ошибке с ожидаемым результатом
     * 8) Обновить список
     * 9) Сравнить количество записей в списке до и после сохранения
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationWithWrongDulDeptCode() throws InterruptedException, ParseException, IOException, UnsupportedFlavorException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("103456789012")
                .withLastName("Антонов").withFirstName("Игорь").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulNumber("000000").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("0000");

        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Сохранить");
        assertThat("Не выведено предупреждающее окно!", app.innFlRequest().checkPopupContent(), equalTo(true));
        assertThat("Предупреждающее сообщение не соответствует ожидаемому результату!", app.innFlRequest().getPopupContent(), equalTo("Код подразделения орг выдавшей ДУЛ, должен иметь длину  символов"));
        app.innFlRequest().clickFormButton("OK");
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().clickFormButton("Нет");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
    }

    @Test(priority = 10, enabled = true)
    /**
     * Тест-кейс: Создание документа без сохранения
     * Шаги:
     * 1) Получить из БД список всех имеющихся документов модуля
     * 2) Подготовить тестовые данные с заполнением всех полей
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Нажать кнопку "Создать"
     * 5) Заполнить поля данными
     * 6) Закрыть форму без сохранения данных
     * 7) Обновить список
     * 8) Сравнить количество записей в списке до и после сохранения
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDocumentCreationNoSaving() throws InterruptedException, ParseException {
        InnFLRqs dataBefore = app.db().getAllInnFlRequests();
        InnFLRqData newDocumentData = new InnFLRqData();
        newDocumentData.withPersonInn("103456789012")
                .withLastName("Антонов").withFirstName("Игорь").withSecondName("Петрович")
                .withDulDocId("21").withDocName("ПасРФ").withDulSerial("1111").withDulNumber("000000").withDulDate("01.11.1988")
                .withDulEmitentName("ОВД по Тверской области").withDulDeptCode("000-000");

        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().createNew();
        app.innFlRequest().formFilling(newDocumentData);
        app.innFlRequest().clickFormButton("Закрыть");
        app.innFlRequest().clickFormButton("Нет");
        app.innFlRequest().refreshScroll();
        assertThat("Количество записей в списке не совпадает с количеством в базе!", app.innFlRequest().countInVisibleScroll(), equalTo(dataBefore.size()));
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
        app.testLink().putTestResults(runStatus, exeption,5032, 5);
    }
}
