package ru.idsys.idbank.fns.innflchk.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Вспомогательный класс управления навигацией в приложении - расширяет класс HelperBase
 * @author a.mylnikov
 */

public class NavigationHelper extends HelperBase {
    /**
     * Конструктор - инициализирует драйвер для работы с браузером
     * @param wd Тип необходимого драйвера
     */
    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    /**
     * Метод перехода в указанный раздел меню
     * @param name Параметр в котором передается название раздела
     */
    public void menuSection(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        click(By.xpath(String.format("//div[@role='tree']//span[text()='%s']",name)));
    }

    /**
     * Метод разворачивания меню модуля
     * @param name Параметр в котором передается наименование меню
     */
    public void menuModul(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        if(wd.findElement(By.xpath("//div[@class='v-splitpanel-first-container v-splitpanel-first-container-sc-split-panel v-scrollable']")).getSize().getWidth() < 1){
        doubleClick(By.xpath("//div[@class='v-splitpanel-first-container v-splitpanel-first-container-sc-split-panel v-scrollable']"));
         }

         if(!wd.findElement(By.xpath("//div[@class='v-tree v-widget v-has-width']")).isDisplayed()) {
             click(By.xpath(String.format("//div[@class='subtitle v-widget h4 subtitle-h4 v-label-undef-w'][text()='%s']", name)));
         }
    }

}
