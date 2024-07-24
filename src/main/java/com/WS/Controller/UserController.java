package com.WS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping; // Thêm import này

import com.WS.Entity.Order;
import com.WS.Entity.OrderDetail;
import com.WS.Entity.User;
import com.WS.Service.SessionService;
import com.WS.Service.UserService;
import com.WS.Controller.*;
import com.WS.Dao.OrderDAO;
import com.WS.Dao.OrderDetailDAO;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	SessionService session;
	
	@Autowired
	private OrderDAO od;
	
	@Autowired
	private OrderDetailDAO ood;

	// Thêm phương thức hiển thị form đăng ký
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "user/register";
	}
	
	@RequestMapping("/logout")
	public String logOut(Model model) {
		userService.logOut();
		return "redirect:/home";
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam("phone") String phone, @RequestParam("password") String password, Model model) {
	    User user = userService.authenticate(phone, password);

	    if (user != null) {
	        session.set("user", user);
			String uri = session.get("security-uri",null);
	        if (uri != null) {
	        	session.remove("security-uri");
				return "redirect:" + uri;
			}else {
		        model.addAttribute("message", "Login successful");
		        return "redirect:/home"; 
			}
	    } else {
	        model.addAttribute("message", "Login failed: Invalid email or password");
	        return "user/login"; 
	    }
	}


	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") User user, Model model) {

		if (userService.findByPhone(user.getPhone()) != null) {
			model.addAttribute("message", "Registration failed: Phome already exists");
			return "user/register"; 
		}

		user.setActivated(true);
		user.setCreatedate(new Date());
		User newUser = userService.createUser(user);
		model.addAttribute("message", "Registration successful");
		model.addAttribute("user", newUser);
		return "redirect:/home"; 
	}
	
	
    @RequestMapping("/profile")
    public String goProfile(Model model) {
        User user = session.get("user", null);
        model.addAttribute("orders", od.findByUser(user));
        return "user/profile";
    }

    @RequestMapping("/order/details/{orderId}")
    public String orderDetails(@PathVariable int orderId, Model model) {
        Order order = od.findById(orderId).orElse(null);
        if (order != null) {
            List<OrderDetail> orderDetails = ood.findByOrder(order);
            for (OrderDetail orderDetail : orderDetails) {
				
			}
            model.addAttribute("order", order);
            model.addAttribute("orderDetails", orderDetails);
        }
        return "/user/order_details";
    }
    
    @RequestMapping("/order/cancel/{orderId}")
    public String cancelOrder(@PathVariable int orderId, Model model) {
        Order order = od.findById(orderId).orElse(null);
        order.setOrderstatus("Canceled");
        od.save(order);
        return "redirect:/users/profile";
    }
}
