/**
 * Created: Денис 
 * Date: 04.11.14.
 */
package hibernateService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Locale;

public class HibernateListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        try {
            //Требуется для корректного подключения к БД в случае c проблемой NLS(см. ORA-12705)
            Locale.setDefault(Locale.ENGLISH);
            HibernateUtil.buildSessionFactory();
        } catch (Exception e) {
            //TODO: Исправить на логирование
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        HibernateUtil.closeSessionFactory();
    }
}
