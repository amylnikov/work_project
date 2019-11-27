package ru.idsys.idbank.gisgmp.UI.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
     * Метод перехода в список "Экспорт начислений ГИС ГМП"
     */
    public void menuSection(String name) {
       click(By.xpath(String.format("//div[@role='tree']//span[text()='%s']",name)));
    }

}
