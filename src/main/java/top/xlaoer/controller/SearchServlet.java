package top.xlaoer.controller;

import top.xlaoer.dto.OrderDTO;
import top.xlaoer.pojo.Dormitory;
import top.xlaoer.pojo.Order;
import top.xlaoer.pojo.Student;
import top.xlaoer.service.DormitoryService;
import top.xlaoer.service.OrderService;
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
 * @date 2022/5/19 11:55
 */
public class SearchServlet extends HttpServlet {
    private OrderService orderService = new OrderService();
    private StudentService studentService = new StudentService();
    private DormitoryService dormitoryService = new DormitoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String key = req.getParameter("key");
        String value = req.getParameter("value");
        List<Order> orders;
        if("username".equals(key)){
            orders=orderService.findOrderLikeName(value);
        }
        else if("domitory".equals(key)){
            orders=orderService.findOrderLikeDomitory(value);
        }
        else if("date".equals(key)){
            orders=orderService.findOrderLikeDate(value);
        }
        else {
            int status = Integer.parseInt(key);
            orders=orderService.findOrderByStatus(status);
        }
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order order:orders){
            if(order.getStatus()==2)continue;
            Student student = studentService.findStudentById(order.getStudentId());
            Dormitory dormitory = dormitoryService.findDomitoryById(order.getDormitoryId());
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrder(order);
            orderDTO.setStudent(student);
            orderDTO.setDormitory(dormitory);
            orderDTOS.add(orderDTO);
        }
        req.setAttribute("list", orderDTOS);
        req.getRequestDispatcher("orderlist.jsp").forward(req, resp);
    }
}
