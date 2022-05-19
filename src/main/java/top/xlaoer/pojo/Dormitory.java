package top.xlaoer.pojo;

/**
 * @author Xlaoer
 * @date 2022/5/8 18:59
 */
public class Dormitory {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dormitory(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Dormitory() {
    }

    @Override
    public String toString() {
        return "Dormitory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
