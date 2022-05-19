package top.xlaoer.pojo;

import java.util.Date;

/**
 * @author Xlaoer
 * @date 2022/5/19 9:55
 */
public class Order {
    private Integer id;
    private Integer studentId;
    private Integer dormitoryId;
    private String item;
    private Integer status;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Order(Integer id, Integer studentId, Integer dormitoryId, String item, Integer status, Date createTime) {
        this.id = id;
        this.studentId = studentId;
        this.dormitoryId = dormitoryId;
        this.item = item;
        this.status = status;
        this.createTime = createTime;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", dormitoryId=" + dormitoryId +
                ", item='" + item + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
