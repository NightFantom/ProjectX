/**
 * Создано: Денис 
 * Дата: 05.01.15
 * Описание: 
 */
package forms;

import checkForm.Form;
import checkForm.FormImp;
import checkForm.fields.Field;
import checkForm.fields.FieldImp;
import checkForm.parsers.CityParser;
import checkForm.parsers.EmptyParser;
import checkForm.parsers.IntegerParser;
import checkForm.validators.IntegerValidator;
import checkForm.validators.NotEmptyValidator;
import checkForm.validators.RegExpValidator;
import entities.Pharmacy;

public class ViewPharmacyForm extends ActionFormBase {
    public static final Form FORM = create();

    private Pharmacy pharmacy;

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    private static Form create() {
        Form form = new FormImp();
        Field field = new FieldImp();
        field.setName("id");
        field.setDescription("Id аптеки");
        field.setParser(new IntegerParser());
        form.setField(field);

        field = new FieldImp();
        field.setName("name");
        field.setDescription("Название аптеки");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.setField(field);

        field = new FieldImp();
        field.setName("address");
        field.setDescription("Адрес аптеки");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.setField(field);

        //TODO:Прикрутить проверку на коррекстность номера после прикручивания соответствующего скрипта
        field = new FieldImp();
        field.setName("phone");
        field.setDescription("Телефон аптеки");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new EmptyParser());
        form.setField(field);

        field = new FieldImp();
        field.setName("city");
        field.setDescription("Id города");
        field.setValidators(new NotEmptyValidator(), new IntegerValidator());
        field.setParser(new CityParser());
        form.setField(field);

        field = new FieldImp();
        field.setName("codeNetwork");
        field.setDescription("Код сети");
        field.setValidator(new NotEmptyValidator());
        field.setParser(new IntegerParser());
        form.setField(field);

        field = new FieldImp();
        field.setName("login");
        field.setDescription("Логин");
        field.setParser(new EmptyParser());
        form.setField(field);

        field = new FieldImp();
        field.setName("password1");
        field.setDescription("Пароль 1");
        field.setParser(new EmptyParser());
        form.setField(field);

        field = new FieldImp();
        field.setName("password2");
        field.setDescription("Пароль 2");
        field.setParser(new EmptyParser());
        form.setField(field);

        return form;
    }
}
