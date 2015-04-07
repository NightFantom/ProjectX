/**
 * Создано: Денис
 * Дата: 09.11.14.
 * Описание: Класс для поиска лекарств в аптеках
 */
package action;

import checkForm.FormHandler;
import exceptions.ParserException;
import forms.ActionFormBase;
import forms.SearchForm;
import helpers.GlobalConstants;
import helpers.SessionAndRequestHelper;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import statistic.MedicamentStatistic;
import statistic.StatisticUtil;
import workUnit.ListMedicamentsWU;
import workUnit.ListWorkUnit;
import workUnit.PriceWU;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class SearchAction extends LogDispatchAction {

    private static final String PRICE_FORWARD = "price";
    private static final String MEDICAMENTS_FORWARD = "medicaments";


    @Override
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ActionFormBase frm = (ActionFormBase) form;
        ActionForward forward;
        Integer id = frm.getId();
        if (id == null || id == 0) {
            forward = getListMedicaments(frm, mapping, request);
        } else {
            forward = getPrice(frm, mapping, request);
        }
        return forward;
    }

    /**
     * Получения списка лекарств
     */
    private ActionForward getListMedicaments(ActionFormBase form, ActionMapping mapping, HttpServletRequest request) throws ParserException {
        FormHandler formHandler = new FormHandler(form.getFields(), form.getLogicForm());
        if (!formHandler.handler()) {
            request.setAttribute(GlobalConstants.ERROR_MESSAGE, formHandler.getErrorMessage());
            return mapping.findForward(ERROR);
        }

        ListWorkUnit workUnit = new ListMedicamentsWU();
        workUnit.setFilter(formHandler.getResult());
        workUnit.filter();
        form.setData(workUnit.getResult());

        return mapping.findForward(MEDICAMENTS_FORWARD);
    }

    /**
     * Получения прайса по городу
     */
    private ActionForward getPrice(ActionFormBase form, ActionMapping mapping, HttpServletRequest request) {

        SearchForm frm = (SearchForm) form;

        Map<Object, Object> map = new HashMap<>();
        Integer cityId = SessionAndRequestHelper.getCityId(request);
        map.put(GlobalConstants.ID_USER_CITY, cityId);
        map.put(GlobalConstants.ID_MEDICAMENT_FOR_QUERY, frm.getId());

        StatisticUtil.getStatistic(MedicamentStatistic.class).increment(frm.getId());
        PriceWU workUnit = new PriceWU();
        workUnit.setFilter(map);
        workUnit.filter();
        frm.setData(workUnit.getResult());
        frm.setMedicament(workUnit.getMedicament());
        frm.setId(null);
        return mapping.findForward(PRICE_FORWARD);
    }
}
