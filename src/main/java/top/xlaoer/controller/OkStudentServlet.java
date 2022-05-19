package top.xlaoer.controller;

import top.xlaoer.service.OrderService;
import top.xlaoer.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xlaoer
 * @date 2022/5/19 14:53
 */
public class OkStudentServlet extends HttpServlet {
    private StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int studentid = Integer.parseInt(req.getParameter("studentid"));
        studentService.okStudent(studentid);
        resp.sendRedirect("/studentlist");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
