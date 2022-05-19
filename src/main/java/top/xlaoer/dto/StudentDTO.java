package top.xlaoer.dto;

import top.xlaoer.pojo.Dormitory;
import top.xlaoer.pojo.Order;
import top.xlaoer.pojo.Student;

/**
 * @author Xlaoer
 * @date 2022/5/19 15:50
 */
public class StudentDTO {
    private Student student;
    private Dormitory dormitory;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "student=" + student +
                ", dormitory=" + dormitory +
                '}';
    }
}
