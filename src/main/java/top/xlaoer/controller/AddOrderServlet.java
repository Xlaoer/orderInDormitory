package top.xlaoer.controller;

import top.xlaoer.pojo.Order;
import top.xlaoer.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @author Xlaoer
 * @date 2022/5/19 10:36
 */
public class AddOrderServlet extends HttpServlet {
    private OrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String studentId = req.getParameter("studentId");
        String dormitoryId = req.getParameter("dormitoryId");
        String item = req.getParameter("item");
        Order order = new Order();
        order.setStudentId(Integer.parseInt(studentId));
        order.setDormitoryId(Integer.parseInt(dormitoryId));
        order.setItem(item);
        order.setStatus(0);
        order.setCreateTime(new Date());
        orderService.addOrder(order);
        resp.sendRedirect("/orderlist");
    }
}
