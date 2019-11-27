package ru.idsys.idbank.fns.innflchk.tests.UI;

import org.testng.ITestResult;
import org.testng.annotations.*;
import ru.idsys.idbank.fns.innflchk.appmanager.HelperBase;
import ru.idsys.idbank.fns.innflchk.appmanager.RDBHelper;
import ru.idsys.idbank.fns.innflchk.model.InnFLRqData;
import ru.idsys.idbank.fns.innflchk.tests.TestBase;

import java.text.ParseException;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Класс набора тестов Панель фильтрации («Запрос проверки ИНН ФЛ»)
 * @author a.mylnikov
 */
public class FilterPanelChkTests extends TestBase {
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
     *
     */
    public void ensurePreconditions() throws ParseException {
        if(app.db().getAllInnFlRequests().size() >= 20){
            app.db().deleteAllData();
        }
        for(int i = 1; i < 21; i++){
            InnFLRqData preData = new InnFLRqData().withPersonInn("012345678987")
                    .withLastName("Предварительно").withFirstName("Заполненный" + i).withSecondName("Чувак" + i)
                    .withDulDocId("21").withDocName("ПасРФ").withDulSerial("9999").withDulNumber("888888").withDulDate("05.03.1917")
                    .withDulEmitentName("РОВД по гроду Тамбову").withDulDeptCode("800-008");
            app.db().insertRowWithRndData(preData);
            //if(i==2){
            //    app.db().insertRow(preData);
            //}
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
     * Тест-кейс: Применение фильтра «Статус»
     * Шаги:
     * 1) Подготовить тестовую среду для выполнения текущего теста
     * 2) Получить из БД информацию о количестве документов в статусах
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Указать в фильтре "Статус" значение для которого имеются документы
     * 5) Применить фильтр
     * 6) Сравнить количество отображаемых по фильтру документов в интерфейсе с количеством имеющихся в БД
     * 7) Указать в фильтре "Статус" значение для которого нет документов
     * 8) Применить фильтр
     * 9) Проверить отсутствие отображаемых документов в интерфейсе
     * 10) Сбросить фильтр
     * 11) Проверить что отображаются все имеющиеся документы
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testStatusFilterApply() throws InterruptedException, ParseException {
        app.db().dominantData();
        Integer sortCount = app.db().countDocumentsInStatus(RDBHelper.DOMINATOR.get("STATUS"));
        Integer unsortedCount = app.db().getAllInnFlRequests().size();
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Статус", null, HelperBase.STATUS.get(RDBHelper.DOMINATOR.get("STATUS")));
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(sortCount));
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Статус", null, HelperBase.STATUS.get("800"));
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(0));
        app.innFlRequest().clearFilters();
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(unsortedCount));
    }

    @Test(priority = 2, enabled = true)
    /**
     * Тест-кейс: Применение фильтров «Дата и время выполнения запроса с - по»
     * Шаги:
     * 1) Подготовить тестовую среду для выполнения текущего теста
     * 2) Получить из БД информацию о количестве документов за определенные даты и время выполнения запроса
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Указать в фильтрах "Дата и время выполнения запроса с - по" значения для которого имеются документы
     * 5) Применить фильтр
     * 6) Сравнить количество отображаемых по фильтру документов в интерфейсе с количеством имеющихся в БД
     * 7) Указать в фильтрах "Дата и время выполнения запроса с - по" значения для которого нет документов
     * 8) Применить фильтр
     * 9) Проверить отсутствие отображаемых документов в интерфейсе
     * 10) Сбросить фильтр
     * 11) Проверить что отображаются все имеющиеся документы
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testAnswerDateTimeFilterApply() throws InterruptedException, ParseException {
        app.db().dominantData();
        Integer unsortedCount = app.db().getAllInnFlRequests().size();
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Дата и время выполнения запроса с", "Дата и время выполнения запроса по",app.innFlRequest().dateTimeConvertForFilter(RDBHelper.DOMINATOR.get("ANSDATE")));
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(Integer.parseInt(RDBHelper.DOMINATOR.get("COUNT"))));
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Дата и время выполнения запроса с", "Дата и время выполнения запроса по", "01.01.2010 09:55:26");
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(0));
        app.innFlRequest().clearFilters();
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(unsortedCount));
    }


    @Test(priority = 3, enabled = true)
    /**
     * Тест-кейс: Применение фильтров «Дата создания с - по»
     * Шаги:
     * 1) Подготовить тестовую среду для выполнения текущего теста
     * 2) Получить из БД информацию о количестве документов за определенные даты создания запроса
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Указать в фильтрах "Дата создания с - по" значения для которого имеются документы
     * 5) Применить фильтр
     * 6) Сравнить количество отображаемых по фильтру документов в интерфейсе с количеством имеющихся в БД
     * 7) Указать в фильтрах "Дата создания с - по" значения для которого нет документов
     * 8) Применить фильтр
     * 9) Проверить отсутствие отображаемых документов в интерфейсе
     * 10) Сбросить фильтр
     * 11) Проверить что отображаются все имеющиеся документы
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testCreateDateTimeFilterApply() throws InterruptedException, ParseException {
        app.db().dominantData();
        Integer unsortedCount = app.db().getAllInnFlRequests().size();
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Дата создания с", "Дата создания по",app.innFlRequest().dateTimeConvertForFilter(RDBHelper.DOMINATOR.get("CREATEDATE")));
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(Integer.parseInt(RDBHelper.DOMINATOR.get("COUNT"))));
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Дата создания с", "Дата создания по", "01.01.2010 9:55:26");
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(0));
        app.innFlRequest().clearFilters();
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(unsortedCount));
    }

    @Test(priority = 4, enabled = true)
    /**
     * Тест-кейс: Применение фильтра «Фамилия»
     * Шаги:
     * 1) Подготовить тестовую среду для выполнения текущего теста
     * 2) Получить из БД информацию о количестве документов с разными фамилиями
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Указать в фильтре "Фамилия" значение для которого имеются документы
     * 5) Применить фильтр
     * 6) Сравнить количество отображаемых по фильтру документов в интерфейсе с количеством имеющихся в БД
     * 7) Указать в фильтре "Фамилия" значение для которого нет документов
     * 8) Применить фильтр
     * 9) Проверить отсутствие отображаемых документов в интерфейсе
     * 10) Сбросить фильтр
     * 11) Проверить что отображаются все имеющиеся документы
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testLastNameFilterApply() throws InterruptedException, ParseException {
        app.db().dominantData();
        Integer unsortedCount = app.db().getAllInnFlRequests().size();
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Фамилия", null, RDBHelper.DOMINATOR.get("LASTNAME"));
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(Integer.parseInt(RDBHelper.DOMINATOR.get("COUNT"))));
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Фамилия", null, "Фролов");
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(0));
        app.innFlRequest().clearFilters();
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(unsortedCount));
    }


    @Test(priority = 5, enabled = true)
    /**
     * Тест-кейс: Применение фильтра «Номер ДУЛ»
     * Шаги:
     * 1) Подготовить тестовую среду для выполнения текущего теста
     * 2) Получить из БД информацию о количестве документов с разными номерами ДУЛ
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Указать в фильтре "Номер ДУЛ" значение для которого имеются документы
     * 5) Применить фильтр
     * 6) Сравнить количество отображаемых по фильтру документов в интерфейсе с количеством имеющихся в БД
     * 7) Указать в фильтре "Номер ДУЛ" значение для которого нет документов
     * 8) Применить фильтр
     * 9) Проверить отсутствие отображаемых документов в интерфейсе
     * 10) Сбросить фильтр
     * 11) Проверить что отображаются все имеющиеся документы
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testDulNumberFilterApply() throws InterruptedException, ParseException {
        app.db().dominantData();
        Integer unsortedCount = app.db().getAllInnFlRequests().size();
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Номер ДУЛ", null, RDBHelper.DOMINATOR.get("DULNUMBER"));
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(Integer.parseInt(RDBHelper.DOMINATOR.get("COUNT"))));
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("Номер ДУЛ", null, "654654");
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(0));
        app.innFlRequest().clearFilters();
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(unsortedCount));
    }

    @Test(priority = 6, enabled = true)
    /**
     * Тест-кейс: Применение фильтра «ИНН»
     * Шаги:
     * 1) Подготовить тестовую среду для выполнения текущего теста
     * 2) Получить из БД информацию о количестве документов с разными инн
     * 3) Перейти в раздел "ФНС - Запрос проверки ИНН ФЛ"
     * 4) Указать в фильтре "ИНН" значение для которого имеются документы
     * 5) Применить фильтр
     * 6) Сравнить количество отображаемых по фильтру документов в интерфейсе с количеством имеющихся в БД
     * 7) Указать в фильтре "ИНН" значение для которого нет документов
     * 8) Применить фильтр
     * 9) Проверить отсутствие отображаемых документов в интерфейсе
     * 10) Сбросить фильтр
     * 11) Проверить что отображаются все имеющиеся документы
     * ОР:
     * Все шаги выполняются без ошибок
     * Сравнения и проверки дают положительный результат
     */
    public void testINNFilterApply() throws InterruptedException, ParseException {
        app.db().dominantData();
        Integer unsortedCount = app.db().getAllInnFlRequests().size();
        app.goTo().menuModul("ФНС");
        app.goTo().menuSection("Запрос проверки ИНН ФЛ");
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("ИНН", null, RDBHelper.DOMINATOR.get("PERSONINN"));
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(Integer.parseInt(RDBHelper.DOMINATOR.get("COUNT"))));
        app.innFlRequest().clearFilters();
        app.innFlRequest().selectFilter("ИНН", null, "8885554441");
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(0));
        app.innFlRequest().clearFilters();
        assertThat("Количество записей в списке не совпадает с количеством в базе!",app.innFlRequest().countInVisibleScroll(), equalTo(unsortedCount));
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
        app.testLink().putTestResults(runStatus, exeption, 5032, 29);
    }
}
