package form;

/**
 * Created by Виктор on 09.11.2014.
 */

/**
 * Класс данных, которые будут обновляться
 */
public class UpdateRecord {

    private String name;
    private String count;
    private String cost;

    /**
     *
     * @return название лекарства
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name название лекартсва
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return количество данного лекарства
     */
    public String getCount() {
        return count;
    }

    /**
     *
     * @param count количество даного лекарства
     */
    public void setCount(String count) {
        this.count = count;
    }

    /**
     *
     * @return стоимость лекарства
     */
    public String getCost() {
        return cost;
    }

    /**
     *
     * @param cost стоимость лекартсва
     */
    public void setCost(String cost) {
        this.cost = cost;
    }
}
