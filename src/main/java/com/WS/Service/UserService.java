package com.WS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.WS.Dao.UserDAO;
import com.WS.Entity.User;

@Service
public class UserService {
    @Autowired
    private UserDAO userDao;
    
    @Autowired
    private SessionService session;

    public User authenticate(String phone, String password) {
        User user = userDao.findByPhone(phone);
        if(user != null && user.getPassword().equals(password)) {
        	return user;
        }
        return null;
        
    }
    
    public void logOut() {
    	session.remove("user");
    }
     	
    public User createUser(User user) {
        return userDao.save(user);
    }

    public User findByPhone(String phone) {
        return userDao.findByPhone(phone);
    }
    

    
}
