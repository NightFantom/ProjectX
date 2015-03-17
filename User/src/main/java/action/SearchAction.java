/**
 * Создано: Денис
 * Дата: 09.11.14.
 * Описание: Класс для поиска лекарств в аптеках
 */
package action;

import entities.City;
import forms.ActionFormBase;
import entities.Medicament;
import entities.Price;
import helpers.GlobalConstants;
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

    /**
     * Метод диспетчер.
     * Если к нам с формы пришла ID, то ищем лекарство в атеках.
     * В противном случае
     */
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response){

        ActionFormBase frm = (ActionFormBase)form;

        if (frm.getId() != null && frm.getId() > 0){
            getMedicamentById(frm, request);
            return mapping.findForward("start");
        }
        getListMedicamentSimilarByName(frm);
        return mapping.findForward("listMedicament");
    }

    private void getMedicamentById(ActionFormBase frm, HttpServletRequest request){
        Integer id =  frm.getId();
        Map<Object, Object> map = new HashMap<>();
        map.put("idMedicament", id);
        Integer cityId = SessionAndRequestHelper.getCityId(request);
        cityId = cityId == null ? 1 : cityId;
        map.put(GlobalConstants.ID_USER_CITY, cityId);
        List<Price> list = new HibernateService<Price>(Price.class).getList(map,"getPrice");
        Medicament medicament = new HibernateService<Medicament>(Medicament.class).getById(id);
        frm.setField("searchInput", medicament.getName());
        frm.setId(null);
        frm.setData(list);
    }

    private void getListMedicamentSimilarByName(ActionFormBase form){
        Map<Object, Object> map = new HashMap<>();
        String name =(String) form.getFields().get("searchInput");
        map.put("name",name+"%");
        List<Medicament> list = new HibernateService<Medicament>(Medicament.class).getList(map, "getByNameLike");
        form.setData(list);
    }


}
