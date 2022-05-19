package top.xlaoer.service;

import top.xlaoer.dao.StudentDao;
import top.xlaoer.dao.impl.StudentDaoImpl;
import top.xlaoer.pojo.Student;

import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/8 18:45
 */
public class StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    public List<Student> listAll(){
        return studentDao.list();
    }

    public Student login(String name,String password){
        List<Student> studentByName = studentDao.findStudentByName(name);
        if(studentByName==null||studentByName.isEmpty())return null;
        for(Student student:studentByName){
            if(student.getPassword().equals(password)){
                return student;
            }
        }
        return null;
    }

    public Student findStudentById(int id){
        return studentDao.findStudentById(id);
    }

    public int addStudent(Student student){
        return studentDao.insert(student);
    }

    public int okStudent(int id){
        return studentDao.updateStatusById(id,1);
    }
    public int deleteStudent(int id){
        return studentDao.updateStatusById(id,2);
    }

}
