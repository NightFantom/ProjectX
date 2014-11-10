package parsers;
/**
 * Created by Виктор on 04.11.2014.
 */

import form.ParseRecord;
import java.util.List;

public interface Parser {

    public List<ParseRecord> getRecords(String pathToFile);

}
