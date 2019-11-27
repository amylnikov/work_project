package ru.idsys.idbank.gisgmp.UI.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.idsys.idbank.gisgmp.UI.model.ChargesRqData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Класс помошник для тестов связанных с проверками Экспорта начислений ГИС ГМП через пользовательский интерфейс
 * @author a.mylnikov
 */

public class ChargesHelper extends HelperBase {

    /**
     * Конструктор класса
     * @param wd
     */
    public ChargesHelper(WebDriver wd) {
        super(wd);
    }

    /**
     * Метод создания нового документа
     */
    public void createNew() {
        clickObjectFromPanel("BTN-FRAME-INSERT", By.xpath("//div[@role='button']"));
    }

    /**
     * Метод обновления списка документов
     */
    public void refreshScroll(){
        clickObjectFromPanel("BTN-FRAME-REFRESH",By.xpath("//div[@role='button']"));
    }

    /**
     * Метод заполненния и сохранения документа "Запрос экспорта начислений из ГИС ГМП"
     * @param bookmark Параметр в который передается название вкладки которую открывают для заполнения
     *                 возможные значения:
     *                 Запрос экспорта начислений из ГИС ГМП
     *                 ЕСИА
     *                 Запрашиваемые УИН
     *                 Запрашиваемые плательщики
     *                 Запрашиваемые заявки
     *                 иначе - заполняются все вкладки
     * @param chargesRqData Параметр в который передается объект Запрос Начисления
     * @throws InterruptedException
     */
    public void fillChargesRqForm(String bookmark, ChargesRqData chargesRqData) throws InterruptedException {
        int timeout = 1;
        if(bookmark.equals("Запрос экспорта начислений из ГИС ГМП")){
            click(By.xpath(String.format("//div[text()='%s']", bookmark)));
            typeTextInSelectField("Тип запрашиваемых данных", chargesRqData.getDataRequestType());
            typeTextInSelectField("Начальные дата и время", chargesRqData.getStartDateTime());
            typeTextInSelectField("Конечные дата и время", chargesRqData.getEndDateTime());
            typeTextInSelectField("Количество объектов в порции", chargesRqData.getQtObjInPortion());
            saveAndCloseForm();
        } else if(bookmark.equals("ЕСИА")){
            click(By.xpath(String.format("//div[text()='%s']", bookmark)));
            typeTextInSelectField("Идентификатор учетной записи в ЕСИА", chargesRqData.getIdAccountEsia());
            typeTextInSelectField("Идентификатор сессии в ЕСИА", chargesRqData.getIdSessionEsia());
            typeTextInSelectField("Дата и время открытия сессии в ЕСИА", chargesRqData.getDateTimeSessionOpen());
            typeTextInSelectField("Тип пользователя", chargesRqData.getUserType());
            typeTextInSelectField("ИНН", chargesRqData.getInn());
            saveAndCloseForm();
        } else if(bookmark.equals("Запрашиваемые УИН")){
            click(By.xpath(String.format("//div[text()='%s']", bookmark)));
            TimeUnit.SECONDS.sleep(timeout);
            createNew();
            typeTextInSelectField("Идентификатор начисления", chargesRqData.getSupplierBillId());
            click(By.xpath("//span[text()='Ok']"));
            saveAndCloseForm();
        } else if(bookmark.equals("Запрашиваемые плательщики")){
            click(By.xpath(String.format("//div[text()='%s']", bookmark)));
            TimeUnit.SECONDS.sleep(timeout);
            createNew();
            typeTextInSelectField("Единый/альтернативный идентификатор плательщика", chargesRqData.getPayerIdentifier());
            click(By.xpath("//span[text()='Ok']"));
            saveAndCloseForm();
        } else if(bookmark.equals("Запрашиваемые заявки")) {
            click(By.xpath(String.format("//div[text()='%s']", bookmark)));
            TimeUnit.SECONDS.sleep(timeout);
            createNew();
            typeTextInSelectField("Идентификатор заявки", chargesRqData.getApplicationId());
            click(By.xpath("//span[text()='Ok']"));
            saveAndCloseForm();
        } else {
            if(wd.findElement(By.xpath("//button[@class='v-tabsheet-scrollerMenu']")).isDisplayed()){
                click(By.xpath("//div[text()='Запрос экспорта начислений из ГИС ГМП']"));
                typeTextInSelectField("Тип запрашиваемых данных", chargesRqData.getDataRequestType());
                typeTextInSelectField("Начальные дата и время", chargesRqData.getStartDateTime());
                typeTextInSelectField("Конечные дата и время", chargesRqData.getEndDateTime());
                typeTextInSelectField("Количество объектов в порции", chargesRqData.getQtObjInPortion());
                if (wd.findElement(By.xpath("//div[text()='ЕСИА']")).isDisplayed()) {
                    click(By.xpath("//button[@class='v-tabsheet-scrollerMenu']"));
                    click(By.xpath("//div[@class='v-context-menu-item-basic-text'][text()='ЕСИА']"));
                    typeTextInSelectField("Идентификатор учетной записи в ЕСИА", chargesRqData.getIdAccountEsia());
                    typeTextInSelectField("Идентификатор сессии в ЕСИА", chargesRqData.getIdSessionEsia());
                    typeTextInSelectField("Дата и время открытия сессии в ЕСИА", chargesRqData.getDateTimeSessionOpen());
                    typeTextInSelectField("Тип пользователя", chargesRqData.getUserType());
                    typeTextInSelectField("ИНН", chargesRqData.getInn());
                }
                TimeUnit.SECONDS.sleep(timeout);
                click(By.xpath("//button[@class='v-tabsheet-scrollerMenu']"));
                click(By.xpath("//div[@class='v-context-menu-item-basic-text'][text()='Запрашиваемые УИН']"));
                TimeUnit.SECONDS.sleep(timeout);
                createNew();
                typeTextInSelectField("Идентификатор начисления", chargesRqData.getSupplierBillId());
                click(By.xpath("//span[text()='Ok']"));
                TimeUnit.SECONDS.sleep(timeout);
                click(By.xpath("//button[@class='v-tabsheet-scrollerMenu']"));
                click(By.xpath("//div[@class='v-context-menu-item-basic-text'][text()='Запрашиваемые плательщики']"));
                TimeUnit.SECONDS.sleep(timeout);
                createNew();
                typeTextInSelectField("Единый/альтернативный идентификатор плательщика", chargesRqData.getPayerIdentifier());
                click(By.xpath("//span[text()='Ok']"));
                TimeUnit.SECONDS.sleep(timeout);
                click(By.xpath("//button[@class='v-tabsheet-scrollerMenu']"));
                click(By.xpath("//div[@class='v-context-menu-item-basic-text'][text()='Запрашиваемые заявки']"));
                TimeUnit.SECONDS.sleep(timeout);
                createNew();
                typeTextInSelectField("Идентификатор заявки", chargesRqData.getApplicationId());
                click(By.xpath("//span[text()='Ok']"));
                saveAndCloseForm();
            } else {
                click(By.xpath("//div[text()='Запрос экспорта начислений из ГИС ГМП']"));
                typeTextInSelectField("Тип запрашиваемых данных", chargesRqData.getDataRequestType());
                typeTextInSelectField("Начальные дата и время", chargesRqData.getStartDateTime());
                typeTextInSelectField("Конечные дата и время", chargesRqData.getEndDateTime());
                typeTextInSelectField("Количество объектов в порции", chargesRqData.getQtObjInPortion());
                if (wd.findElement(By.xpath("//div[text()='ЕСИА']")).isDisplayed()) {
                    click(By.xpath("//div[text()='ЕСИА']"));
                    typeTextInSelectField("Идентификатор учетной записи в ЕСИА", chargesRqData.getIdAccountEsia());
                    typeTextInSelectField("Идентификатор сессии в ЕСИА", chargesRqData.getIdSessionEsia());
                    typeTextInSelectField("Дата и время открытия сессии в ЕСИА", chargesRqData.getDateTimeSessionOpen());
                    typeTextInSelectField("Тип пользователя", chargesRqData.getUserType());
                    typeTextInSelectField("ИНН", chargesRqData.getInn());
                }
                click(By.xpath("//div[text()='Запрашиваемые УИН']"));
                TimeUnit.SECONDS.sleep(timeout);
                createNew();
                typeTextInSelectField("Идентификатор начисления", chargesRqData.getSupplierBillId());
                click(By.xpath("//span[text()='Ok']"));
                click(By.xpath("//div[text()='Запрашиваемые плательщики']"));
                TimeUnit.SECONDS.sleep(timeout);
                createNew();
                typeTextInSelectField("Единый/альтернативный идентификатор плательщика", chargesRqData.getPayerIdentifier());
                click(By.xpath("//span[text()='Ok']"));
                TimeUnit.SECONDS.sleep(timeout);
                click(By.xpath("//div[text()='Запрашиваемые заявки']"));
                TimeUnit.SECONDS.sleep(timeout);
                createNew();
                typeTextInSelectField("Идентификатор заявки", chargesRqData.getApplicationId());
                click(By.xpath("//span[text()='Ok']"));
                saveAndCloseForm();
            }
        }

    }


    public void useStatusFilter(String filter) {
        List<WebElement> elements = wd.findElements(By.xpath("//input[@type='text']/../../div"));
        for (WebElement element : elements) {
            String filterName = element.getAttribute("id");
            if (clearFromNumbers(filterName).equals("FILTER-[IN]DOCSTATUS_CAPTION")) {
                type(By.xpath(String.format("//div[@id='%s']/input", filterName)),filter);
                wd.findElement(By.xpath(String.format("//div[@id='%s']/input", filterName))).sendKeys(Keys.ENTER);
                break;
            }
        }
        click(By.xpath("//span[text()='Применить']"));
    }

    public void useContextMenu(String name) {
        click(By.xpath("//tr[1][@style]"));
        rmbClick(By.xpath("//tr[1][@style]/td[1]"));
        click(By.xpath(String.format("//div[text()='%s']",name)));

    }
}
