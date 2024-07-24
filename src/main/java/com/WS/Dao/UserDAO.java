package com.WS.Dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.WS.Entity.User;




public interface UserDAO extends JpaRepository<User, Integer>{
    User findByPhone(String phone);

}
