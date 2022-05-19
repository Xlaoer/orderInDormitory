package top.xlaoer.pojo;

import java.util.Date;

/**
 * @author Xlaoer
 * @date 2022/5/8 18:45
 */
public class Student {
    private Integer id;
    private String name;
    private String password;
    private String gender;
    private String telephone;
    private Integer dormitoryId;
    private Date createDate;
    private Integer status;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                ", dormitoryId=" + dormitoryId +
                ", createDate=" + createDate +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Student() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Student(Integer id, String name, String password, String gender, String telephone, Integer dormitoryId, Date createDate, Integer status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.telephone = telephone;
        this.dormitoryId = dormitoryId;
        this.createDate = createDate;
        this.status = status;
    }
}
