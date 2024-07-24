package com.WS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.WS.DTO.OrderDTO;
import com.WS.Entity.Order;
import com.WS.Entity.User;

public interface OrderDAO extends JpaRepository<Order, Integer> {
	List<Order> findByUser(User user); 
//  @Query("SELECT NEW com.WS.DTO.OrderDTO(o.id AS OrderID, u.name AS UserName, u.email AS UserEmail, o.createdate AS OrderDate, o.amount AS OrderAmount, o.address AS address, o.orderstatus AS OrderStatus)\n" +
//  "FROM Order o\n" +
//  "JOIN o.user u\n" +
//  "WHERE o.orderstatus = 'Waiting'\n")
//List<Order> findOrdersByStatus();
//@Query("SELECT o FROM Order o JOIN o.user u WHERE o.orderstatus = 'Waiting'")
//List<Order> findOrdersByStatus();
@Query("SELECT o.id, u.name, u.email, o.createdate, o.amount, o.address, o.orderstatus " +
  "FROM Order o " +
  "JOIN o.user u " +
  "WHERE o.orderstatus = 'Waiting'")
List<Object[]> findOrdersByStatus();



//@Query("SELECT o FROM Order o WHERE o.id = :id")
//Order findOrderById(@Param("id") Integer id);

@Query("SELECT NEW com.WS.DTO.OrderDTO(o.id, u.name, u.email, o.createdate, o.amount, o.address, o.orderstatus) " +
  "FROM Order o JOIN o.user u WHERE o.orderstatus = :status")
List<OrderDTO> findOrdersByStatus(@Param("status") String status);
}
