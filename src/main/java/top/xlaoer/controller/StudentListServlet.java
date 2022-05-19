package top.xlaoer.controller;

import top.xlaoer.dto.StudentDTO;
import top.xlaoer.pojo.Dormitory;
import top.xlaoer.pojo.Student;
import top.xlaoer.service.DormitoryService;
import top.xlaoer.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 15:43
 */
public class StudentListServlet extends HttpServlet {
    private StudentService studentService = new StudentService();
    private DormitoryService dormitoryService = new DormitoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Student> students = studentService.listAll();
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for(Student student:students){
            if(student.getStatus()==2)continue;
            Dormitory dormitory = dormitoryService.findDomitoryById(student.getDormitoryId());
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudent(student);
            studentDTO.setDormitory(dormitory);
            studentDTOS.add(studentDTO);
        }
        req.setAttribute("list", studentDTOS);
        req.getRequestDispatcher("studentlist.jsp").forward(req, resp);
    }
}
