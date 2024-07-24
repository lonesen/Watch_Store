package com.WS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WS.Dao.ProductDAO;
import com.WS.Entity.Product;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductDAO dao;

    public Optional<Product> findProductById(String id) {
        return dao.findById(id);
    }
}