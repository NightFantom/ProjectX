/**
 * Создано: Денис
 * Дата: 16.11.14.
 * Описание: Класс предназначен для инициализации города по умолчанию для нвовь зашедших пользователей
 */
package listeners;

import helpers.GlobalConstants;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class initSession implements HttpSessionListener {
    private static final Integer DEFAULT_ID = 1;

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(GlobalConstants.ID_USER_CITY, DEFAULT_ID);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
