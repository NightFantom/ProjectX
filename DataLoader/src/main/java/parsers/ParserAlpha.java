package parsers;
/**
 * Created by Виктор on 04.11.2014.
 */

import fileService.FileManager;
import form.UpdateRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Парсер для внутреннего тестирования системы.
 * Формат парсера: "название+пробел+количество+пробел+стоимость+;".
 * На данном этапе следует строго соблюдать формат
 */
public class ParserAlpha implements Parser {

    private List<UpdateRecord> list = new LinkedList<UpdateRecord>();
    private final int nameIndex = 0;
    private final int amountIndex = 1;
    private final int costIndex = 2;
    private String s;
    private UpdateRecord parseRecord;
    private Scanner scanner;
    private final String separator = "\\^";
    protected final Logger LOG = LogManager.getLogger(ParserAlpha.class);

    private Integer getNumber(String number) {
        return Integer.parseInt(number);
    }

    private Double getRealNumber(String real) {
        return Double.parseDouble(real);
    }

    /**
     * @return обновленные данные из распарсенной строки, где все распарсенные данные являются типом String
     */
    private UpdateRecord getParseRecord() throws ParsingException {

        try {
            parseRecord = new UpdateRecord();
            parseRecord.setName(s.split(separator)[nameIndex]);
            parseRecord.setAmount(getNumber(s.split(separator)[amountIndex]));
            parseRecord.setCost(getRealNumber(s.split(separator)[costIndex]));
        } catch (PatternSyntaxException e) {
            throw new ParsingException("Не могу распарсить строку " + s + " " + e.toString());
        }catch (IndexOutOfBoundsException e){
            throw new ParsingException("Не могу распарсить строку " + s + " " + e.toString());
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
                LOG.error("Ошибка при попытке поместить строку в лист распарсенных данных " + e.toString());
            } catch (ParsingException e) {
                LOG.error(e.toString());
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
