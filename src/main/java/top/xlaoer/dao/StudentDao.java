package top.xlaoer.dao;

import top.xlaoer.pojo.Student;

import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/8 19:06
 */
public interface StudentDao {
    public List<Student> list();
    public Student findStudentById(Integer id);
    public List<Student> findStudentByName(String name);
    public List<Student> findStudentByDormitoryId(Integer id);
    public Integer insert(Student student);
    public Integer updateStudent(Student student);
    public Integer updateStatusById(Integer id,Integer status);
}
