package top.xlaoer.controller;

import top.xlaoer.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xlaoer
 * @date 2022/5/19 13:19
 */
public class DeleteOrderServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int orderid = Integer.parseInt(req.getParameter("orderid"));
        orderService.deleteOrderById(orderid);
        resp.sendRedirect("/orderlist");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
