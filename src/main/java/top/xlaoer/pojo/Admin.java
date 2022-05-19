package top.xlaoer.pojo;

/**
 * @author Xlaoer
 * @date 2022/5/8 18:47
 */
public class Admin {
    private Integer id;
    private String name;
    private String password;
    private String telephone;

    public Admin() {
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Admin(Integer id, String username, String password, String telephone) {
        this.id = id;
        this.name = username;
        this.password = password;
        this.telephone = telephone;
    }
}
