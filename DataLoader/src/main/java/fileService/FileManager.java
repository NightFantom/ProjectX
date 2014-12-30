/**
 * Создано: Виктор
 * Дата: 09.11.2014
 */
package fileService;

import org.apache.struts.upload.FormFile;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class FileManager {
    private static final String FILE_PREFIX = "Pharmacy";
    private Scanner scanner;
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
     * @param pathFile - путь до файла
     */
    public FileManager(String pathFile) {
        this.pathFile = pathFile;
    }

    /**
     * @param formFile - файл, который загрузили
     * @return файл в который скопировали данные
     */
    //TODO: Если с загрузкой файла произошла ошибка, то пробросить её наверх
    public File loadFile(FormFile formFile, String name) {
        createFolder();
        File newFile = new File(pathFile, FILE_PREFIX + name);
        try(FileOutputStream outputStream = new FileOutputStream(newFile)) {
            outputStream.write(formFile.getFileData());
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFile;
    }

    /**
     * Создаёт папку
     * @return Да, если и только если, папка создана успешно
     */
    public boolean createFolder() {
        //TODO: Сделать так чтобы, если папка существует, то её не создавать.
        File folder = new File(pathFile);
        if (Files.isRegularFile(folder.toPath())) {
            try {
                Files.delete(folder.toPath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return folder.mkdir();
    }
}
