/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package checkForm.validators;

public interface Validator {

    /**
     * Валидация входной строки.
     * @param str Строка для валидации
     * @return Да, если поле корректно. Нет, в противном случае.
     */
    public boolean validate(String str);

    public void setErrorMessage(String message);
    public String getErrorMessage();
}
