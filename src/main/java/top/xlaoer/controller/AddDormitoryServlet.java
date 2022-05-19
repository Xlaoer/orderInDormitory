package top.xlaoer.controller;

import top.xlaoer.pojo.Dormitory;
import top.xlaoer.pojo.Order;
import top.xlaoer.service.DormitoryService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Xlaoer
 * @date 2022/5/19 16:11
 */
public class AddDormitoryServlet extends HttpServlet {
    private DormitoryService dormitoryService = new DormitoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String dormitoryname = req.getParameter("dormitoryname");
        Dormitory dormitory = new Dormitory();
        dormitory.setName(dormitoryname);
        dormitoryService.addDormitory(dormitory);
        resp.sendRedirect("/orderlist");
    }
}
