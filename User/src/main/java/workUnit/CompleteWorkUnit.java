package workUnit;

import entities.Medicament;
import hibernateService.HibernateService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Создано: Денис 
 * Дата: 08.02.15
 * Описание: Модуль для получения списка для автозаполнения
 */

public class CompleteWorkUnit {
    private static HibernateService<Medicament> service = new HibernateService<Medicament>(Medicament.class);
    public List<Medicament> list;

    /**
     * Инициализация модуля
     * @param val Искомая подстрока
     */
    public void init(String val){
        Map<Object, Object> map = new HashMap<>();
        map.put("name", val+"%");
        list = service.getList(map, "getByNameLike");
    }

    /**
     * Получение списка схожих лекарств
     * @return Список лекарств
     */
    public List<Medicament> getList() {
        return list;
    }
}
