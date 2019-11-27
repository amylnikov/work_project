package ru.idsys.idbank.gisgmp.WS.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.List;

/**
 * Базовый класс уровня приложения
 * Содержит часто используемые методы для вызова из вспомогатльных классов
 * @author a.mylnikov
 */

public class HelperBase {
    protected WebDriver wd;

    /**
     * Конструктор класса
     * @param wd
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

    protected void rmbClick(By locator) {
        Actions action = new Actions(wd).contextClick(wd.findElement(locator));
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
     * Метод ввода заданного текста в выбранное поле по указателю на web-элемент
     * @param locator Параметр в который должен передаваться указатель на web-элемент
     * @param text Параметр в который должен передаваться текст для ввода в поле
     */
    protected void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    /**
     * Метод ввода заданного текста в выбранное поле по названию поля
     * @param fieldName Параметр в который должно передаваться название поля
     * @param text Параметр в который должен передаваться текст для ввода в поле
     */
    protected void typeTextInSelectField(String fieldName, String text) {
        click(By.xpath(String.format("//div[text()='%s']/../../..//input", fieldName)));
        clearInputField(By.xpath(String.format("//div[text()='%s']/../../..//input", fieldName)));
        wd.findElement(By.xpath(String.format("//div[text()='%s']/../../..//input", fieldName))).sendKeys(text);
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
     * @param locator Параметр в который передается локатор нажимаемого объекта
     */
    protected void clickObjectFromPanel(String button, By locator) {
        List<WebElement> elements = wd.findElements(locator);
        for (WebElement element : elements) {
            String buttonName = element.getAttribute("id");
            if (clearFromNumbers(buttonName).equals(button)) {
                click(By.xpath(String.format("//div[@id='%s']", buttonName)));
                break;
            }
        }
    }

    /**
     * Метод завершения работы с документом,
     * который сохраняет внесенные в документ изменения
     * и закрывает документ
     */
    protected void saveAndCloseForm() {
        click(By.xpath("//span[text()='Сохранить']"));
        click(By.xpath("//span[text()='Закрыть']"));
    }

    public int countInVisibleScroll() {
        List<WebElement> rows = wd.findElements(By.xpath("//tr[@style]"));
        return rows.size();
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
