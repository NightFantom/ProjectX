/**
 * Created: Денис 
 * Date: 09.11.14.
 */
package entities;

public class City {
    private String name;
    private Integer id;

    public City() {
    }

    public City(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
