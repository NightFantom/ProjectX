/**
 * Created: Денис 
 * Date: 16.11.14.
 */
package listers;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class initSession implements HttpSessionListener {
    private static final String ID_CITY = "idCity";
    private static final Integer DEFAULT_ID = new Integer(1);

    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        httpSessionEvent.getSession().setAttribute(ID_CITY, DEFAULT_ID);
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }
}
