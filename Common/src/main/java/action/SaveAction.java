/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Базовый класс для сохранения/обновления сущностей
 */
package action;

import checkForm.Form;
import checkForm.FormHandler;
import forms.ActionFormBase;
import helpers.GlobalConstants;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import workUnit.EditWorkUnit;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class SaveAction extends LogDispatchAction {

    /**
     * Сохранить/обновить сущность
     */
    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionFormBase frm = (ActionFormBase)form;
        FormHandler formHandler = new FormHandler(frm.getFields(), getLogicForm(frm));
        if (!formHandler.handler()){
            request.setAttribute(GlobalConstants.ERROR_MESSAGE, formHandler.getErrorMessage());
            return mapping.findForward(ERROR);
        }
        EditWorkUnit workUnit = createWorkUnit(frm);
        workUnit.init(frm.getId());
        workUnit.updateEntity(formHandler.getResult());
        workUnit.addition(frm);
        workUnit.save();
        return mapping.findForward(SUCCESS);
    }

    protected abstract Form getLogicForm(ActionFormBase form);
    protected abstract EditWorkUnit createWorkUnit(ActionFormBase frm);
}
