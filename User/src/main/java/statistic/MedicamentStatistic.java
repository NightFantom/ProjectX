/**
 * Создано: Денис 
 * Дата: 07.01.15
 * Описание: 
 */
package statistic;

public class MedicamentStatistic extends BaseStatistic {

    private static final String NAME_STATISTIC = "Лекарственная статистика";

    public MedicamentStatistic() {
        super(NAME_STATISTIC);
    }

    public MedicamentStatistic(int timeIntervalInHour) {
        super(timeIntervalInHour, NAME_STATISTIC);
    }

    public void flush() {

    }
}
