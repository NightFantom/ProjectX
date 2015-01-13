/**
 * Создано: Денис
 * Дата: 16.11.14.
 * Описание: Класс предназначен для инициализации города по умолчанию для нвовь зашедших пользователей
 */
package listeners;

import entities.City;
import helpers.GlobalConstants;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class InitSession implements HttpSessionListener {
    private static final City DEFAULT_CITY = new City("Вологда", 1);

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(GlobalConstants.ID_USER_CITY, DEFAULT_CITY);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
