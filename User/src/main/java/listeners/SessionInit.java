/**
 * Создано: Денис 
 * Дата: 24.01.15
 * Описание: 
 */
package listeners;

import entities.City;
import helpers.GlobalConstants;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionInit implements HttpSessionListener {
    // TODO id города 3!!
    private static final City DEFAULT_CITY = new City("Вологда", 3);

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(GlobalConstants.ID_USER_CITY, DEFAULT_CITY);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }

}
