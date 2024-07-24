package com.WS.Controller;

import com.WS.Entity.CartItem;
import com.WS.Entity.Product;
import com.WS.Service.CartService;
import com.WS.Service.ParamService;
import com.WS.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;
    


    @Autowired
    private ProductService productService;
    
    @Autowired
    private ParamService ps;

    @GetMapping("/cart/index")
    public String goToCart(Model model) {
    	List<CartItem> cart = cartService.getCart();
        model.addAttribute("cart", cart);
        return "user/cart";
    }
    
    
    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable("id") String id,Model model) {
        Product product = productService.findProductById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        cartService.addToCart(product, ps.getInt("quantity", 1));
        return "redirect:/cart/index";
    }

    @GetMapping("/remove-from-cart")
    public String removeFromCart(@RequestParam("id") String productId) {
        Product product = productService.findProductById(productId).orElseThrow(() -> new IllegalArgumentException("Invalid product ID"));
        cartService.removeFromCart(product);
        return "redirect:/cart/index";
    }
    
    @GetMapping("/increaseQuantity/{id}")
    public String increaseQuantity(@PathVariable("id") String id) {
        List<CartItem> cart = cartService.getCart();
        for (CartItem cartItem : cart) {
            if (cartItem.getProduct().getId().equals(id)) {
                int currentQuantity = cartItem.getQuantity();
                cartItem.setQuantity(currentQuantity + 1);
                cartService.updateCartItem(cartItem); 
                return "redirect:/cart/index";  
            }
        }
        return "redirect:/cart/index";
    }
    
    @GetMapping("/decreaseQuantity/{id}")
    public String decreaseQuantity(@PathVariable("id") String id) {
        List<CartItem> cart = cartService.getCart();
        for (CartItem cartItem : cart) {
            if (cartItem.getProduct().getId().equals(id)) {
                int currentQuantity = cartItem.getQuantity();
                if(currentQuantity>1) {
                	cartItem.setQuantity(currentQuantity - 1);
                }else {
                	cart.remove(cartItem);
                }
                
                cartService.updateCartItem(cartItem); 
                return "redirect:/cart/index";  
            }
        }
        return "redirect:/cart/index";
    }

    @GetMapping("/clear-cart")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart/index";
    }
    
    @GetMapping("/comfirmCart")
    public String comfirmCart() {
    	
        return "redirect:/cart/index";
    }
    
}
