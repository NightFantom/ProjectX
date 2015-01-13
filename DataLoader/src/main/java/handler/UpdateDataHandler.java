package handler;
/**
 * Created by Виктор on 09.11.2014.
 */

import form.LodedData;
import form.UpdateRecord;
import forms.Medicament;
import forms.Pharmacy;
import forms.Price;
import hibernateService.HibernateService;

import java.util.*;

/**
 * Обновление данных о стоимости и количестве лекартсва
 */
public class UpdateDataHandler {

    private HibernateService<Price> servicePrice = new HibernateService<Price>(Price.class);
    private HibernateService<Medicament> serviceMedicament = new HibernateService<Medicament>(Medicament.class);
    /**
     * Обновить данные
     *
     * @param list      лист распарсенных данных
     * @param lodedData
     */
    public void updateData(List<UpdateRecord> list, LodedData lodedData) {

        Medicament medicament = null;
        for (UpdateRecord updateRecord : list) {
            medicament = getMedicamentByName(updateRecord.getName());

            Map<Object, Object> hashMap = new HashMap<>();
            hashMap.put("cost", updateRecord.getCost());
            hashMap.put("amount", updateRecord.getAmount());
            hashMap.put("pharmacy",lodedData.getPharmacy());
            hashMap.put("idMedicament",medicament.getId());
            hashMap.put("idCity",lodedData.pharmacy.getIdCity());
            hashMap.put("dateUpdate",new GregorianCalendar());

            int amountUpdateRecords =  servicePrice.update(hashMap, "updatePrice");
            if(amountUpdateRecords == 0){
                servicePrice.saveOrUpdate(getPrice(hashMap));
            }
        }

    }

    private Price getPrice(Map<Object, Object> map){
        Price price= new Price();
        price.setAmount((Integer) map.get("amount"));
        price.setCost((Double)map.get("cost"));
        price.setPharmacy((Pharmacy)map.get("pharmacy"));
        price.setDateUpdate((GregorianCalendar)map.get("dateUpdate"));
        price.setIdCity((Integer)map.get("idCity"));
        price.setIdMedicament((Integer) map.get("idMedicament"));
        return price;
    }

    private Medicament getMedicamentByName(String name){
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("name", name);
        List<Medicament> medicaments = serviceMedicament.getList(map, "getByName");
        Medicament medicament = null;
        if (medicaments.isEmpty()) {
            medicament = new Medicament();
            medicament.setName(name.toUpperCase());
            serviceMedicament.saveOrUpdate(medicament);
        } else {
            medicament = medicaments.get(0);
        }
        return medicament;
    }
}

