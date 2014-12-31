/**
 * Создано: Денис 
 * Дата: 31.12.14
 * Описание: Класс-обработчик всех ошибок, произошедщих в Action'е
 */
package action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ExceptionHandler;
import org.apache.struts.config.ExceptionConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AllExceptionHandler extends ExceptionHandler {

    @Override
    public ActionForward execute(Exception ex, ExceptionConfig ae, ActionMapping mapping, ActionForm formInstance, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ActionForward forward = super.execute(ex, ae, mapping, formInstance, request, response);
        ex.printStackTrace();
        forward.setRedirect(true);
        return forward;
    }
}
