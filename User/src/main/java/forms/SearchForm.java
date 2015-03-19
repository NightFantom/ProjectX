/**
 * Создано: Денис 
 * Дата: 18.03.15
 * Описание: 
 */
package forms;

import checkForm.Form;
import checkForm.FormImp;
import checkForm.fields.Field;
import checkForm.fields.FieldImp;
import checkForm.parsers.EmptyParser;
import checkForm.validators.NotEmptyValidator;
import checkForm.validators.RegExpValidator;
import entities.Medicament;

public class SearchForm extends ActionFormBase {

    private static final Form FORM = getForm();
    private Medicament medicament;

    public Medicament getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicament medicament) {
        this.medicament = medicament;
    }

    private static Form getForm(){
        Form form = new FormImp();
        Field field = new FieldImp();
        field.setName("searchInput");
        field.setDescription("Поисковый запрос");
        field.setValidator(new NotEmptyValidator());
        field.setValidator(new RegExpValidator(".{3,}"));
        field.setParser(new EmptyParser());
        form.addField(field);
        return form;
    }

    @Override
    public Form getLogicForm() {
        return FORM;
    }
}
