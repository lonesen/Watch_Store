package com.WS.Controller.admin;


import com.WS.DTO.OrderDTO;
import com.WS.DTO.OrderDetailDTO;
import com.WS.Dao.*;
import com.WS.Entity.*;
import com.WS.Service.OrderService;
import com.WS.Service.CookieService;
import com.WS.Service.ParamService;
import com.WS.Service.SessionService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/xulydonhang")
public class XuLyControllerAdmin {

    @Autowired
    private ProductDAO productDao;

    @Autowired
    private CategoryDAO categoryDao;

    @Autowired
    private SupplierDAO supplierDAO;

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDtoDao orderDtoDao;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private OrderService orderService;

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;


    @GetMapping("/OverviewOrder")
    public String OverviewOrder(Model model){
        List<OrderDTO> viewOrder = orderDtoDao.findOrdersByStatus();
        model.addAttribute("orders", viewOrder);


        List<Order> list = orderDAO.findAll();
        for (Order od:
             list) {
        }
//        model.addAttribute("orders",orderDAO.findAll());
        return "/admin/donhang-overview";
    }
    @GetMapping("/sortOrders")
    @ResponseBody
    public List<OrderDTO> sortOrders(
            @RequestParam(name = "sortField", required = false) String sortField,
            @RequestParam(name = "sortDir", required = false) String sortDir,
            @RequestParam(name = "status", required = false) String status
    ) {

        Sort sort = Sort.unsorted();

        if (sortField != null && sortDir != null) {
            sort = Sort.by(Sort.Direction.fromString(sortDir), sortField);
        }

        if (status != null && !status.isEmpty()) {
            return orderDtoDao.findOrdersByStatusAndSort(status, sort);
        } else {
            return orderDtoDao.findAllOrder(sort);
        }
    }
    @GetMapping("/searchOrder")
    @ResponseBody
    public List<OrderDTO> searchOrder(@RequestParam("keywords") String keywords) {
        return orderDtoDao.searchOrdersByKeywords(keywords);
    }

    //    @GetMapping("/filterOrders")
//    @ResponseBody
//    public List<OrderDTO> filterOrders(@RequestParam("status") String status) {
//        if (status.isEmpty()) {
//            return orderDtoDao.findAll();
//        } else {
//            return orderDtoDao.findOrdersByStatus(status);
//        }
//    }
    @GetMapping("/OverviewOrder/done/{id}")
    public String doneOder(@PathVariable("id") Integer id){
//        OrderDTO order = orderDtoDao.findById(id).orElse(null);
//        if (order != null) {
//            order.setOrderstatus("Done");
//            orderDtoDao.save(order);
//        }
        Order order = orderDAO.findById(id).orElse(null);
        if (order != null) {
            order.setOrderstatus("Done");
            orderDAO.save(order);
        }
        return "redirect:/admin/xulydonhang/OverviewOrder";
    }
    @GetMapping("/OverviewOrder/Canceled/{id}")
    public String Canceled(@PathVariable("id") Integer id){
//        OrderDTO order = orderDtoDao.findById(id).orElse(null);
//        if (order != null) {
//            order.setOrderstatus("Done");
//            orderDtoDao.save(order);
//        }
        Order order = orderDAO.findById(id).orElse(null);
        System.out.println(order.getAddress());
        if (order != null) {
            order.setOrderstatus("Canceled");
            orderDAO.save(order);
        }
        return "redirect:/admin/xulydonhang/OverviewOrder";
    }



    @GetMapping("/OverviewOrder/edit/{id}")
    public String editOrder(@PathVariable("id") Integer id, Model model) {
        OrderDTO order = orderDtoDao.findOrderById(id);
        if (order != null) {
            model.addAttribute("order", order);
        }
        List<Object[]> orderDetails = orderDetailDAO.findOrderIDByOrdeDTO(id);
        List<OrderDetailDTO> orderDetailDTOs = new ArrayList<>();

        for (Object[] detail : orderDetails) {
            String name = (String) detail[0];
            Integer quantity = (Integer) detail[1];
            orderDetailDTOs.add(new OrderDetailDTO(name, quantity));
        }

        model.addAttribute("orderDetail", orderDetailDTOs);
        return "admin/chitietdonhang";
    }


}
