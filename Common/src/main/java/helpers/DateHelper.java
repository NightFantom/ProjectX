/**
 * Created: Денис 
 * Date: 23.11.14.
 */
package helpers;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateHelper {

    /**
     * Возвращает дату обновления в виде слова, если последнее обновление было вчера или сегодня
     * @param calendar - Слово Вчера/Сегодня, если последнее обновление было вчера/сегодня. В остальных случае просто ДД.ММ
     * @return
     */
    public static String getDateUpdate(Calendar calendar){
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        Calendar currentDate = new GregorianCalendar();
        int currentDay = currentDate.get(Calendar.DATE);
        int currentMonth = currentDate.get(Calendar.MONTH);
        if (month == currentMonth){
            switch(currentDay-day){
                case 0: return "Сегодня";
                case 1: return "Вчера";
            }
        }
        if (month < 10){
            return day + ".0" + month;
        }
        return day + "." + month;
    }
}
