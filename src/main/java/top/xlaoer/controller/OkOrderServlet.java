package top.xlaoer.controller;

import top.xlaoer.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Xlaoer
 * @date 2022/5/19 14:53
 */
public class OkOrderServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int orderid = Integer.parseInt(req.getParameter("orderid"));
        orderService.okOrderById(orderid);
        resp.sendRedirect("/orderlist");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
