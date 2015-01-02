/**
 * Created: Денис 
 * Date: 09.11.14.
 */
package action;

import helpers.GlobalConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogDispatchAction extends DispatchAction {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Запоминаем текущую форму
        log.debug("Форма занесена в request");
        request.setAttribute(GlobalConstants.CURRENT_ACTION_FORM, form);
        return super.execute(mapping, form, request, response);
    }

    @Override
    protected String getParameter(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String parameter = mapping.getParameter();
        if (parameter != null) {
            return parameter;
        }
        return "";
    }

    @Override
    protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
        String methodName = parameter;
        if (methodName != null && !methodName.equals("")){
            return methodName;
        }
        return "start";
    }
}
