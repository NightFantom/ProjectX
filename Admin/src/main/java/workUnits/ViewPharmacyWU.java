/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package workUnits;

import entities.Pharmacy;
import hibernateService.GenerallyHibernateQuery;
import hibernateService.HibernateService;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class ViewPharmacyWU {

    private List<Pharmacy> list;

    public void init(){
        new HibernateService<Pharmacy>(Pharmacy.class).execute(new GenerallyHibernateQuery() {
            @Override
            public void run(Session session) throws HibernateException {
                list = session.createCriteria(Pharmacy.class).list();
            }
        });
    }

    public List<Pharmacy> getResult(){
        return list;
    }
}
