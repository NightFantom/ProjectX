package parsers;
/**
 * Created by Виктор on 04.11.2014.
 */

import fileService.FileManager;
import form.UpdateRecord;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
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
     * @return обновленные данные из распарсенной строки, где все распарсенные данные являются типом String
     */
    private UpdateRecord getParseRecord() {
        try {
            parseRecord = new UpdateRecord();
            fromIndex = 0;
            parseRecord.setName(s.substring(fromIndex, s.indexOf(' ')));
            fromIndex = s.indexOf(' ') + 1;
            parseRecord.setAmount(Integer.parseInt(s.substring(fromIndex, s.indexOf(' ', fromIndex))));
            fromIndex = s.indexOf(' ', fromIndex) + 1;
            parseRecord.setCost(Double.parseDouble(s.substring(fromIndex, s.indexOf(';', fromIndex))));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return parseRecord;
    }

    /**
     * Распарсить файл
     *
     * @param pathToFile путь до файла
     */
    private void parseFile(String pathToFile, String encoding) {

        scanner = new FileManager(pathToFile).getScanner();
        while (scanner.hasNextLine()) {
            s = new String(scanner.nextLine().getBytes(),Charset.forName(encoding));
            try {
                list.add(getParseRecord());
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }

    }

    public List<UpdateRecord> getRecords(String pathToFile, String encoding) throws ParsingException {
        if (pathToFile != null && !pathToFile.equals("")) {
            parseFile(pathToFile, encoding);
        } else {
            throw new ParsingException("Некорректный путь до файла");
        }
        if (!list.isEmpty()) {
            return list;
        } else {
            throw new ParsingException("Нет распарсенных данных");
        }

    }
}
