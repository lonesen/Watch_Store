package com.WS.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.WS.Entity.Category;
import com.WS.Entity.Product;
import com.WS.Entity.Report;

public interface ProductDAO extends JpaRepository<Product, String>{
	   @Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
	    List<Product> findByPrice(double minPrice, double maxPrice);

//	    @Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
//	    Page<Product> findByKeywords(String keywords, Pageable pageable);

	    Page<Product> findAllByNameLike(String keywords, Pageable pageable);

	    Page<Product> findByCategory(Category category, Pageable pageable);

	    Page<Product> findByCategory_Name(String keywords, Pageable pageable);

	    List<Product> findByPriceBetween(double minPrice, double maxPrice);

	    Page<Product> findAllById(Integer keywords, Pageable pageable);

	    Page<Product> findAllByPrice(Double keywords, Pageable pageable);

	    @Query("SELECT p FROM Product p WHERE p.category.name = ?1")
	    Page<Product> findByCategoryNameAndSortByPrice(String categoryName, Pageable pageable);
	    
	    @Query("SELECT new Report(o.category.name, SUM(o.price), COUNT(o)) FROM Product o GROUP BY o.category.name ORDER BY SUM(o.price) DESC")
	    List<Report> getInventoryByCategory();
	    
	    
	    
	    
	    
	    
	    // along
	    
	    
	    
	    List<Product> findByActivatedTrue(Sort sort);

	    @Query("SELECT p FROM Product p WHERE p.activated = true")
	    List<Product> findAllActivatedProducts();

	    @Query("SELECT p FROM Product p JOIN FETCH p.category  c JOIN FETCH p.supplier s WHERE p.activated = true")
	    List<Product> findAllActiveProductV1();
	    @Query("SELECT p FROM Product p JOIN FETCH p.category  c JOIN FETCH p.supplier s WHERE p.activated = true")
	    List<Product> findAllActiveProductV2(Sort sort);

	    @Query("SELECT p FROM Product p JOIN FETCH p.category c JOIN FETCH p.supplier s WHERE p.activated = true AND c.name = ?1")
	    List<Product> findAllActiveProductByCategoryName(String categoryName, Sort sort);

	    @Query("SELECT p FROM Product p WHERE p.activated = true AND p.supplier.name = ?1")
	    List<Product> findAllActiveProductBySupplierName(String supplierName, Sort sort);

	    @Query("SELECT p FROM Product p WHERE p.activated = true AND p.category.name = ?1 AND p.supplier.name = ?2")
	    List<Product> findAllActiveProductByCategoryAndSupplier(String categoryName, String supplierName, Sort sort);


	    @Query("SELECT p FROM Product p WHERE p.id = :id")
	    Product findProductById(@Param("id") String id);

//	    @Query("SELECT p.id, p.name, SUM(od.quantity) AS total_sold FROM OrderDetail od JOIN od.product p GROUP BY p.id, p.name ORDER BY total_sold DESC")
	    @Query("SELECT p.id, p.name, SUM(od.quantity) AS total_sold " +
	        "FROM OrderDetail od " +
	        "JOIN od.product p " +
	        "GROUP BY p.id, p.name " +
	        "ORDER BY SUM(od.quantity) DESC")
	    List<Object[]> thongKeSanPham();

	    @Query("SELECT c.name AS category_name, COUNT(od.id) AS total_sold " +
	            "FROM OrderDetail od " +
	            "JOIN od.product p " +
	            "JOIN p.category c " +
	            "GROUP BY c.name " +
	            "ORDER BY COUNT(od.id) DESC")
	    List<Object[]> thongketop3theloai(Pageable pageable);

	    @Query("SELECT p.id, p.name, SUM(od.quantity) AS total_sold " +
	            "FROM OrderDetail od " +
	            "JOIN od.product p " +
	            "JOIN od.order o " +
	            "JOIN o.user u " +
	            "WHERE u.sex = true " +
	            "GROUP BY p.id, p.name " +
	            "ORDER BY SUM(od.quantity) DESC")
	    List<Object[]> thongKeSanPhamGioiTinhTrue(Pageable pageable);

	    @Query("SELECT p.id, p.name, SUM(od.quantity) AS total_sold " +
	            "FROM OrderDetail od " +
	            "JOIN od.product p " +
	            "JOIN od.order o " +
	            "JOIN o.user u " +
	            "WHERE u.sex = false " +
	            "GROUP BY p.id, p.name " +
	            "ORDER BY SUM(od.quantity) DESC")
	    List<Object[]> thongKeSanPhamGioiTinhFalse(Pageable pageable);


	    @Query("SELECT " +
	            "    YEAR(o.createdate) AS Year, " +
	            "    MONTH(o.createdate) AS Month, " +
	            "    COUNT(o.id) AS TotalOrders, " +
	            "    SUM(o.amount) AS TotalRevenue " +
	            "FROM Order o " +
	            "GROUP BY YEAR(o.createdate), MONTH(o.createdate) " +
	            "ORDER BY YEAR(o.createdate), MONTH(o.createdate)")
	    List<Object[]> thongKeTongSoLuongDonHangTheoThangNam();


	    @Query("SELECT p FROM Product p WHERE p.name LIKE %:keywords% OR p.description LIKE %:keywords% OR p.id LIKE %:keywords%")
	    List<Product> searchProductsByNameOrDescription(@Param("keywords") String keywords);
}
