/**
 * Created: Денис 
 * Date: 16.11.14.
 */
package helpers;

import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * Класс - помошник для работы с сессией и реквестом
 */
public class SessionAndRequestHelper {

    private static final String ID_CITY = "idCity";

    /**
     * Возвращает id города, в котором находится пользователь
     *
     * @param request запрос
     * @return Id города, в котором находится пользователь
     */
    public static Integer getCityId(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(ID_CITY);
    }

    /**
     * Возвращает контекстный путь веб-приложения
     *
     * @param pageContext
     * @return Контекстный пусть
     */
    public static String getPath(PageContext pageContext) {
        return pageContext.getServletContext().getContextPath();
    }

    /**
     * Получение текущей ActionForm для запроса. В случае, если запрос минует Action, и при этом на странице требуется форма, то нужно использовать EmptyForm.
     * @param pageContext Запрос
     * @return Текущая форма
     */
    public static ActionForm getCurrentForm(PageContext pageContext) {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Object obj = request.getAttribute(GlobalConstants.CURRENT_ACTION_FORM);
        if (obj == null) {
            obj = request.getAttribute(GlobalConstants.EMPTY_FORM);
            if (obj == null) {
                obj = request.getSession().getAttribute(GlobalConstants.CURRENT_ACTION_FORM);
            }
        }
        return (ActionForm) obj;
    }
}
