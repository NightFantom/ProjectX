/**
 * Created by Виктор on 04.11.2014.
 */

package forms;

import org.apache.struts.action.ActionForm;


public class UserAccount extends ActionForm {
    private Integer id;
    private String firstName;
    private String secondName;
    private String fatherName;
    private String codeNetwork;
    private String phone;
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCodeNetwork() {
        return codeNetwork;
    }

    public void setCodeNetwork(String codeNetwork) {
        this.codeNetwork = codeNetwork;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
