package fileService;

import org.apache.struts.upload.FormFile;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

/**
 * Created by Виктор on 09.11.2014.
 */

/**
 *
 */
public class FileManager {
    private Scanner scanner;
    private PrintWriter out;
    private String pathFile;

    /**
     * Сканер файла
     * @return
     */
    public Scanner getScanner() {
        try {
            scanner = new Scanner(new FileReader(pathFile));
        } catch (IOException e) {
            throw new Error(e);
        }
        return scanner;
    }

    /**
     *
     * @param in
     */
    public void setIn(Scanner in) {
        this.scanner = in;
    }

    /**
     *
     * @param pathFile - путь до файла
     */
    public FileManager(String pathFile){
        this.pathFile = pathFile;
    }

    /**
     *
     * @param formFile - файл, который загрузили
     * @return файл в который скопировали данные
     */
    public File loadFile(FormFile formFile){
        createFolder();
        if (!formFile.getFileName().equals("")) {
            File newFile = new File(pathFile, formFile.getFileName());
            FileOutputStream fos = null;
            if (!newFile.exists()) {
                try {
                    fos = new FileOutputStream(newFile);
                    fos.write(formFile.getFileData());
                    fos.flush();
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return newFile;
        }
        return null;
    }

    /**
     * Создает новую папку для файла
     */
    public void createFolder(){
        File folder = new File(pathFile);
        if(Files.isRegularFile(folder.toPath())) {
            try {
                Files.delete(folder.toPath());
            }catch (IOException e){

            }

        }
        folder.mkdir();

    }
}
