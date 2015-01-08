/**
 * Создано: Денис 
 * Дата: 08.01.15
 * Описание: 
 */
package checkForm.parsers;

import exceptions.ParserException;

public class IntegerParser implements FieldParser {
    @Override
    public Object parser(String entity) throws ParserException{
        return Integer.valueOf(entity);
    }
}
