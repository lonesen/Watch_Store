package com.WS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.WS.Entity.Order;
import com.WS.Entity.OrderDetail;


public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
	 List<OrderDetail> findByOrder(Order order);
	    @Query("SELECT p.name AS name, od.quantity AS quantity " +
	            "FROM Order o " +
	            "JOIN o.user u " +
	            "JOIN o.orderDetails od " +
	            "JOIN od.product p " +
	            "WHERE o.id = :id")
	    List<Object[]> findOrderIDByOrdeDTO(@Param("id") Integer id);
}
