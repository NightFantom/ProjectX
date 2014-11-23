/**
 * Created: Денис 
 * Date: 16.11.14.
 */
package helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * Класс - помошник для работы с сессией и реквестом
 */
public class SessionAndRequestHelper {

    private static final String ID_CITY = "idCity";

    /**
     * Возвращает id города, в котором находится пользователь
     * @param request запрос
     * @return Id города, в котором находится пользователь
     */
    public static Integer getCityId(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(ID_CITY);
    }

    /**
     * Возвращает контекстный путь веб-приложения
     * @param pageContext
     * @return Контекстный пусть
     */
    public static String getPath(PageContext pageContext){
        return pageContext.getServletContext().getContextPath();
    }

}
