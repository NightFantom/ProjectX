package parsers;


import fileService.FileManager;
import form.UpdateRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Виктор on 15.03.2015.
 */
public class ParserIPGolodova implements Parser {

    private List<UpdateRecord> list = new LinkedList<UpdateRecord>();
    private String encoding;
    private String s;
    private UpdateRecord parseRecord;
    private Scanner scanner;

    protected final Logger LOG = LogManager.getLogger(ParserIPGolodova.class);

    private Integer getNumber(String number) {
        return Integer.parseInt(number);
    }

    private Double getRealNumber(String real) {
        return Double.parseDouble(real);
    }

    private String nextTextStyle() {
        if (scanner.hasNextLine()) {
            s = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));
        }
        while (scanner.hasNextLine() && !s.contains("TextStyle")) {
            s = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));
        }
        return s;
    }

    private void skipHeader() {
        s = "";
        while (scanner.hasNextLine() && !s.contains("Срок годн.")) {
            s = new String(scanner.nextLine().getBytes(), Charset.forName(encoding));
        }
        if (scanner.hasNextLine()) {
            s = scanner.nextLine();
        }
    }

    private String getPrice() {
        String price = new String();
        nextTextStyle();
        nextTextStyle();
        s = nextTextStyle();

        if (s.contains("TextStyle2") && s.contains(".") && !s.equals("<\\HTML>")&& !s.equals("")) {
            price =  (s.substring(s.indexOf(">") + 1, s.indexOf("</SPAN>")).replaceAll(" ", ""));
            if(price.contains(",")) {
                price = price.substring(0,price.indexOf(",")) +  price.substring(price.indexOf(",")+1);
            }

        }
        s = nextTextStyle();
        return price;
    }

    private String getName() {
        String name = new String();
        if (s.contains("TextStyle6")&& !s.equals("<\\HTML>")&& !s.equals("")) {
            name = s.substring(s.indexOf(">") + 1, s.indexOf("</SPAN>")).toUpperCase();
        }
        s = nextTextStyle();
        if (s.contains("TextStyle6")&& !s.equals("<\\HTML>")&& !s.equals("")) {
            name = s.substring(s.indexOf(">") + 1, s.indexOf("</SPAN>")).toUpperCase();
            s = nextTextStyle();
        }
        return name;
    }

    private String getCount() {
        String count = new String();
        if (s.contains("TextStyle5") && s.contains(".")&& !s.equals("<\\HTML>")&& !s.equals("")) {
            count = s.substring(s.indexOf(">") + 1, s.indexOf("</SPAN>")).replaceAll(" ", "");
            count = "-1";
        }
        s = nextTextStyle();
        return count;
    }


    /**
     * @return обновленные данные из распарсенной строки, где все распарсенные данные являются типом String
     */
    private UpdateRecord getParseRecord() throws ParsingException {
        String price = "";
        String name = "";
        String count = "";
        try {
            if(!s.equals("")&& !s.equals("<\\BODY>")&& !s.equals("<\\HTML>")) {
                parseRecord = new UpdateRecord();
                price = getPrice();
                name = getName();
                count = getCount();
                if(!price.equals("") && !name.equals("")&& !count.equals("")) {
                    parseRecord.setCost(getRealNumber(price));
                    parseRecord.setName(name);
                    parseRecord.setAmount(getNumber(count));
                }
            }

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
    private void parseFile(String pathToFile) {
        UpdateRecord updateRecord;
        scanner = new FileManager(pathToFile).getScanner();
        skipHeader();
        while (scanner.hasNextLine() && !scanner.nextLine().equals("<\\BODY>")&& !scanner.nextLine().equals("<\\HTML>")) {

            try {
                updateRecord = getParseRecord();
                if (updateRecord != null && updateRecord.getAmount() != null && updateRecord.getCost() != null && updateRecord.getName() != null){
                    list.add(updateRecord);
            }
            } catch (NullPointerException e) {
                LOG.error("Ошибка при попытке поместить строку в лист распарсенных данных " + e.toString());
            } catch (ParsingException e) {
                LOG.error(e.toString());
            }
        }

    }

    public List<UpdateRecord> getRecords(String pathToFile, String encoding)throws ParsingException{
        if (pathToFile != null && !pathToFile.equals("")) {
            this.encoding = encoding;
            parseFile(pathToFile);
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
