/**
 * Created by Виктор on 04.11.2014.
 */

package forms;

import org.apache.struts.action.ActionForm;


public class Pharmacy extends ActionForm {
    private Integer id;
    private String address;
    private String name;
    private String phone;
    private Integer idCity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }
}
