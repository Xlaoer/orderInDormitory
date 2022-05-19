package top.xlaoer.controller;

import top.xlaoer.pojo.Dormitory;
import top.xlaoer.pojo.Student;
import top.xlaoer.service.DormitoryService;
import top.xlaoer.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author Xlaoer
 * @date 2022/5/19 14:18
 */
public class RegisterServlet extends HttpServlet {
    private StudentService studentService = new StudentService();
    private DormitoryService dormitoryService = new DormitoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String confirmpassword = req.getParameter("confirmpassword");
        String dormitoryname = req.getParameter("dormitoryname");
        String telephone = req.getParameter("telephone");
        String gender = req.getParameter("gender");

        if(name==null){
            req.setAttribute("error","名字不能为空");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
        if(password==null||confirmpassword==null||!password.equals(confirmpassword)){
            req.setAttribute("error","两次密码输入不一致");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
        List<Dormitory> domitorys = dormitoryService.findDomitoryByName(dormitoryname);
        if(dormitoryname==null||domitorys.isEmpty()){
            req.setAttribute("error","宿舍未注册,请联系宿管阿姨注册宿舍");
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }

        Student student = new Student();
        student.setCreateDate(new Date());
        student.setDormitoryId(domitorys.get(0).getId());
        student.setGender(gender);
        student.setStatus(0);
        student.setPassword(password);
        student.setTelephone(telephone);
        student.setName(name);
        studentService.addStudent(student);
        resp.sendRedirect("login.jsp");
    }
}
