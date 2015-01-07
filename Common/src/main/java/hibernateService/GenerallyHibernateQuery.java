/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: 
 */
package hibernateService;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class GenerallyHibernateQuery {
    public abstract void run(Session session) throws HibernateException;
}
