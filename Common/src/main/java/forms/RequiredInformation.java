/**
 * Created by Виктор on 04.11.2014.
 */

package forms;

import org.apache.struts.action.ActionForm;

import java.util.Date;

public class RequiredInformation extends ActionForm {
    private String drugstoreName;
    private Integer idDrugstore;
    private Integer idMedicine;
    private Integer count;
    private Double cost;
    private Date dateUpdate;

    public String getDrugstoreName() {
        return drugstoreName;
    }

    public void setDrugstoreName(String drugstoreName) {
        this.drugstoreName = drugstoreName;
    }

    public Integer getIdDrugstore() {
        return idDrugstore;
    }

    public void setIdDrugstore(Integer idDrugstore) {
        this.idDrugstore = idDrugstore;
    }

    public Integer getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(Integer idMedicine) {
        this.idMedicine = idMedicine;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
