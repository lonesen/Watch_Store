package com.WS.Controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.WS.Dao.OrderDAO;
import com.WS.Dao.OrderDetailDAO;
import com.WS.Entity.CartItem;
import com.WS.Entity.Order;
import com.WS.Entity.OrderDetail;
import com.WS.Entity.User;
import com.WS.Service.SessionService;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
    
    @Autowired
    private OrderDAO OD;
    
    @Autowired
    private OrderDetailDAO ODD;
    
    @Autowired
    SessionService session;

    @GetMapping("order/proceedToCheckout")
    public String checkout(HttpSession session, Model model) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart != null && !cart.isEmpty()) {
            model.addAttribute("cartItems", cart);
            double cartTotal = 0;
            for (CartItem cartItem : cart) {
                cartTotal += (cartItem.getQuantity() * cartItem.getProduct().getPrice());
            }
            model.addAttribute("cartTotal", cartTotal);
            return "user/checkout";
        }
        return "redirect:/home";
    }

    @PostMapping("/order/checkout")
    public String processCheckout(
                                  @RequestParam("city") String address,
                                  @RequestParam("address") String address2,
                                  Model model) {
        List<CartItem> cart = (List<CartItem>) session.get("cart",null);
        if (cart != null && !cart.isEmpty()) {
            User user = (User) session.get("user",null);
            
            double cartTotal = 0;
            for (CartItem cartItem : cart) {
                cartTotal += (cartItem.getQuantity() * cartItem.getProduct().getPrice());
            }
            
            Order order = new Order();
            order.setUser(user);
            order.setCreatedate(new Date());
            order.setAmount((float) cartTotal);
            order.setAddress(address + " " + address2);
            order.setOrderstatus("Waiting");
            
            try {
                OD.save(order);
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/order/proceedToCheckout";
            }
            
            try {
                for (CartItem cartItem : cart) {
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setOrder(order);
                    orderDetail.setProduct(cartItem.getProduct());
                    orderDetail.setQuantity(cartItem.getQuantity());
                    ODD.save(orderDetail);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/order/proceedToCheckout";
            }
            
//            session.remove("cart");
            
            session.set("latestOrder", order);
            
            return "redirect:/order/confirmation";
        }
        return "redirect:/home";
    }
    
    @GetMapping("/order/confirmation")
    public String confirmation( Model model) {
        Order latestOrder = (Order) session.get("latestOrder",null);
        if (latestOrder == null) {
            System.out.println("No latest order found in session.");
            return "redirect:/home";
        }

        model.addAttribute("order", latestOrder);
        System.out.println("Order found: id= " + latestOrder.getId());

        List<CartItem> cart = (List<CartItem>) session.get("cart",null);	

        model.addAttribute("cart", cart);
        session.remove("cart");
        return "user/confirmation";
    }


}
