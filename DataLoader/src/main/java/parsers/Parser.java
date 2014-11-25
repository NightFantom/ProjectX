package parsers;
/**
 * Created by Виктор on 04.11.2014.
 */

import form.UpdateRecord;

import java.util.List;

/**
 * Интерфейс парсера
 */
public interface Parser {

    /**
     *
     * @param pathToFile путь до файла, который нужно распарсить
     * @return лист распарсенных данных
     */
    //TODO: Написать проброску исключения в случае неудачного парсинга
    public List<UpdateRecord> getRecords(String pathToFile);

}
