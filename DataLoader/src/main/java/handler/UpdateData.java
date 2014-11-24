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
public class UpdateData {

    private List<Price> priceList;
    private Price price;
    private Map<Object, Object> map = new HashMap<Object, Object>();

    /**
     * Обновить данные
     *
     * @param list      лист распарсенных данных
     * @param lodedData
     */
    public void updateData(List<UpdateRecord> list, LodedData lodedData) {

        Medicament medicament = null;
        HibernateService<Price> service = new HibernateService<Price>(Price.class);
        HibernateService<Medicament> serviceMedicament = new HibernateService<Medicament>(Medicament.class);
        for (UpdateRecord updateRecord : list) {
            map.put("name", updateRecord.getName());
            List<Medicament> medicaments = serviceMedicament.getList(map, "getByName");
            if (medicaments.isEmpty()) {
                medicament = new Medicament();
                medicament.setName(updateRecord.getName().toUpperCase());
                new HibernateService<Medicament>(Medicament.class).saveOrUpdate(medicament);
            } else {
                medicament = medicaments.get(0);
            }

            Map<Object, Object> hashMap = new HashMap<>();
            hashMap.put("cost", Double.parseDouble(updateRecord.getCost()));
            hashMap.put("amount", Integer.parseInt(updateRecord.getCount()));
            hashMap.put("pharmacy",lodedData.getPharmacy());
            hashMap.put("idMedicament",medicament.getId());
            hashMap.put("idCity",lodedData.pharmacy.getIdCity());
            hashMap.put("dateUpdate",new GregorianCalendar());

            int amountUpdateRecords =  service.update(hashMap, "updatePrice");
            if(amountUpdateRecords == 0){
                service.saveOrUpdate(getPrice(hashMap));
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
}

