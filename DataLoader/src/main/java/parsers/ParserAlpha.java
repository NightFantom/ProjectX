package parsers;
/**
 * Created by Виктор on 04.11.2014.
 */
import fileService.FileManager;
import form.UpdateRecord;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Парсер для внутреннего тестирования системы.
 * Формат парсера: "название+пробел+количество+пробел+стоимость+;".
 * На данном этапе следует строго соблюдать формат
 */
public class ParserAlpha implements Parser {

    private List<UpdateRecord> list = new LinkedList<>();
    private int fromIndex = 0;
    private String s;
    private UpdateRecord parseRecord;
    private Scanner scanner;

    /**
     *
     * @return обновленные данные из распарсенной строки, где все распарсенные данные являются типом String
     */
    private UpdateRecord getParseRecord(){

        parseRecord = new UpdateRecord();
        fromIndex = 0;
        parseRecord.setName(s.substring(fromIndex,s.indexOf(' ')));
        fromIndex = s.indexOf(' ') + 1;
        parseRecord.setCount(s.substring(fromIndex, s.indexOf(' ', fromIndex)));
        fromIndex = s.indexOf(' ', fromIndex) + 1;
        parseRecord.setCost(s.substring(fromIndex, s.indexOf(';', fromIndex)));

        return parseRecord;
    }

    /**
     * Распарсить файл
     * @param pathToFile путь до файла
     */
    private void parseFile(String pathToFile) {

        scanner = new FileManager(pathToFile).getScanner();
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            list.add(getParseRecord());
        }

    }

    public List<UpdateRecord> getRecords(String pathToFile) {
        parseFile(pathToFile);
        return list;
    }
}
