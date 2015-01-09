/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package helpers;

import entities.City;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class CityHelper {
    private static List<City> listCity;

    /**
     * Получение списка всех городов
     * @return Список городов
     */
    public synchronized static List<City> getListCities() {
        if (listCity == null) {
            listCity = new HibernateService<City>(City.class).execute(new GenerallyHibernateQuery() {
                @Override
                public List<City> run(Session session) throws HibernateException {
                    return session.createCriteria(City.class).list();
                }
            });
        }
        return listCity;
    }

    /**
     * Получение города по id
     * @param id  Id города
     * @return Сущность Город
     */
    public static City getCityById(Integer id){
        List<City> cities = getListCities();
        for(City city: cities){
            if (city.getId().equals(id)){
                return city;
            }
        }
        return null;
    }

}
