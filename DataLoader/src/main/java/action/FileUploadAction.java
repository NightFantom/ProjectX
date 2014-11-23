/**
 * Created by Виктор on 03.11.2014.
 */

package action;

import fileService.FileManager;
import form.LodedData;
import form.FileUploadForm;
import forms.Pharmacy;
import hibernateService.HibernateService;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import queueService.QueueManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileUploadAction extends LogDispatchAction {

    private final String SUCCESS = "success";
    private final String USER_IS_NOT_EXIST = "userIsNotExist";
    private final String IS_NOT_MULTIPART_CONTENT = "isNotMultipartContent";


    /**
     * Загрузка файла, логина, пароля
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward loadMultipartContent(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        FileUploadForm fileUploadForm = (FileUploadForm) form;
        LodedData lodedData = new LodedData();
        if (ServletFileUpload.isMultipartContent(request)) {                    // если нам пришел реквест с файлом
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("login", fileUploadForm.getLogin());
            List<Pharmacy> pharmaciesList = new HibernateService<Pharmacy>(Pharmacy.class).getList( map, "getByLogin");
            if (!pharmaciesList.isEmpty()) {
                Pharmacy pharmacy = pharmaciesList.get(0);
                if (pharmacy.getPassword().equals(fileUploadForm.getPassword())) {
                    FormFile file = (FormFile) fileUploadForm.getMultipartRequestHandler().getFileElements().get("upfile");
                    String filePath = getServlet().getServletContext().getRealPath("/") + pharmacy.getLogin();
                    lodedData.setPathToFile(new FileManager(filePath).loadFile(file).getAbsolutePath());
                    lodedData.setPharmacy(pharmacy);
                    QueueManager.getQueue().add(lodedData);
                    return mapping.findForward(SUCCESS);
                }
            }
        }
        //TODO: Нужно иначе разруливать "плохие" ситуации
        return mapping.findForward(IS_NOT_MULTIPART_CONTENT);
    }
}
