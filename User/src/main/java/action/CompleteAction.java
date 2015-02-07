package action;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Виктор on 07.02.2015.
 */
public class CompleteAction extends LogDispatchAction {
    public ActionForward start(ActionMapping mapping, ActionForm form, HttpServletRequest request,HttpServletResponse response){
        //TODO принять данные из поисковой строки
        JSONObject jsonObject = new JSONObject();
        List<String> list = new ArrayList<>(); // в этот лист поместить найденные лекартсва
        //TODO запихать лекартсва в лист, то что ниже это просто для проверки работоспособности
        list.add("medicament1");
        list.add("лекартсво2");
        list.add("pharm3");

        jsonObject.put("value",list); // аяксу придет объект:  value : array[3]

        try {
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            out.write(jsonObject.toString());
            out.flush();
            out.close();
        }catch (IOException e){
            e.printStackTrace(); //TODO
        }
        return mapping.findForward("yep yep"); //TODO нужно что-то возвращать, поэтому прописал эту какаху, в struts-config.xml не стал мапить этот форвард
    }

}
