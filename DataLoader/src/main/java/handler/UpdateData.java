package handler;
/**
 * Created by Виктор on 09.11.2014.
 */

import form.LodedData;
import form.UpdateRecord;
import forms.Medicament;
import forms.Price;
import hibernateService.HibernateService;

import java.util.*;

/**
 * Обновление данных о стоимости и количестве лекартсва
 */
public class UpdateData {


    private List<Medicament> medicaments;
    private List<Price> priceList;
    private Medicament medicament;
    private Price price;
    private Map<Object, Object> map = new HashMap<Object, Object>();

    /**
     * Обновить данные
     *
     * @param list      лист распарсенных данных
     * @param lodedData
     */
    public void updateData(List<UpdateRecord> list, LodedData lodedData) {

        for (UpdateRecord updateRecord : list) {
            map.put("name", updateRecord.getName());
            medicaments = new HibernateService<Medicament>(Medicament.class).getList(map, "getByName");
            if (medicaments.isEmpty()) {
                medicament.setName(updateRecord.getName());
                new HibernateService<Medicament>(Medicament.class).saveOrUpdate(medicament);
            } else {
                medicament = medicaments.get(0);
            }
            price = new Price();
            price.setIdMedicament(medicament.getId());
            price.setIdCity(lodedData.pharmacy.getIdCity());
            price.setIdPharmacy(lodedData.pharmacy.getId());
            price.setCount(Integer.parseInt(updateRecord.getCount()));
            price.setCost(Double.parseDouble(updateRecord.getCost()));
            price.setDateUpdate(new Date());
            price.setPharmacyName(lodedData.pharmacy.getName());
            price.setPharmacy(lodedData.getPharmacy());
            new HibernateService<Price>(Price.class).saveOrUpdate(price);

        }

    }

}

