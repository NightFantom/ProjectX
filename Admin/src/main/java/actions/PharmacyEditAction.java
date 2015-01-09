/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package actions;

import action.SaveAction;
import checkForm.Form;
import forms.ActionFormBase;
import forms.CreatePharmacyForm;
import forms.ViewPharmacyForm;
import workUnit.EditWorkUnit;
import workUnits.EditPharmacyWU;

public class PharmacyEditAction extends SaveAction {

    @Override
    protected Form getLogicForm(ActionFormBase form) {
        if (form instanceof ViewPharmacyForm){
            return ViewPharmacyForm.FORM;
        }
        return CreatePharmacyForm.FORM;
    }

    @Override
    protected EditWorkUnit createWorkUnit(ActionFormBase frm) {
        return new EditPharmacyWU();
    }
}
