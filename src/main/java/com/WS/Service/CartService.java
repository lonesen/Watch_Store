package com.WS.Service;

import com.WS.Entity.CartItem;
import com.WS.Entity.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private static final String CART_SESSION_KEY = "cart";

    @Autowired
    SessionService sessionService;

    public List<CartItem> getCart() {
        return sessionService.get(CART_SESSION_KEY, new ArrayList<>());
    }

    public void addToCart(Product product, int quantity) {
        List<CartItem> cart = getCart();
        for (CartItem item : cart) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                sessionService.set(CART_SESSION_KEY, cart);
                return;
            }
        }
        cart.add(new CartItem(product, quantity));
        sessionService.set(CART_SESSION_KEY, cart);
    }

    public void removeFromCart(Product product) {
        List<CartItem> cart = getCart();
        cart.removeIf(item -> item.getProduct().getId().equals(product.getId()));
        sessionService.set(CART_SESSION_KEY, cart);
    }

    public void clearCart() {
        sessionService.remove(CART_SESSION_KEY);
    }

    public void updateCartItem(CartItem updatedItem) {
        List<CartItem> cart = getCart();
        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            if (item.getProduct().getId().equals(updatedItem.getProduct().getId())) {
                cart.set(i, updatedItem);
                sessionService.set(CART_SESSION_KEY, cart);
                return;
            }
        }
    }
}

