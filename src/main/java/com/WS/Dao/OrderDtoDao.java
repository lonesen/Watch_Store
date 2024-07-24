package com.WS.Dao;

import com.WS.DTO.OrderDTO;
import com.WS.Entity.Order;
import com.WS.Entity.OrderDetail;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDtoDao extends JpaRepository<OrderDTO, Integer> {
    @Query("SELECT NEW com.WS.DTO.OrderDTO(o.id AS id, u.name AS name, u.email AS email, o.createdate AS createdate, o.amount AS amount, o.address AS address, o.orderstatus AS orderstatus)\n" +
            "FROM Order o\n" +
            "JOIN o.user u\n" +
            "WHERE o.orderstatus = 'Waiting'\n")
    List<OrderDTO> findOrdersByStatus();

//    @Query("SELECT o FROM Order o WHERE o.id = :id")
//    OrderDTO findOrderById(@Param("id") Integer id);

    @Query("SELECT new com.WS.DTO.OrderDTO(o.id AS id, u.name AS name, u.email AS email, o.createdate AS createdate, o.amount AS amount, o.address AS address, o.orderstatus AS orderstatus)\n" +
            "FROM Order o " +
            "JOIN o.user u " +
            "WHERE o.id = :id")
    OrderDTO findOrderById(@Param("id") Integer id);

    @Query("SELECT new com.WS.DTO.OrderDTO(o.id, u.name, u.email, o.createdate, o.amount, o.address, o.orderstatus) " +
            "FROM Order o JOIN o.user u WHERE o.orderstatus = :status")
    List<OrderDTO> findOrdersByStatus(@Param("status") String status);

    @Query("SELECT new com.WS.DTO.OrderDTO(o.id, u.name, u.email, o.createdate, o.amount, o.address, o.orderstatus) " +
            "FROM Order o JOIN o.user u")
    List<OrderDTO> findAllOrder(Sort sort);

    @Query("SELECT new com.WS.DTO.OrderDTO(o.id, u.name, u.email, o.createdate, o.amount, o.address, o.orderstatus) " +
            "FROM Order o JOIN o.user u " +
            "WHERE u.name LIKE %:keywords% OR u.email LIKE %:keywords% OR str(o.id) LIKE %:keywords%")
    List<OrderDTO> searchOrdersByKeywords(@Param("keywords") String keywords);



    @Query("SELECT new com.WS.DTO.OrderDTO(o.id, u.name, u.email, o.createdate, o.amount, o.address, o.orderstatus) " +
            "FROM Order o JOIN o.user u WHERE o.orderstatus = :status")
    List<OrderDTO> findOrdersByStatusAndSort(@Param("status") String status, Sort sort);








}
