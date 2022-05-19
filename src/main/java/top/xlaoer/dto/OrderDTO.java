package top.xlaoer.dto;

import top.xlaoer.pojo.Dormitory;
import top.xlaoer.pojo.Order;
import top.xlaoer.pojo.Student;

import java.util.Date;

/**
 * @author Xlaoer
 * @date 2022/5/19 11:56
 */
public class OrderDTO {
    private Student student;
    private Order order;
    private Dormitory dormitory;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "student=" + student +
                ", order=" + order +
                ", dormitory=" + dormitory +
                '}';
    }
}
