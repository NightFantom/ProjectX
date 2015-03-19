/**
 * Создано: Денис 
 * Дата: 18.03.15
 * Описание: Модуль для получения прайса
 */
package workUnit;

import entities.Medicament;
import entities.Price;
import helpers.GlobalConstants;
import hibernateService.HibernateService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PriceWU implements ListWorkUnit<Price> {

    private static HibernateService<Price> service = new HibernateService<>(Price.class);
    private static HibernateService<Medicament> medicamentService = new HibernateService<Medicament>(Medicament.class);
    private List<Price> list;
    private Map<Object, Object> map = new HashMap<>();
    private Medicament medicament;

    public void setFilter(Map<Object, Object> filterParam) {
        map.put(GlobalConstants.ID_MEDICAMENT_FOR_QUERY, filterParam.get(GlobalConstants.ID_MEDICAMENT_FOR_QUERY));
        map.put(GlobalConstants.ID_USER_CITY, filterParam.get(GlobalConstants.ID_USER_CITY));
    }

    public void filter() {
        list = service.getList(map, "getPrice");
        Integer idMedicament =(Integer) map.get(GlobalConstants.ID_MEDICAMENT_FOR_QUERY);
        medicament = medicamentService.getById(idMedicament);
    }

    public List<Price> getResult() {
        return list;
    }

    public Medicament getMedicament() {
        return medicament;
    }
}
