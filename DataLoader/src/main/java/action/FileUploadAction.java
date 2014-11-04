/**
 * Created by Виктор on 03.11.2014.
 */

package action;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import form.FileUploadForm;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileUploadAction extends DispatchAction {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

//        FileUploadForm fileUploadForm = (FileUploadForm) form;
//        FormFile file = fileUploadForm.getFile();
//        String filePath = getServlet().getServletContext().getRealPath("/") +"upload";
//        File folder = new File(filePath);
//        if(!folder.exists()){
//            folder.mkdir();
//        }
//
//        String fileName = file.getFileName();
//
//        if(!("").equals(fileName)){
//
//            System.out.println("Server path:" +filePath);
//            File newFile = new File(filePath, fileName);
//
//            if(!newFile.exists()){
//                FileOutputStream fos = new FileOutputStream(newFile);
//                fos.write(file.getFileData());
//                fos.flush();
//                fos.close();
//            }
//
//            request.setAttribute("uploadedFilePath",newFile.getAbsoluteFile());
//            request.setAttribute("uploadedFileName",newFile.getName());
//        }
//
//
//        FileUploadForm uploadForm = (FileUploadForm) form;
//        FileOutputStream outputStream = null;
//        FormFile formFile = null;
//        try {
//           formFile = uploadForm.getFile();
//            String path = getServlet().getServletContext().getRealPath("")+"/"+
//                    formFile.getFileName();
//            outputStream = new FileOutputStream(new File(path));
//            outputStream.write(formFile.getFileData());
//            }
//        finally {
//            if (outputStream != null) {
//                outputStream.close();
//                }
//            }
        //uploadForm.setMessage("The file "+formFile.getFileName()+" is uploaded successfully.");

        boolean isMultipart = FileUpload.isMultipartContent(request);

        if (isMultipart) {
            // Create a factory for disk-based file items
            FileItemFactory factory = new DiskFileItemFactory();

            // Create a new file upload handler
            FileUpload upload = new FileUpload(factory);

            try {
                // Parse the request
                List /* FileItem */ items = upload.parseRequest(request);
                Iterator iterator = items.iterator();
                while (iterator.hasNext()) {
                    FileItem item = (FileItem) iterator.next();
                    if (!item.isFormField()) {
                        String fileName = item.getName();
                        String root = getServlet().getServletContext().getRealPath("/");
                        File path = new File(root + "/uploads");
                        if (!path.exists()) {
                            boolean status = path.mkdirs();
                        }

                        File uploadedFile = new File(path + "/" + fileName);

                        System.out.println(uploadedFile.getAbsolutePath());
                        System.out.println(item.getString());
                        item.write(uploadedFile);
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        return mapping.findForward("success");
    }
}
