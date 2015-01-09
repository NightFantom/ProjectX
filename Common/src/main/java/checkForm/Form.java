/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: Интерфейс для формы.
 */
package checkForm;

import checkForm.fields.Field;
import checkForm.validators.FormValidator;
import checkForm.validators.Validator;

import java.util.List;

public interface Form {
    /**
     * Получение списка всех полей формы
     * @return Список полей формы
     */
    public List<Field> getFields();

    /**
     * Добавление поля на форму.
     * @param field Поле
     */
    public void addField(Field field);

    /**
     * Добавление валидаторов на форму
     * @param validators Валидаторы
     */
    public void addValidators(FormValidator... validators);

    /**
     * Получение валидаторов формы
     * @return Список валидаторов
     */
    public List<FormValidator> getValidators();
}
