package handler;
/**
 * Created by Виктор on 09.11.2014.
 */

import form.LodedData;
import form.Mapper;
import form.UpdateRecord;
import forms.Medicament;
import forms.Price;
import hibernateService.HibernateService;

import java.util.*;

/**
 * Обновление данных о стоимости и количестве лекартсва
 */
public class UpdateData {
    private UpdateRecord updateRecord;
    private Iterator iter ;
    private List<Medicament> medicaments;
    private Medicament medicament;
    private Price price ;

    /**
     * Обновить данные
     * @param list лист распарсенных данных
     * @param lodedData
     */
    public void updateData(List<UpdateRecord> list, LodedData lodedData) {
        //TODO: Переделать на for each
        iter = list.iterator();
        price = new Price();
        while (iter.hasNext()) {
            updateRecord = (UpdateRecord) iter.next();
            //TODO: Удалить класс Mapper
            medicaments = new HibernateService<Medicament>(Medicament.class).getList(new Mapper().getMap("name", updateRecord.getName()), "getByName");
            if (medicaments.isEmpty()) {
                //TODO: Удалить метод createMedicament. Незачем сначала создавать, затем сохранять и доставать из базы. Достаточно передать в saveOrUpdate экземпляр класса. После выполнения метода, экземпляру присвоется id
                new HibernateService<Medicament>(Medicament.class).saveOrUpdate(createMedicament());
                medicaments = new HibernateService<Medicament>(Medicament.class).getList(new Mapper().getMap("name", updateRecord.getName()), "getByName");
            }
            medicament = medicaments.get(0);
            //TODO: Прости, отойду от правил. БЛЯ! Это вообще лишено смысла! Id в таблице Price несоответствует id лекарства!!!!!!!!!!!!!!!!!!!!!!
            price = new HibernateService<Price>(Price.class).getById(medicament.getId());
            if(price == null){
                price = createPrice(lodedData);
            }else {
                price.setCount(Integer.parseInt(updateRecord.getCount()));
                price.setCost(Double.parseDouble(updateRecord.getCost()));
                price.setDateUpdate(new Date());
            }
            new HibernateService<Price>(Price.class).saveOrUpdate(price);

        }

    }

    private Medicament createMedicament(){
        medicament = new Medicament();
        medicament.setName(updateRecord.getName());
        return medicament;
    }

    private Price createPrice(LodedData lodedData){
        price = new Price();
        price.setIdMedicament(medicament.getId());
        price.setIdCity(lodedData.pharmacy.getIdCity());
        price.setIdPharmacy(lodedData.pharmacy.getId());
        price.setCount(Integer.parseInt(updateRecord.getCount()));
        price.setCost(Double.parseDouble(updateRecord.getCost()));
        price.setDateUpdate(new Date());
        return price;
    }
}

