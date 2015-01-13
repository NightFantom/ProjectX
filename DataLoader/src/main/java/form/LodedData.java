package form;
/**
 * Created by Виктор on 04.11.2014.
 */

import entities.Pharmacy;

/**
 * Класс загруженных в экшене данных.
 * Экземпляры класса помещаются в статик очередь на обработку
 */
public class LodedData {

    private String pathToFile;
    public Pharmacy pharmacy;

     /**
     *
     * @return путь до файла
     */
    public String getPathToFile() {
        return pathToFile;
    }

    /**
     *
     * @param file
     */
    public void setPathToFile(String file) {
        this.pathToFile = file;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
