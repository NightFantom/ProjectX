/**
 * Created by Виктор on 03.11.2014.
 */

package action;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import form.FileUploadForm;
import form.Record;
import form.FormHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import queueService.QueueManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUploadAction extends DispatchAction {

    @Override
    protected String getMethodName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response, String parameter) throws Exception {
        return parameter;
    }


    public ActionForward parseRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        FileUploadForm fileUploadForm = (FileUploadForm) form;
        FormHandler client = new FormHandler();   //???????????????
        if (!client.isExist(fileUploadForm.getLogin(), fileUploadForm.getPassword())) {
            return mapping.findForward("userIsNotExist");
        }
        Record record = new Record();
        record.setLogin(fileUploadForm.getLogin());
        if (ServletFileUpload.isMultipartContent(request)) {                    // если нам пришел реквест с файлом
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                List items = upload.parseRequest(request);                      //получение листа из элементов формы
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();                 //получение элемента формы (поля или файла)
                    if (!item.isFormField()) {                                  //если элемент не является полем формы, т.е. является файлом
                        String fileName = item.getName();                       //получаем имя файла
                        String root = getServlet().getServletContext().getRealPath("/");    //получаем путь сервлета
                        File path = new File(root + "/" + client.getOrganization());                //создаем там папку в которую будем загружать
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }
                        File uploadedFile = new File(path + "/" + fileName);
                        item.write(uploadedFile);                               //записываем файл
                        record.setPathToFile(uploadedFile.getAbsolutePath());
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
        if (record.getPathToFile() != null) {
            QueueManager.getQueue().add(record);
        }
        return mapping.findForward("success");
    }
}
