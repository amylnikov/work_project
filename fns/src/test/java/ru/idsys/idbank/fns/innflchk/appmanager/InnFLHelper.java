package ru.idsys.idbank.fns.innflchk.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.idsys.idbank.fns.innflchk.model.InnFLRqData;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Класс помощник управления объектами модуля.
 * Содержит вспомогательные методы по заполнению форм, извлечению информации,
 * обновлению информации и прочие функции для обеспечения выполнения тестов применимых конкретно для данного модуля.
 *
 * @author a.mylnikov
 */

public class InnFLHelper extends HelperBase {

    /**
     * Конструктор класса
     *
     * @param wd Параметр для передачи используемого веб-драйвера
     */
    public InnFLHelper(WebDriver wd) {
        super(wd);
    }

    /**
     * Метод заполнения полей формы документа Запрос проверки ИНН ФЛ данными
     *
     * @param innFlData Параметр в котором передаются тестовые данные запроса
     */
    public void formFilling(InnFLRqData innFlData) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        typeTextInSelectField("ИНН", innFlData.getPersonInn());
        typeTextInSelectField("Фамилия", innFlData.getLastName());
        typeTextInSelectField("Имя", innFlData.getFirstName());
        typeTextInSelectField("Отчество", innFlData.getSecondName());
        typeTextInSelectField("Тип ДУЛ", innFlData.getDulDocId());
        typeTextInSelectField("Серия ДУЛ", innFlData.getDulSerial());
        typeTextInSelectField("Номер ДУЛ", innFlData.getDulNumber());
        typeTextInSelectField("Наименование орг., выдавшей ДУЛ", innFlData.getDulEmitentName());
        typeTextInSelectField("Код подразделения орг. выдавшей ДУЛ", innFlData.getDulDeptCode());
        typeTextInSelectField("Дата выдачи ДУЛ", innFlData.getDulDate());
    }

    /**
     * Метод для получения текста из всплывающего окна с предупреждением
     *
     * @return Возвращает текст который указывается в предупреждающем сообщении
     * @throws IOException
     * @throws UnsupportedFlavorException
     */
    public String getPopupContent() throws IOException, UnsupportedFlavorException, InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        click(By.xpath("//textarea[@class='v-textarea v-widget v-readonly v-has-width v-has-height v-textarea-readonly']"));
        return clearPopupContent(getTextToClipboardFromField(By.xpath("//textarea[@class='v-textarea v-widget v-readonly v-has-width v-has-height v-textarea-readonly v-textarea-focus']")));
    }

    /**
     * Метод получения сведний о документе из полей открытой формы в интерфейсе
     *
     * @return Возвращает вфнные документа
     * @throws IOException
     * @throws UnsupportedFlavorException
     * @throws InterruptedException
     */
    public InnFLRqData getDocumentData() throws IOException, UnsupportedFlavorException, InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        InnFLRqData documentData = new InnFLRqData();
        List<WebElement> inputFields = wd.findElements(By.xpath("//input"));
        String dulDeptCode = null;
        String dulEmitentName = null;
        String dulNumber = null;
        String dulSerial = null;
        String secondName = null;
        String firstName = null;
        String lastName = null;
        String personInn = null;
        String docName = null;
        String dulDate = null;
        for (WebElement field : inputFields) {
            String fieldName = field.getAttribute("id");
            switch (clearFromNumbers(fieldName)) {
                case "FNS_INN_PERSON_TEST_QUERY.DUL_DEPT_CODE":
                    dulDeptCode = getTextToClipboardFromField(By.xpath(String.format("//input[@id='%s']", fieldName)));
                    break;
                case "FNS_INN_PERSON_TEST_QUERY.DUL_EMITENT_NAME":
                    dulEmitentName = getTextToClipboardFromField(By.xpath(String.format("//input[@id='%s']", fieldName)));
                    break;
                case "FNS_INN_PERSON_TEST_QUERY.DUL_NUMBER":
                    dulNumber = getTextToClipboardFromField(By.xpath(String.format("//input[@id='%s']", fieldName)));
                    break;
                case "FNS_INN_PERSON_TEST_QUERY.DUL_SERIAL":
                    dulSerial = getTextToClipboardFromField(By.xpath(String.format("//input[@id='%s']", fieldName)));
                    break;
                case "PERSON_QUERY.SECOND_NAME":
                    secondName = getTextToClipboardFromField(By.xpath(String.format("//input[@id='%s']", fieldName)));
                    break;
                case "PERSON_QUERY.FIRST_NAME":
                    firstName = getTextToClipboardFromField(By.xpath(String.format("//input[@id='%s']", fieldName)));
                    break;
                case "PERSON_QUERY.LAST_NAME":
                    lastName = getTextToClipboardFromField(By.xpath(String.format("//input[@id='%s']", fieldName)));
                    break;
                case "FNS_INN_PERSON_TEST_QUERY.PERSON_INN":
                    personInn = getTextToClipboardFromField(By.xpath(String.format("//input[@id='%s']", fieldName)));
                    break;
            }
        }

        List<WebElement> comboboxes = wd.findElements(By.xpath("//div[@role='combobox']"));
        for (WebElement combobox : comboboxes) {
            String comboboxName = combobox.getAttribute("id");
            if (clearFromNumbers(comboboxName).equals("FNS_INN_PERSON_TEST_QUERY.DOC_NAME")) {
                docName = getTextToClipboardFromField(By.xpath(String.format("//div[@id='%s']/input", comboboxName)));
            }
        }

        List<WebElement> dates = wd.findElements(By.xpath("//div[@class='v-datefield v-datefield-popupcalendar v-widget v-datefield-day']"));
        for (WebElement date : dates) {
            String dateName = date.getAttribute("id");
            if (clearFromNumbers(dateName).equals("FNS_INN_PERSON_TEST_QUERY.DUL_DATE")) {
                dulDate = getTextToClipboardFromField(By.xpath(String.format("//div[@id='%s']/input", dateName)));
            }
        }

        return documentData.withPersonInn(personInn)
                .withLastName(lastName)
                .withFirstName(firstName)
                .withSecondName(secondName)
                .withDulSerial(dulSerial)
                .withDulNumber(dulNumber)
                .withDulEmitentName(dulEmitentName)
                .withDulDeptCode(dulDeptCode)
                .withDocName(docName)
                .withDulDate(dulDate)
                .withDulDocId(docCodeExtractor(docName));
    }

    /**
     * Метод выделения первой строки в списке
     *
     * @throws InterruptedException
     */
    public void highlightFirstRow() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        click(By.xpath("//table[@class='v-table-table']/tbody/tr[1]"));
    }

    /**
     * Метод выделения строки по идентификатору документа
     *
     * @param id Параметр для передачи идентификатора
     * @throws InterruptedException
     */
    public void highlightRowById(Long id) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        click(By.xpath(String.format("//table[@class='v-table-table']/tbody/tr/td/div[text()='%s']", id)));
    }

    /**
     * Метод выделения всех доступных строк в списке
     *
     * @throws InterruptedException
     */
    public void highlightAllRows() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickSHIFTtoEND(By.xpath("//table[@class='v-table-table']/tbody/tr[1]"));
    }

    /**
     * Метод перобразования краткого наименования ДУЛ в его код по справочнику
     *
     * @param docName Параметр для передачи строки с наименованием ДУЛ
     * @return Возвращается строка с кодом ДУЛ
     */
    public String docCodeExtractor(String docName) {
        String docCode = null;
        switch (docName) {
            case "ПаСССР":
                docCode = "01";
                break;
            case "ПасЗгр":
                docCode = "02";
                break;
            case "СвдРжд":
                docCode = "03";
                break;
            case "УдЛичн":
                docCode = "04";
                break;
            case "Справ":
                docCode = "05";
                break;
            case "ПасММФ":
                docCode = "06";
                break;
            case "ВоеБил":
                docCode = "07";
                break;
            case "ВрУдВБ":
                docCode = "08";
                break;
            case "ПасДип":
                docCode = "09";
                break;
            case "ПасИнс":
                docCode = "10";
                break;
            case "СвиРег":
                docCode = "11";
                break;
            case "ВидЖит":
                docCode = "12";
                break;
            case "УдсБеж":
                docCode = "13";
                break;
            case "ВрУдсЛ":
                docCode = "14";
                break;
            case "РазрВр":
                docCode = "15";
                break;
            case "СвВрУб":
                docCode = "18";
                break;
            case "ВидЖитИнГр":
                docCode = "19";
                break;
            case "ВидЖитЛБГр":
                docCode = "20";
                break;
            case "ПасРФ":
                docCode = "21";
                break;
            case "ПасЗаг":
                docCode = "22";
                break;
            case "СвРжИн":
                docCode = "23";
                break;
            case "УдВоен":
                docCode = "24";
                break;
            case "ПасМор":
                docCode = "26";
                break;
            case "ВоеЗап":
                docCode = "27";
                break;
            case "К61-69":
                docCode = "60";
                break;
            case "СвдРег":
                docCode = "61";
                break;
            case "ДипПспИнГр":
                docCode = "62";
                break;
            case "СлПспИнГр":
                docCode = "63";
                break;
            case "НацЗагрПас":
                docCode = "64";
                break;
            case "ПспНеГр":
                docCode = "73";
                break;
            case "УдЛицБГр":
                docCode = "76";
                break;
            case "СвдСм":
                docCode = "81";
                break;
            case "ИныеДк":
                docCode = "91";
                break;
        }
        return docCode;
    }


    /**
     * Метод установки фильтров на панели фильтрации
     *
     * @param filter1 Параметр в котором передается название основного фильтра который будет использоваться
     * @param filter2 Параметр в котором передается название вспомогательного фильтра который будет использоваться в частности для дат которые должны отбираться в диапазоне "С" и "ПО"
     * @param text    Параметр в котором передается текст для фильтра
     * @throws InterruptedException
     */
    public void selectFilter(String filter1, String filter2, String text) throws InterruptedException, ParseException {
        filterHandler(filter1, text);
        if (filter2 != null) {
            String increaseDate = dateManipulation(text, "dd.MM.yyyy HH:mm:ss", Calendar.MINUTE, OPERATION.Plus, 1);
            filterHandler(filter2, increaseDate);
        }
        TimeUnit.SECONDS.sleep(1);
        Actions action = new Actions(wd).keyDown(Keys.SHIFT).sendKeys(Keys.ENTER).keyUp(Keys.SHIFT);
        action.build().perform();
    }


}
