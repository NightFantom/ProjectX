package parsers;

import fileService.FileManager;
import form.ParseRecord;
import form.Record;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Виктор on 04.11.2014.
 */
public class ParserTXT implements Parser {

    private List<ParseRecord> list = new LinkedList<>();
    private int beginPos = 0;
    private int endPos = 0;
    private String s;
    ParseRecord parseRecord;

    private ParseRecord getParseRecord(){

        parseRecord = new ParseRecord();

        endPos = s.indexOf(' ');
        parseRecord.setName(s.substring(beginPos,--endPos));
        beginPos = ++endPos;
        endPos = s.indexOf(' ', beginPos);
        parseRecord.setAmount(s.substring(beginPos, --endPos));
        beginPos = ++endPos;
        endPos = s.indexOf(';', beginPos);
        parseRecord.setCost(s.substring(beginPos, --endPos));

        return parseRecord;
    }

    private void parseFile(String pathToFile) {
        FileManager fileManager = new FileManager(pathToFile);
        while (fileManager.getIn().hasNextLine()) {
            s = new FileManager(pathToFile).readString();
            list.add(getParseRecord());
        }

    }

    public List<ParseRecord> getRecords(String pathToFile) {
        parseFile(pathToFile);
        return list;
    }
}
