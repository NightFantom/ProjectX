/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package checkForm.fields;

import checkForm.parsers.FieldParser;
import checkForm.validators.Validator;

import java.util.List;

public interface Field {

    public void setValidator(Validator validator);
    public void setValidators(Validator... validators);
    public List<Validator> getValidators();

    public void setParser(FieldParser parser);
    public FieldParser getParser();

    public void setName(String name);
    public String getName();

    public void setDescription(String description);
    public String getDescription();

}
