/**
 * Created: Денис 
 * Date: 09.11.14.
 */
package action;

import forms.ActionFormBase;
import forms.Medicament;
import forms.Price;
import helpers.SessionAndRequestHelper;
import hibernateService.HibernateService;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchAction extends LogDispatchAction {

    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response){

        ActionFormBase frm = (ActionFormBase)form;

        int id = getMedicamentID(frm);

        if(id > 0){
            Map<Object, Object> map = new HashMap<>();
            map.put("idMedicament", id);
            map.put("idCity", SessionAndRequestHelper.getCityId(request));
            List<Price> list = new HibernateService<Price>(Price.class).getList(map,"getPrice");
            frm.setData(list);
        }
        return mapping.findForward("start");
    }

    private int getMedicamentID(ActionFormBase frm){
        if (frm.getId() != null && frm.getId() > 0){
            return frm.getId();
        }else {
            Map<Object, Object> map = new HashMap<>();
            map.put("name",frm.getFields().get("searchInput"));
            List<Medicament> list = new HibernateService<Medicament>(Medicament.class).getList(map, "getByName");
            if (!list.isEmpty()){
                return list.get(0).getId();
            }
        }
        return -1;
    }


}
