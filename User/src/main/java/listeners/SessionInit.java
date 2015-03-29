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

    private static final City DEFAULT_CITY = new City("Вологда", 1);

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(GlobalConstants.ID_USER_CITY, DEFAULT_CITY);
        httpSessionEvent.getSession().setAttribute(GlobalConstants.FLAG_CITY_CHECK,false);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }

}
