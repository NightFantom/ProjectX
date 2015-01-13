/**
 * Создано: Денис 
 * Дата: 04.01.15
 * Описание: Класс-помошник для работы со строками
 */
package helpers;

public class StringHelper {

    /**
     * Проверка на пустую строку
     * @param str Проверяемая строка
     * @return Да, если строка равна null или пустая. Нет в остальных случаях
     */
    public static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }

    /**
     * Проверка, не пустая ли строка.
     * @param str Проверяемая строка
     * @return Да, если строка не пустая. Нет в остальных случаях
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
