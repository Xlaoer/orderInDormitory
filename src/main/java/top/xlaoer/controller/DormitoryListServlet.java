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
public class DormitoryListServlet extends HttpServlet {
    private DormitoryService dormitoryService = new DormitoryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        List<Dormitory> dormitories = dormitoryService.listAll();
        req.setAttribute("list", dormitories);
        req.getRequestDispatcher("dormitorylist.jsp").forward(req, resp);
    }
}
