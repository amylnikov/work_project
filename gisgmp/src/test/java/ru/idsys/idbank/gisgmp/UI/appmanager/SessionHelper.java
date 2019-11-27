package ru.idsys.idbank.gisgmp.UI.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Вспомогательный класс управления сессиями - расширяет класс HelperBase
 * В него вынесена авторизация в тонком клиенте приложения
 * @author a.mylnikov
 */

public class SessionHelper extends HelperBase{

    /**
     * Конструктор - инициализирует драйвер для работы с браузером
     * @param wd Тип необходимого драйвера
     */
    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    /**
     * Метод авторизации в приложении
     * @param username Название УЗ пользоваетеля
     * @param password Пароль УЗ пользователя
     */
    public void login(String username, String password) {
        type(By.id("LOGIN-USERNAME"), username);
        type(By.id("LOGIN-PASSWORD"), password);
        click(By.id("BTN-OK"));
    }
}
