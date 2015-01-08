/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package checkForm;

import checkForm.fields.Field;

import java.util.List;

public interface Form {
    public List<Field> getFields();
    public void setField(Field field);
}
