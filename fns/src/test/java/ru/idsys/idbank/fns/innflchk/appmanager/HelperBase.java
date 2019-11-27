package ru.idsys.idbank.fns.innflchk.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Базовый класс уровня приложения
 * Содержит часто используемые методы для вызова из вспомогатльных классов
 * @author a.mylnikov
 */

public class HelperBase {
    protected WebDriver wd;



    enum OPERATION {Plus, Minus}

    public static Map<String,String> STATUS = new HashMap<>();
    static {
        STATUS.put("1","Новый");
        STATUS.put("98","Ошибка");
        STATUS.put("152","Получен ответ");
        STATUS.put("310","Запрос выполнен");
        STATUS.put("800","Ожидает обработки");
        STATUS.put("816","Ошибка отправки");
        STATUS.put("820","Отправлен");
    }


    private static Map<String, String> FILTERNAME = new HashMap<>();
    static {
        FILTERNAME.put("Статус","FILTER-[IN]DOCSTATUS_CAPTION");
        FILTERNAME.put("Дата и время выполнения запроса с","FILTER-[>=]ANSWER_DATE_TIME");
        FILTERNAME.put("Дата и время выполнения запроса по","FILTER-[<=]ANSWER_DATE_TIME");
        FILTERNAME.put("Дата создания с","FILTER-[>=]CREATE_DATE");
        FILTERNAME.put("Дата создания по","FILTER-[<=]CREATE_DATE");
        FILTERNAME.put("Фамилия","FILTER-[LIKE]LAST_NAME");
        FILTERNAME.put("Номер ДУЛ","FILTER-[LIKE]DUL_NUMBER");
        FILTERNAME.put("ИНН","FILTER-[LIKE]PERSON_INN");
    }

    /**
     * Конструктор класса
     * @param wd Параметр в котором передается используемый веб-драйвер
     */
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    /**
     * Метод имитирующий клик мышью на web-элементе интерфейса
     * @param locator Параметр в который должен передаваться указатель на web-элемент
     */
    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    /**
     * Метод имитирующий выбор элемента после чего нажатие Shift и выбор посленего элемента
     * @param locator Параметр в котором передается локатор первой строки в списке
     */
    protected void clickSHIFTtoEND(By locator){
        wd.findElement(locator).click();
        Actions action = new Actions(wd).keyDown(Keys.SHIFT).sendKeys(Keys.END).keyUp(Keys.SHIFT);
        action.build().perform();
        //wd.findElement(locator).sendKeys(Keys.SHIFT);
       // wd.findElement(locator).click();
    }

    /**
     * Метод имитирующий клик правой клавишеймыши на web-элементе интерфейса
     * @param locator Параметр в который должен передаваться указатель на web-элемент
     */
    protected void rmbClick(By locator) {
        Actions action = new Actions(wd).contextClick(wd.findElement(locator));
        action.build().perform();
    }

    /**
     * Метод имитирующий двойной клик мышью на web-элементе интерфейса
     * @param locator Параметр в который должен передаваться указатель на web-элемент
     */
    protected void doubleClick(By locator){
        Actions action = new Actions(wd).doubleClick(wd.findElement(locator));
        action.build().perform();
    }


    /**
     * Метод очистки поля от введенного по умолчанию значения, если не работает метод web-драйвера clean()
     * @param locator Параметр в который должен передаваться указатель на web-элемент
     */
    protected void clearInputField(By locator) {
        click(locator);
        wd.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, Keys.HOME));
        wd.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.END));
        wd.findElement(locator).sendKeys(Keys.BACK_SPACE);
    }

    /**
     * Метод имитирует нажатие сочетания кнопок "CTRL + A" и "CTRL + C" в указанном поле
     * после производится извлечение из буфера обмена сохраненных данных
     * @param locator Параметр для передачи локатора элемента из которого копируются данные
     * @return
     * @throws IOException
     * @throws UnsupportedFlavorException
     */
    protected String getTextToClipboardFromField(By locator) throws IOException, UnsupportedFlavorException, InterruptedException {
        Clipboard clipboard =  Toolkit.getDefaultToolkit().getSystemClipboard();
        wd.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        TimeUnit.SECONDS.sleep(1);
        wd.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "c"));
        DataFlavor flavor = DataFlavor.stringFlavor;
        if(clipboard.isDataFlavorAvailable(flavor)){
            return (String) clipboard.getData(flavor);
        }
        else{
            return "";
        }
    }

    /**
     * Метод ввода заданного текста в выбранное поле по указателю на web-элемент
     * @param locator Параметр в который должен передаваться указатель на web-элемент
     * @param text Параметр в который должен передаваться текст для ввода в поле
     */
    protected void type(By locator, String text) {
        click(locator);
        Actions action = new Actions(wd)
                .keyDown(Keys.CONTROL)
                .sendKeys(Keys.HOME)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.END)
                .keyUp(Keys.SHIFT)
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.ENTER);
        action.build().perform();
        action.sendKeys(text);
        action.build().perform();
    }

    /**
     * Метод ввода заданного текста в выбранное поле по названию поля
     * @param fieldName Параметр в который должно передаваться название поля
     * @param text Параметр в который должен передаваться текст для ввода в поле
     */
    protected void typeTextInSelectField(String fieldName, String text) {
        click(By.xpath(String.format("//div[text()='%s']/../../..//input", fieldName)));
        clearInputField(By.xpath(String.format("//div[text()='%s']/../../..//input", fieldName)));
        if(text != null) {
            wd.findElement(By.xpath(String.format("//div[text()='%s']/../../..//input", fieldName))).sendKeys(text);
        }
        wd.findElement(By.xpath(String.format("//div[text()='%s']/../../..//input", fieldName))).sendKeys(Keys.ENTER);
    }

    /**
     * Метод убирает из получаемой строки все цифры и возвращает очищенную строку
     * @param dirt Параметр в который должна передаваться строка с цифрами
     * @return Возврат строки из которой все цифры убраны
     */
    protected String clearFromNumbers(String dirt) {
        return dirt.replaceAll("[0-9]", "");
    }

    /**
     * Метод очистки текста
     * @param warning Параметр в котором передается строка для очистки
     * @return Возвращается очищенная строка
     */
    protected String clearPopupContent(String warning){
        return warning.replaceAll("[0-9\\\\null\\n\\.]", "");
    }
    /**
     * Метод имитирует клик на выбранной кнопке расположенной на панели кнопок фрейма с документами
     * @param button Параметр в который передается название кнопок без цифр
     *               возможные значения:
     *               BTN-FRAME-INSERT - кнопка создания нового документа
     *               BTN-FRAME-REFRESH - кнопка обновления списка
     *               BTN-FRAME-COPY - кнопка создания с копированием на основе выбранного в списке документа
     *               BTN-FRAME-EDIT - кнопка открытия выбранного в списке документа
     *               BTN-FRAME-DELETE - кнопка удаления выбранного в списке документа
     *               BTN-FRAME-TOGGLE_FILTER - кнопка сворачивания и разворачивания панели фильтрации
     *               BTN-FRAME-CLEAR_FILTER - кнопка очистки установленных фильтров
     *               BTN-FRAME-EXPORT - кнопка формирования печатной формы списка
     *               BTN-FRAME-REPORT - кнопка формирования печатной формы отчета
     */
    protected void clickObjectFromPanel(String button) {
        List<WebElement> elements = wd.findElements(By.xpath("//div[@role='button']"));
        for (WebElement element : elements) {
            String buttonName = element.getAttribute("id");
            if (clearFromNumbers(buttonName).equals(button)) {
                click(By.xpath(String.format("//div[@id='%s']", buttonName)));
                break;
            }
        }
    }

    /**
     * Метод сохранения введенных данных
     */
    public void saveData() {
        click(By.xpath("//span[text()='Сохранить']/../../../div"));

    }

    /**
     * Метод закрытия формы документа
     */
    public void  closeForm(){
        click(By.xpath("//span[text()='Закрыть']/../../../div"));
    }

    /**
     * Метод нажатия кнопок в формах
     * @param buttonName Параметр для передачи названия кнопки
     */
    public void clickFormButton(String buttonName) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        click(By.xpath(String.format("//span[text()='%s']/../../../div", buttonName)));
    }

    /**
     * Метод подсчета строк документов в скроллере
     * @return Возвращает целочисленное значение количества видимых строк
     */
    public int countInVisibleScroll() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        List<WebElement> rows = wd.findElements(By.xpath("//tr[@style]"));
        return rows.size();
    }

    /**
     * Метод удаления выбраннго документа
     * @throws InterruptedException
     */
    public void deleteDocument() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickObjectFromPanel("BTN-FRAME-DELETE");
    }


    /**
     * Метод создания нового документа в СИстеме
     */
    public void createNew() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        clickObjectFromPanel("BTN-FRAME-INSERT");
    }

    /**
     * Метод обновления списка документов
     */
    public void refreshScroll() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickObjectFromPanel("BTN-FRAME-REFRESH");
    }

    /**
     * Метод создания с копированием
     */
    public void createWithCopy() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickObjectFromPanel("BTN-FRAME-COPY");
    }

    /**
     * Метод редактирования
     * @throws InterruptedException
     */
    public void editExistDocument() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickObjectFromPanel("BTN-FRAME-EDIT");
    }

    /**
     * Метод очистки фильтров
     * @throws InterruptedException
     */
    public void clearFilters() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        clickObjectFromPanel("BTN-FRAME-CLEAR_FILTER");
    }

    /**
     * Метод проверяет наличие всплывающего окна
     * @return Возвращает true или false
     */
    public boolean checkPopupContent() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        if(wd.findElements(By.className("v-window-wrap")).size() > 0) {
            return wd.findElement(By.className("v-window-wrap")).isDisplayed();
        }
        return false;
    }

    /**
     * Метод преобразования строки с датой и временем в выборке из БД к типу Datetime по шаблону yyyy-MM-dd HH:mm:ss.SSS
     * и последующего преобразования к виду dd.MM.yyyy HH:mm:ss и приведению к типу String
     *
     * @param date Параметр в котором методу передается строка с датой которую необходимо преобразовать
     * @return Возвращается строка с датой и временем преобразованные в нужный формат
     * @throws ParseException Проброс ошибки
     */
    public String dateTimeConvertForFilter(String date) throws ParseException {
        if (date != null) {
            return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(date));
        }
        return null;
    }

    /**
     * Метод позволяющий увеличивать или уменьшать значения в разных частях даты,
     * которая передается в виде текста и соответствует шаблону
     * @param date Параметр в котором передается исходная дата
     * @param pattern Параметр в котором передается шаблон формата даты
     * @param parameter Параметр в котором передается то что будем менять из класса Calendar,
     *                  например для минут это значение Calendar.MINUTE
     * @param operation Параметр в котором задаем операцию увеличения делаем или уменьшения,
     *                  по факту не обязательно и можно задавать отрицательный count,
     *                  добавл ради примера использования перечислений
     * @param count Параметр в котором передается число на которое производим изменение
     * @return
     * @throws ParseException
     */
    public String dateManipulation(String date, String pattern, int parameter, OPERATION operation, int count) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat(pattern).parse(date));
        if(operation.equals(OPERATION.Plus)) {
            calendar.add(parameter, count);
        } else if(operation.equals(OPERATION.Minus)){
            calendar.add(parameter, -count);
        }
        return new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(calendar.getTime());
    }


    /**
     * Вспомогательны метод для примернения фильтров
     * @param name Параметр в котором передается наименование фильтра
     * @param value Параметр в котором передается значение для фильтра
     * @throws InterruptedException
     */
    protected void filterHandler(String name, String value) throws InterruptedException {
        boolean filling = false;
        List<WebElement> elements = wd.findElements(By.xpath("//input[@type='text']/../../div"));
        for (WebElement element : elements) {
            String filterName =  element.getAttribute("id");
            if (clearFromNumbers(filterName).equals(FILTERNAME.get(name))) {
                type(By.id(String.format("%s", filterName)), value);
                TimeUnit.SECONDS.sleep(1);
                Actions action = new Actions(wd).sendKeys(Keys.ENTER);
                action.build().perform();
                filling = true;
                break;
            }
        }
        if(!filling){
            List<WebElement> elementsAlt = wd.findElements(By.xpath("//input[@type='text']"));
            for (WebElement element : elementsAlt) {
                String filterName =  element.getAttribute("id");
                if (clearFromNumbers(filterName).equals(FILTERNAME.get(name))) {
                    type(By.id(String.format("%s", filterName)), value);
                    TimeUnit.SECONDS.sleep(1);
                    Actions action = new Actions(wd).sendKeys(Keys.ENTER);
                    action.build().perform();
                    break;
                }
            }
        }

    }


    public void refreshPage() throws InterruptedException {
        wd.navigate().refresh();
        TimeUnit.SECONDS.sleep(2);
    }
//=============Резервные методы, могут пригодиться========================================
    protected void attach(By locator, File file) {
        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    protected boolean select(By locator) {
        return wd.findElement(locator).isSelected();
    }

    protected void accept() {
        wd.switchTo().alert().accept();
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected List<WebElement> collectVisibleWebElementsByXpath(String s) {
        return wd.findElements(By.xpath(s));
    }

    protected List<WebElement> collectVisibleWebElementsBySelector(String s) {
        return wd.findElements(By.cssSelector(s));
    }


}
