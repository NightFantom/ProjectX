package action;

import forms.FormForSearch;
import helpers.SessionAndRequestHelper;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Виктор on 22.11.2014.
 */
public class AutoCompleteAction extends DispatchAction{
    private final String SUCCESS = "success";
    protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
        return parameter;
    }

    public ActionForward autoComplete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        FormForSearch formForSearch = (FormForSearch) form;
        formForSearch.setIdCity(SessionAndRequestHelper.getCityId(request));
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache");
        response.setStatus(HttpServletResponse.SC_OK);
        out.write("<p>"+formForSearch.getForm()+"</p>");
        out.flush();
        return mapping.findForward(SUCCESS);
    }
}
