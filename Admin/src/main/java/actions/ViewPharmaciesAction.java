/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package actions;

import action.LogDispatchAction;
import checkForm.FormHandler;
import entities.Pharmacy;
import forms.ActionFormBase;
import forms.ViewPharmacyForm;
import hibernateService.HibernateService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import workUnits.EditPharmacyWU;
import workUnits.ViewPharmacyWU;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class ViewPharmaciesAction extends LogDispatchAction {

    /**
     * Получение списка всех аптек
     */
    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionFormBase frm = (ActionFormBase) form;
        ViewPharmacyWU workUnit = new ViewPharmacyWU();
        workUnit.init();
        frm.setData(workUnit.getResult());
        return mapping.findForward(SUCCESS);
    }

    /**
     * Просмотр детальной информации по аптеке
     */
    public ActionForward viewPharmacy(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ViewPharmacyForm frm = (ViewPharmacyForm)form;
        int id = getID(frm);
        if (id > 0){
            Pharmacy pharmacy = new HibernateService<Pharmacy>(Pharmacy.class).getById(id);
            if (pharmacy != null){
                frm.setPharmacy(pharmacy);
                return mapping.findForward(SUCCESS);
            }
        }
        throw new IllegalArgumentException("Неверно задан id");

    }

    /**
     * Обновление/сохранение сущности аптека.
     */
    public ActionForward savePharmacy(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ViewPharmacyForm frm = (ViewPharmacyForm)form;
        FormHandler formHandler = new FormHandler(frm.getFields(), frm.FORM);
        if (formHandler.handler()){
            EditPharmacyWU workUnit = new EditPharmacyWU();

            Map<String, Object> mapValue = formHandler.getResult();

        }

        return mapping.findForward(SUCCESS);
    }

    private int getID(ActionFormBase frm){
        if (frm.getId() != null && frm.getId() > 0){
            return frm.getId();
        }
        return -1;
    }
}
