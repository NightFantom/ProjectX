/**
 * Created: Денис 
 * Date: 16.11.14.
 */
package helpers;

import javax.servlet.http.HttpServletRequest;

public class SessionAndRequestHelper {

    private static final String ID_CITY = "idCity";

    public static Integer getCityId(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(ID_CITY);
    }

}
