package top.xlaoer.controller;

import top.xlaoer.pojo.Admin;
import top.xlaoer.pojo.Student;
import top.xlaoer.service.AdminService;
import top.xlaoer.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Xlaoer
 * @date 2022/5/8 15:57
 */
public class LoginServlet extends HttpServlet {
    private StudentService studentService = new StudentService();
    private AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("student")!=null||req.getSession().getAttribute("admin")!=null)resp.sendRedirect("/studentmain.jsp");
        else resp.sendRedirect("/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        if(type.equals("student")){
            Student student = studentService.login(name, password);
            if(student==null){
                req.setAttribute("error", "用户名或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }else{
                if(student.getStatus()!=1){
                    req.setAttribute("error","用户未激活或被封禁，请联系宿管阿姨");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
                //将用户信息存入session中
                HttpSession session = req.getSession();
                session.setAttribute("student",student);
                resp.sendRedirect("/studentmain.jsp");
            }
        }else if(type.equals("admin")){
            Admin admin = adminService.login(name, password);
            if(admin==null){
                req.setAttribute("error", "用户名或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }else{
                //将用户信息存入session中
                HttpSession session = req.getSession();
                session.setAttribute("admin",admin);
                resp.sendRedirect("/adminmain.jsp");
            }
        }else{
            resp.sendRedirect("/login.jsp");
        }
    }
}
