package fileService;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Виктор on 09.11.2014.
 */
public class FileManager {
    private Scanner in;

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }

    private PrintWriter out;
    private String pathFile;

    public FileManager(String pathFile){
        this.pathFile = pathFile;
        try {
            in = new Scanner(new FileReader(pathFile));
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    public String readString(){
        return in.nextLine();
    }
}
