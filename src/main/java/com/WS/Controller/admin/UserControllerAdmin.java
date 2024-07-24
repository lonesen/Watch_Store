package com.WS.Controller.admin;

import com.WS.Dao.UserDAO;
import com.WS.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UserControllerAdmin {
    @Autowired
    UserDAO userDAO;

    @GetMapping("/OverViewUser")
    public String viewUser(Model model){
        List<User> users = userDAO.findAll();
        model.addAttribute("users",users);
        return "admin/user-overview";
    }
//    @GetMapping("/AddUser/edit/{id}")
//    public String addUser(@PathVariable("id") Integer id,Model model){
//        User user = userDAO.findById(id).orElse(null);
//        if (user != null){
//            model.addAttribute("user",user);
//        }
//    }
}
