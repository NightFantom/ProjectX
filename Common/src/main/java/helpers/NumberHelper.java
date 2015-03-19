/**
 * Создано: Денис 
 * Дата: 12.02.15
 * Описание: 
 */
package helpers;

public class NumberHelper {

    /**
     * Получение количества единиц товара с учётом наличия и скрытности данных о количестве товара
     * @param count Количество единиц товара
     * @return "Нет в наличии" если количество единиц = 0, "Есть в наличии" если информация скрыта, "Доступно под заказ" = -2. В остальных случаях число.
     */
    public static String getAmountMedicament(Integer count){
        switch (count){
            case 0:
                return "Нет в наличии";
            case -1:
                return "Есть в наличии";
            case -2:
                return "Доступно под заказ";
        }
        return count.toString();
    }

    /**
     * Получение стоимости лекарства с учётом "шума"
     * @param cost стоимость
     * @return Строковое представление числа с учётом "шума"
     */
    public static String getCostMedicament(Double cost){
        if (cost < 0){
            return  "---";
        }
        return cost.toString();
    }
}
