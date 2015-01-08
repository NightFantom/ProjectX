/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package checkForm.parsers;

import exceptions.ParserException;

public interface FieldParser {
    public Object parser(String entity) throws ParserException;
}
