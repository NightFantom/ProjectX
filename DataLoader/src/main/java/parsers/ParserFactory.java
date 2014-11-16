package parsers;

/**
 * Created by Виктор on 14.11.2014.
 */
public class ParserFactory {
    public Parser getParser(String parserName){
        Parser parser = null;
        try {
            parser = (Parser)Class.forName(parserName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return parser;
    }
}
