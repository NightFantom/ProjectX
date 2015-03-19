/**
 * Создано: Денис 
 * Дата: 18.03.15
 * Описание: Модуль для получения списка лекарств
 */
package workUnit;

import entities.Medicament;
import hibernateService.HibernateService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMedicamentsWU implements ListWorkUnit<Medicament> {

    private static HibernateService<Medicament> service = new HibernateService<>(Medicament.class);
    private List<Medicament> list;
    private Map<Object, Object> map = new HashMap<>();

    public void setFilter(Map<Object, Object> filterParam) {
        String name =(String) filterParam.get("searchInput");
        map.put("name",name+"%");
    }

    public void filter() {
        list = service.getList(map, "getByNameLike");
    }

    public List<Medicament> getResult() {
        return list;
    }
}
