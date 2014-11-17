/**
 * Created: Денис 
 * Date: 16.11.14.
 */
package action;

import forms.Pharmacy;
import forms.ViewPharmacyForm;
import hibernateService.HibernateService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewPharmacyAction extends LogDispatchAction {

    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){

        ViewPharmacyForm frm = (ViewPharmacyForm)form;
        int id = getID(frm);
        if (id > 0){
            Pharmacy pharmacy = new HibernateService<Pharmacy>(Pharmacy.class).getById(id);
            frm.setPharmacy(pharmacy);
        }
        return mapping.findForward("start");
    }

    private int getID(ViewPharmacyForm frm){
        if (frm.getId() != null && frm.getId() > 0){
            return frm.getId();
        }
        return -1;
    }
}
