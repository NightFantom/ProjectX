/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package checkForm;

import checkForm.fields.Field;

import java.util.ArrayList;
import java.util.List;

public class FormImp implements Form {
    private List<Field> fields = new ArrayList<>();

    @Override
    public List<Field> getFields() {
        return fields;
    }

    @Override
    public void setField(Field field) {
        fields.add(field);
    }
}
