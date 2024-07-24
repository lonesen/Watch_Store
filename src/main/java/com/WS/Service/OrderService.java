package com.WS.Service;

import com.WS.Dao.OrderDAO;
import com.WS.Entity.Order;
import com.WS.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDAO orderDAO;
    public List<Order> getOrdersByStatus() {
        List<Object[]> results = orderDAO.findOrdersByStatus();
        List<Order> orders = new ArrayList<>();

        for (Object[] result : results) {
            Order order = new Order();
            User user = new User();
            order.setId((Integer) result[0]);
            user.setName((String) result[1]);
            user.setEmail((String) result[2]);
            order.setCreatedate((Date) result[3]);
            order.setAmount((Float) result[4]);
            order.setAddress((String) result[5]);
            order.setOrderstatus((String) result[6]);
            order.setUser(user);
            orders.add(order);
        }

        return orders;
    }
}
