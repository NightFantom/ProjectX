package parsers;

/**
 * Created by Виктор on 26.11.2014.
 */
public class ParsingException extends Exception {
    private String message = null;

    public ParsingException(String message) {
        this.message = message;
    }
    public String toString(){
        return "Не удалось распарсить файл: " + message;
    }
}
