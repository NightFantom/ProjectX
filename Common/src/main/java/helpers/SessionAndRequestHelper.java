/**
 * Создано: Денис
 * Дата: 16.11.14.
 * Описание: Класс-помошник для работы с request'ом и session'ей
 */
package helpers;

import entities.City;
import entities.UserAccount;
import org.apache.struts.action.ActionForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

/**
 * Класс - помошник для работы с сессией и реквестом
 */
public class SessionAndRequestHelper {
    /**
     * Возвращает город, в котором находится пользователь
     *
     * @param request запрос
     * @return Город, в котором находится пользователь
     */
    public static City getCity(HttpServletRequest request) {
        return (City) request.getSession().getAttribute(GlobalConstants.ID_USER_CITY);
    }

    /**
     * Возвращает id города, в котором находится пользователь
     *
     * @param request запрос
     * @return Id города, в котором находится пользователь
     */
    public static Integer getCityId(HttpServletRequest request) {
        return ((City) request.getSession().getAttribute(GlobalConstants.ID_USER_CITY)).getId();
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
     * Получение текущей ActionForm для запроса.
     * @param pageContext Запрос
     * @return Текущая форма
     */
    public static ActionForm getCurrentForm(PageContext pageContext) {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Object obj = request.getAttribute(GlobalConstants.CURRENT_ACTION_FORM);
        return (ActionForm) obj;
    }

    /**
     * Получение имени пользователя
     * @return Имя пользователя
     */
    public static String getPersonName(PageContext pageContext){
        HttpSession session = ((HttpServletRequest) pageContext.getRequest()).getSession();
        UserAccount user = (UserAccount) session.getAttribute(GlobalConstants.CLIENT);
        return user.getFirstName() + " " + user.getFatherName();
    }

    /**
     * Получение учётной записи пользователя
     * @param request Запрос пользователя
     * @return Аккаут пользователя
     */
    public static UserAccount getUserAccount(HttpServletRequest request){
       return getUserAccount(request.getSession());
    }

    /**
     * Получение учётной записи пользователя
     * @param session Сессия пользователя
     * @return Аккаут пользователя
     */
    public static UserAccount getUserAccount(HttpSession session){
        return (UserAccount) session.getAttribute(GlobalConstants.CLIENT);
    }

    /**
     * Получение сообщения об ошибке, произощедщем в Action.
     * @return Сообщение об ошибке
     */
    public static String getErrorMessage(PageContext pageContext){
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        return (String) request.getAttribute(GlobalConstants.ERROR_MESSAGE);
    }
}
