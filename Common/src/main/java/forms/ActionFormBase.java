/**
 * Created: Денис
 * Date: 03.11.14.
 */
package forms;

import org.apache.struts.action.ActionForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionFormBase extends ActionForm {
    private Integer id;
    private List<Object> data;
    private Map<Object, Object> fields = new HashMap<Object, Object>();

    public List<Object> getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Map<Object, Object> getFields() {
        return fields;
    }

    public void setFields(Map<Object, Object> map){
        fields = map;
    }

    public String getLength(){
        if (data != null){
            return new Integer(data.size()).toString();
        }
        return "0";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
